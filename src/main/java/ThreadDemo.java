public class ThreadDemo {

    // 1. By extending Thread class
    static class MyThread {
        @Override
        public void run() {
            System.out.println("Thread (by extending Thread) is running");
        }
    }

    // 2. By implementing Runnable interface
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("Thread (by implementing Runnable) is running");
        }
    }

    public static void main(String[] args) {
        // Start a thread by extending Thread class
        Thread t1 = new MyThread();
        t1.start();

        // Start a thread by implementing Runnable
        Thread t2 = new Thread(new MyRunnable());
        t2.start();

        // 3. Using lambda expression (Java 8+)
        Thread t3 = new Thread(() -> {
            System.out.println("Thread (by lambda) is running");
        });
        t3.start();
    }
}
