package accountwithsync;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.*;
import java.util.concurrent.locks.ReentrantLock;

public class AccountWithSync {
    private static Account account = new Account();
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for(int i=0;i<100;i++){
            executor.execute(new AddAPenny());
        }
        executor.shutdown();
        while(!executor.isTerminated()){
        }
        System.out.println("What is Balance ? " + account.getBalance());
    }
    private static class AddAPenny implements Runnable{
        public void run(){
            account.deposit(1);
        }
    }
    private static class Account{
        private Lock lock = new ReentrantLock();
        private int balance = 0;
        public int getBalance(){
            return balance;
        }
        public void deposit(int amount){
            lock.lock();
            try{
                int newBalance = balance + amount;
                Thread.sleep(5);
                balance = newBalance; 
            }
            catch(InterruptedException ex){
            }
            finally{
                lock.unlock();
            }
        }
    }
}
