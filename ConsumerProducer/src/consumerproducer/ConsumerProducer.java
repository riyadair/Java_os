package consumerproducer;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
public class ConsumerProducer {
    private static Buffer buffer = new Buffer();
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new ProducerTask());
        executor.execute(new ConsumerTask());
        executor.shutdown();
    }
    private static class ProducerTask implements Runnable{
        public void run(){
            int i = 1;
            try{
                while(true){
                    System.out.println("\nProducer write" + i);
                    buffer.write(i++);
                    Thread.sleep((int)Math.random() * 10000);
                }
            }
            catch(InterruptedException ex){
                    ex.printStackTrace();
            }
        }
    }
    private static class ConsumerTask implements Runnable{
        public void run(){
            try{
                while(true){
                    System.out.println("Consumer read " + buffer.read());
                    Thread.sleep((int)Math.random() * 10000);
                }
            }
            catch(InterruptedException ex){
                    ex.printStackTrace();
            }
        }
    }
    private static class Buffer{
        private static final int CAPACITY = 1;
        private java.util.LinkedList<Integer> queue = new java.util.LinkedList<Integer>();
        private static Lock lock = new ReentrantLock();
        private static Condition notEmpty = lock.newCondition();
        private static Condition notFull = lock.newCondition();
        public void write(int value){
            lock.lock();
            try{
                while(queue.size()==CAPACITY){
                    System.out.println("\nWaitfor notFull.");
                    notFull.await();
                }
                queue.offer(value);
                notEmpty.signal();
            }
            catch(InterruptedException ex){
                ex.printStackTrace();
            }
            finally{
                lock.unlock();
            }
        }
        public int read(){
            int value=0;
            lock.lock();
            try{
                while(queue.isEmpty()){
                    System.out.println("\nWait for notEmpty");
                    notEmpty.await();
                }
                value=queue.remove();
                notFull.signal();
            }
            catch(InterruptedException ex){
                ex.printStackTrace();
            }
            finally{
                lock.unlock();
                return value;
            }
        }
    }
}
