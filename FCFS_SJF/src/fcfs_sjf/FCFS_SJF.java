package fcfs_sjf;

import javax.swing.JOptionPane;

public class FCFS_SJF {

    public static void main(String[] args) {
        int n=Integer.parseInt(JOptionPane.showInputDialog("Manu:\n[1] FCFS\n[2] SJF"));
        if(n==1){
            FCFS();
        }
        else if(n==2){
            SJF();
        }
        else{
            JOptionPane.showMessageDialog(null,"Error Occur","Error!",JOptionPane.ERROR_MESSAGE);
        }
    }
    private static void FCFS(){
        int bp[]=new int[5],wtp[]=new int[5],twt=0,n,temp,tat[]=new int[5],ttat=0;
        float awt,atat;
        String output1[]=new String[10],output2[]=new String[10];
        for(n=0;n<5;n++){
            bp[n]=Integer.parseInt(JOptionPane.showInputDialog("Enter Burst time for P"+(n+1)+" : "));
        }
        for(n=0;n<5;n++){
            if(n==0){
                wtp[n]=0;
                tat[n]=bp[n];
            }
            else{
                wtp[n]=wtp[n-1]+bp[n-1];
                tat[n]=wtp[n]+bp[n];
            }
            output1[n]="\nWaiting time for P"+(n+1)+" is : "+wtp[n];
            output2[n]="\nTurnaround time for P"+(n+1)+" is : "+tat[n];
        }
        for(n=0;n<5;n++){
            twt+=wtp[n];
            ttat+=tat[n];
        }
        awt=twt/5;
        atat=ttat/5;
        JOptionPane.showMessageDialog(null,output1,"FCFS",JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,output2,"FCFS",JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,"Average waiting time :"+awt+" Average Turnaround Time :"+atat,"FCFS",JOptionPane.INFORMATION_MESSAGE);
    }
    private static void SJF(){
        int bp[]=new int[5],bpi[]=new int[5],wtp[]=new int[5],twt=0,n,temp,temp1,tat[]=new int[5],ttat=0;
        float awt,atat;
        String output1[]=new String[10],output2[]=new String[10];
        for(n=0;n<5;n++){
            bp[n]=Integer.parseInt(JOptionPane.showInputDialog("Enter Burst time for P"+(n+1)+" : "));
            bpi[n]=n;
        }
        for(int i=0;i<5;i++){
            for(int j=i;j<5;j++){
                if(bp[i]>bp[j]){
                    temp=bp[i];
                    bp[i]=bp[j];
                    bp[j]=temp;
                    temp1=bpi[i];
                    bpi[i]=bpi[j];
                    bpi[j]=temp1;
                }
            }
        }
        for(n=0;n<5;n++){
            if(n==0){
                wtp[n]=0;
                tat[n]=bp[n];
            }
            else{
                wtp[n]=wtp[n-1]+bp[n-1];
                tat[n]=wtp[n]+bp[n];
            }
            output1[n]="\nWaiting time for P"+(bpi[n]+1)+" is : "+wtp[n];
            output2[n]="\nTurnaround time for P"+(bpi[n]+1)+" is : "+tat[n];
        }
        for(n=0;n<5;n++){
            twt+=wtp[n];
            ttat+=tat[n];
        }
        awt=twt/5;
        atat=ttat/5;
        JOptionPane.showMessageDialog(null,output1,"SJF",JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,output2,"SJF",JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,"Average waiting time :"+awt+" Average Turnaround Time :"+atat,"SJF",JOptionPane.INFORMATION_MESSAGE);

    }
    
}
