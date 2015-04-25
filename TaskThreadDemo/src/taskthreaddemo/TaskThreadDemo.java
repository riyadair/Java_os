package taskthreaddemo;
public class TaskThreadDemo {

    
    public static void main(String[] args) {
        PrintChar printA = new PrintChar('a',100);
        PrintChar printB = new PrintChar('b',100);
        PrintNum print100 = new PrintNum(100);
        
        Thread thread1 = new Thread(printA);
        Thread thread2 = new Thread(printB);
        Thread thread3 = new Thread(print100);
        
        thread1.start();
        thread2.start();
        thread3.start();
    }
    class PrintChar implements Runnable{
        private char ch;
        private int time;
        PrintChar(char c,int t){
                ch=c;
                time=t;
            }
        public void run(){
            for(int i=0;i<time;i++){
                System.out.println(ch);
            }
        }
    }
    class PrintNum implements Runnable{
        private int num;
        PrintNum(int n){
            num=n;
        }
        public void run(){
            for(int i=1;i<=num;i++)
                System.out.println(" "+i);
        }
    }
    
}
