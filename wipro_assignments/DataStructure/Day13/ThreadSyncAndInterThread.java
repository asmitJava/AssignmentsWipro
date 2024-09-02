package dsa.assignment;

public class ThreadSyncAndInterThread {
    
    public static void main(String[] args) throws InterruptedException {
        Buffer buffer = new Buffer();

        Thread producerThread = new Thread(() -> {
            try {
                buffer.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                buffer.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();
    }

    static class Buffer {
        private final int CAPACITY = 5;
        private final int[] buffer = new int[CAPACITY];
        private int count = 0;

        public synchronized void produce() throws InterruptedException {
            for (int i = 0; i < 10; i++) {
                while (count == CAPACITY) {
                    wait();
                }
                buffer[count++] = i;
                System.out.println("Produced: " + i);
                notify();
                Thread.sleep(500);
            }
        }

        public synchronized void consume() throws InterruptedException {
            for (int i = 0; i < 10; i++) {
                while (count == 0) {
                    wait();
                }
                int num = buffer[--count];
                System.out.println("Consumed: " + num);
                notify();
                Thread.sleep(1000);
            }
        }
    }
}