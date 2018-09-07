import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by azee on 24.05.16.
 */
public class WaitNotify {

    public static void main(String... args){
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(20);
        List<Message> messages = new ArrayList<>(10);
        for (int i = 0; i < 10; i++){
            Message message = new Message(Integer.toString(i));
            messages.add(message);
            executor.execute(new Waiter(message));
        }
        messages.stream().map(Notifier::new).forEach(executor::execute);
        executor.shutdown();
    }

    static class Waiter implements Runnable{
        final Message message;

        public Waiter(Message message) {
            this.message = message;
        }

        @Override
        public void run() {
            System.out.println("Waiting for message " + message.getText());
            synchronized (message){
                try {
                    message.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Message processed " + message.getText());
        }
    }

    static class Notifier implements Runnable{
        final Message message;

        public Notifier(Message message) {
            this.message = message;
        }

        @Override
        public void run() {
            System.out.println("Notify for message " + message.getText());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (message){
                message.notify();
            }
            System.out.println("Message processed " + message.getText());
        }
    }

    static class Message{
        private String text;

        public Message(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

}
