package bankers_algorithm;
import java.util.Scanner;
public class Bankers_Algorithm {

    
    public static void main(String[] args) {
        int noRe,noP;
        Scanner ss=new Scanner(System.in);
        System.out.println("Give the No of Process");
        noP=ss.nextInt();
        System.out.println("Give the no Resource");
        noRe=ss.nextInt();
        String output[] = new String[noP];
        int avai[] = new int[noRe];
        int allo [][]= new int [noP][noRe];
        int need[][] = new int[noP][noRe];
        int max[][] = new int[noP][noRe];
        for(int i=0;i<noRe;i++)
        {
            System.out.printf("Available[%d]:",i);
            avai[i]=ss.nextInt();
        }
        for(int i=0;i<noP;i++)
        {
            for(int j=0;j<noRe;j++)
            {
              System.out.printf("Allocation[%d][%d]:",i,j);
              allo[i][j]=ss.nextInt();
              System.out.printf("Max[%d][%d]:",i,j);
              max[i][j]=ss.nextInt();
              need[i][j]=max[i][j]-allo[i][j];
            }
        }
        int count=0;
        for(int i=0;i<noP;i++)
        {
            for(int j=0;j<noRe;j++)
            {
                if(avai[i]==need[i][j])
                {
                    count++;
                }
            }
        }
        if(count==noRe)
        {
            
        }
    }
    
}
