package dsa.assignment;

public class SyncBlockandMethod {

    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                account.deposit(100);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                account.withdraw(50);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Final balance: " + account.getBalance());
    }

    static class BankAccount {
        private int balance = 0;

        public synchronized void deposit(int amount) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        }

        public synchronized void withdraw(int amount) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdrawn: " + amount);
            } else {
                System.out.println("Insufficient balance to withdraw " + amount);
            }
        }

        public synchronized int getBalance() {
            return balance;
        }
    }
}