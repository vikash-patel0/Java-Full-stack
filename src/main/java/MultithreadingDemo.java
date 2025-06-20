import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.concurrent.locks.*;

public class MultithreadingDemo {
    public static void main(String[] args) throws InterruptedException {
        // 1. Basic Thread Creation
        System.out.println("=== Basic Threads ===");
        new MyThread().start();
        new Thread(new MyRunnable()).start();
        new Thread(() -> System.out.println("Lambda Thread running")).start();

        // 2. Thread Synchronization
        System.out.println("\n=== Synchronization ===");
        Counter counter = new Counter();
        Thread t1 = new Thread(counter::increment);
        Thread t2 = new Thread(counter::increment);
        t1.start(); t2.start();
        t1.join(); t2.join();
        System.out.println("Synchronized count: " + counter.getCount());

        // 3. Atomic Operations
        System.out.println("\n=== Atomic Operations ===");
        AtomicInteger atomicCount = new AtomicInteger();
        ExecutorService pool = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 1000; i++) {
            pool.submit(atomicCount::incrementAndGet);
        }
        pool.shutdown();
        pool.awaitTermination(3, TimeUnit.SECONDS);
        System.out.println("Atomic count: " + atomicCount.get());

        // 4. Producer-Consumer Pattern
        System.out.println("\n=== Producer-Consumer ===");
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }

    // Thread by extending Thread class
    static class MyThread {
        @Override
        public void run() {
            System.out.println("Thread class running");
        }
    }

    // Thread by implementing Runnable
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("Runnable running");
        }
    }

    // Synchronized counter
    static class Counter {
        private int count = 0;
        private final Lock lock = new ReentrantLock();

        public synchronized void increment() {
            count++;
        }

        public void lockIncrement() {
            lock.lock();
            try {
                count++;
            } finally {
                lock.unlock();
            }
        }

        public int getCount() {
            return count;
        }
    }

    // Producer-Consumer implementation
    static class Producer implements Runnable {
        private final BlockingQueue<Integer> queue;
        Producer(BlockingQueue<Integer> q) { queue = q; }

        public void run() {
            try {
                for (int i = 0; i < 5; i++) {
                    queue.put(i);
                    System.out.println("Produced: " + i);
                    Thread.sleep(200);
                }
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }

    static class Consumer implements Runnable {
        private final BlockingQueue<Integer> queue;
        Consumer(BlockingQueue<Integer> q) { queue = q; }

        public void run() {
            try {
                for (int i = 0; i < 5; i++) {
                    Integer value = queue.take();
                    System.out.println("Consumed: " + value);
                    Thread.sleep(500);
                }
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
