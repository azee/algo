import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadExecutir {
    public static ArrayBlockingQueue<String> files;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        shutdownExec();
    }

    private static void shutdownExec() {
        int size = 10;
        files = new ArrayBlockingQueue<String>(100);
        for (int i = 0; i < 5; i++) {
            files.add("Java " + i);
        }

        ThreadExecutir outer = new ThreadExecutir();
        ExecutorService executor = Executors.newFixedThreadPool(size);
        for (int i = 0; i < 3 * size; i++) {
            executor.submit(outer.new myThread());
        }
        System.out.println(executor.isShutdown());
        executor.shutdown();

        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            System.out.println("Awaiting for threads to complete!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (files.isEmpty())
            executor.shutdownNow();
        System.out.println(executor.isShutdown());

    }

    class myThread extends Thread {
        public void run() {

            String threadName = Thread.currentThread().getName();
            System.out.println("Thread " + threadName + "started running! ");
            try {
//                String uploadThis = files.poll();
                String uploadThis = files.take();
                System.out.println("I'm working " + threadName + " "
                        + uploadThis);
                // this.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("Thread " + threadName
                        + " finished running! ");
            }
        }
    }
}