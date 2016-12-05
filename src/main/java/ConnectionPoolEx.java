import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by azee on 19.09.16.
 */
public class ConnectionPoolEx {

    interface ConnectionPool {
        public Connection getConnection();
    }

    interface Connection {
        void close();

        // this is the least interesting part to this problem
        Object execute(Object query);
    }

    interface ConnectionFactory {
        public Connection create();
    }

    final class RealConnectionFactory implements ConnectionFactory {
        @Override
        public Connection create() {
            return new DummyConnection();
        }
    }

    class ClosedConnection implements Connection{
        @Override
        public void close() {
            throw new RuntimeException();
        }

        @Override
        public Object execute(Object query) {
            throw new RuntimeException();
        }
    }

    class ConnectionWrapper implements Connection{
        RemovableConnectionPool pool;
        Connection connection;

        public ConnectionWrapper(RemovableConnectionPool pool, Connection connection) {
            this.pool = pool;
            this.connection = connection;
        }

        @Override
        public Object execute(Object query) {
            connection.execute(query);
            return new Object();
        }

        public void close(){
            pool.remove(connection);
            connection = new ClosedConnection();
        }

        public Connection getConnection() {
            return connection;
        }
    }

    interface RemovableConnectionPool extends ConnectionPool{
        public void remove(Connection connection);
    }

    // You must implement
    public class SingleListConnectionPool implements RemovableConnectionPool, ConnectionPool {
        Queue<Connection> connections = new ConcurrentLinkedQueue<>();
        ConnectionFactory factory = new RealConnectionFactory();
        public SingleListConnectionPool(){
            for (int i = 0; i < 10; i++){
                connections.add(factory.create());
            }
        }

        @Override
        public Connection getConnection(){
            return new ConnectionWrapper(this, connections.poll());

        }

        @Override
        public void remove(Connection connection) {
            connections.add(connection);
        }
    }

    //Class DummyConnection
    class DummyConnection implements Connection{
        @Override
        public void close() {

        }

        @Override
        public Object execute(Object query) {
            return null;
        }
    }


// We must be able to support this pattern

    public void doStuff(){
        ConnectionPool connectionPool = new SingleListConnectionPool();
        Connection con = connectionPool.getConnection();
        try {
            con.execute("query");
        } finally {
            con.close();
        }
        con.execute("query"); // should fail with exception
    }

}
