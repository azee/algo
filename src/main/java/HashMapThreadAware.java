//package ru.greatbit.concurrent.practice;
//
//import org.junit.Test;
//
//import java.util.*;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.*;

/**
 * Created by azee on 23.04.15.
 */
public class HashMapThreadAware {

//    @Test
//    public void hashMapIsNotThreadSafeTest() throws InterruptedException {
//        HashMap<Object, String> map = new HashMap<Object, String>();
//        hashMapThreadAwareTest(map);
//        assertThat(map.size(), is(0));
//    }
//
//    @Test(timeout = 5000)
//    public void concurrentHashMapIsThreadSafeTest() throws InterruptedException {
//        Map<Object, String> map = new ConcurrentHashMap<Object, String>();
//        hashMapThreadAwareTest(map);
//        assertThat(map.size(), is(1));
//    }
//
//    /**
//     * The idea is the following:
//     * 1. Create class that returns the same hashCode and executes "equals()"
//     * function for a long time (using locks). Objects of this class will be used as keys.
//     * 2. We add the first value into the map (equals() is not called)
//     * 3. We add the second value to the map in a separate thread. As table in the same bucket is not empty
//     * keys comparison will take place and "equals()" method will be called. Separate thread will "stuck" in
//     * an infinitive loop. The previously added value will be in separate thread stack as an object to compare with.
//     * 4. While separate thread executing "equals()" - we remove the first value from the map in the main thread.
//     * 5. We release the separate thread, "equals()" function finish execution and returns true. In "put()" value
//     * of the first and the second entries are swapped. But as the first value us already removed fom the map
//     * (table in the map doesn't contain the link to the object any more) map will remain empty.
//     * If operations were synced we will have map.size() = 1. But we have 0.
//     * @param map
//     * @throws InterruptedException
//     */
//    public void hashMapThreadAwareTest(final Map<Object, String> map) throws InterruptedException {
//        final Lock lock = new ReentrantLock();
//        final boolean[] waiting = new boolean[1];
//
//        //Create a key class that wll always return the same hash code and "stuck" on equals() call
//        class CorruptingHash{
//            @Override
//            public int hashCode() {
//                return 1;
//            }
//
//            @Override
//            public boolean equals(Object obj) {
//                //Need a waiting lock so this thread will be executed BEFORE previous item was removed
//                waiting[0] = false;
//
//                //Wait until previous value is not removed
//                while (!lock.tryLock()){
//                    /* Do Nothing */
//                }
//                return true;
//            }
//        }
//
//        //We create 2 keys - first will be removed from the hash
//        CorruptingHash corruptingHashToRemove = new CorruptingHash();
//        final CorruptingHash corruptingHash = new CorruptingHash();
//
//        //Put the first value so that when we will add another one will get into the bucket lookup section of a hash map
//        map.put(corruptingHashToRemove, "Value 1");
//
//        //Create a lock to make "Add another value" thread "stuck" on equals() function
//        lock.lock();
//
//        //Create a boolean lock (accessed from inner class) to make main thread wait
//        // until additional thread will start executing
//        waiting[0] = true;
//
//        //In this thread we will add a new value to the map
//        //The thread will stuck on equals() call
//        //Meanwhile we will remove the first item from the map table
//        Thread corrupted = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Put value 2 started");
//                map.put(corruptingHash, "Value 2");
//                System.out.println("Put value 2 finished");
//            }
//        });
//        corrupted.start();
//
//        //Wait until the "currupted" thread is called
//        while (waiting[0]){
//            /* Do Nothing */
//        }
//
//        System.out.println("Remove value 1 started");
//        //Remove first element while the second is being added
//        map.remove(corruptingHashToRemove);
//        System.out.println("Remove value 1 finished");
//
//        //Release lock to continue put() execution in "corrupted" thread
//        lock.unlock();
//
//        //Wait until "corrupted" thread is finished
//        corrupted.join();
//    }


//    public void hashMapThreadAwareTest(final Map<Object, String> map) throws InterruptedException {
//        final Lock lock = new ReentrantLock();
//        final boolean[] waiting = new boolean[1];
//
//
//
//        class CorruptingHash{
//            @Override
//            public int hashCode() {
//                return 1;
//            }
//
//            @Override
//            public boolean equals(Object obj) {
//                waiting[0] = false;
//                while (!lock.tryLock()){
//                    System.out.println("Waiting for lock");
//                }
//                return true;
//            }
//        }
//
////        class SameHash {
////            @Override
////            public int hashCode() {
////                return 33;
////            }
////        }
//
//        CorruptingHash corruptingHashToRemove = new CorruptingHash();
//        final CorruptingHash corruptingHash = new CorruptingHash();
////        SameHash sameHash = new SameHash();
//
//        map.put(corruptingHashToRemove, "Value 1");
//
//        lock.lock();
//        waiting[0] = true;
//        Thread corrupted = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Put value 3 started");
//                map.put(corruptingHash, "Value 3");
//                System.out.println("Put value 3 finished");
//            }
//        });
//        corrupted.start();
//
//        //ToDo: wait until map.put is called
//        while (waiting[0]){
//            System.out.println("Waiting main thread");
//        }
//
//        System.out.println("Remove value 1 started");
//        map.remove(corruptingHashToRemove);
//        System.out.println("Remove value 1 finished");
//
//        System.out.println("Put value 2 started");
//        map.put(new Object(), "Value 2");
//        System.out.println("Put value 2 finished");
//
//        lock.unlock();
//        corrupted.join();
//    }

//    @Test
//    public void hashMapThreadAwareTest() throws InterruptedException {
//
//
//        //final Map<CorruptingHash, Object> map = new HashMap<CorruptingHash, Object>();
//        final Map<Object, String> map = new ConcurrentHashMap<Object, String>();
//
//        class CorruptingHash{
//            String value;
//
//            public CorruptingHash(String value) {
//                this.value = value;
//            }
//
//            @Override
//            public int hashCode() {
//                lastVal = value;
//                return 1;
//            }
//
//            @Override
//            public boolean equals(Object obj) {
//                return true;
//            }
//        }
//
//        ExecutorService executor = Executors.newFixedThreadPool(500);
//        for (int i = 0; i < 500; i++) {
//            Runnable worker = new Runnable() {
//                @Override
//                public void run() {
//                    String uuid = UUID.randomUUID().toString();
//                    assertThat(map.put(new CorruptingHash(uuid), uuid), is(lastVal));
//                }
//            };
//            executor.execute(worker);
//        }
//        executor.shutdown();
//        // Wait until all threads are finish
//        executor.awaitTermination(30, TimeUnit.SECONDS);
//    }

//    @Test
//    public void hashMapThreadAwareTest() throws InterruptedException {
//        final String KEY = "Key";
//
//        final Map<String, String> map = new HashMap<String, String>();
//        //final Map<String, String> map = new ConcurrentHashMap<String, String>(500, 1);
//
//        ExecutorService executor = Executors.newFixedThreadPool(500);
//        for (int i = 0; i < 500; i++) {
//            Runnable worker = new Runnable() {
//                @Override
//                public void run() {
//                    synchronized (this) {
//                        String value = UUID.randomUUID().toString();
//                        assertThat(map.put(KEY, value), is(value));
//                    }
//                }
//            };
//            executor.execute(worker);
//        }
//        executor.shutdown();
//        // Wait until all threads are finish
//        executor.awaitTermination(30, TimeUnit.SECONDS);
//    }

//    @Test
//    public void hashMapThreadAwareTest() throws InterruptedException {
//        class CorruptingHash{
//            @Override
//            public int hashCode() {
//                assertFalse(inUse);
//                inUse = true;
//                try {
//                    sleep(100);
//                } catch (InterruptedException e) {
//                    //ToDo: fail test
//                    e.printStackTrace();
//                }
//                inUse = false;
//                return counter++;
//            }
//        }
//
//        //final Map<CorruptingHash, Object> map = new HashMap<CorruptingHash, Object>();
//        final Map<CorruptingHash, Object> map = new ConcurrentHashMap<CorruptingHash, Object>(500, 1);
//        ExecutorService executor = Executors.newFixedThreadPool(500);
//        for (int i = 0; i < 500; i++) {
//            Runnable worker = new Runnable() {
//                @Override
//                public void run() {
//                    map.put(new CorruptingHash(), new Object());
//                }
//            };
//            executor.execute(worker);
//        }
//        executor.shutdown();
//        // Wait until all threads are finish
//        executor.awaitTermination(30, TimeUnit.SECONDS);
//    }

//    @Test
//    public void shouldBreakThreadSafetyOfHashMap() throws InterruptedException {
//
//        //final Map<Integer, String> map = new HashMap<Integer, String>();
//        final Map<Integer, String> map = new ConcurrentHashMap<Integer, String>();
//        final CountDownLatch countDownLatch = new CountDownLatch(1);
//
//        for (int i = 0; i < 1000; i++) {
//
//            final int number = i;
//
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//
//                    boolean contains;
//
//                    do {
//
//                        map.put(number, "test");
//
//                    } while ((contains = (map.remove(number) != null)) && countDownLatch.getCount() > 0);
//
//                    if(!contains) {
//                        System.out.println("Missing Number: " + number);
//                    }
//
//                    countDownLatch.countDown();
//
//                }
//            }).start();
//
//        }
//
//        assertTrue(countDownLatch.await(30, TimeUnit.SECONDS));
//
//    }


}
