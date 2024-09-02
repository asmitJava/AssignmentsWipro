package dsa.assignment;

public class ThreadStatesTransitions {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000); 
                synchronized (ThreadStatesTransitions.class) {
                    ThreadStatesTransitions.class.wait(); 
                }
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("Thread state: " + thread.getState()); 

        thread.start();
        Thread.sleep(500);

        System.out.println("Thread state: " + thread.getState()); 

        synchronized (ThreadStatesTransitions.class) {
            ThreadStatesTransitions.class.notify(); }
        
        Thread.sleep(1500); 

        System.out.println("Thread state: " + thread.getState()); 
    }
}