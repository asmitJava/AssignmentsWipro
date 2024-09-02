package dsa.assignment;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolIO {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {
            Runnable task = new Task(i);
            executor.submit(task);
        }

        executor.shutdown();
    }

    static class Task implements Runnable {
        private final int taskId;

        public Task(int taskId) {
            this.taskId = taskId;
        }

        @Override
        public void run() {
            System.out.println("Task " + taskId + " started");
            try {
                // Simulate some task
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task " + taskId + " completed");
        }
    }
}