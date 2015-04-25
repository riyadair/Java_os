package process_scheduling;

import javax.swing.JOptionPane;
public class Process_scheduling {

    
    public static void main(String[] args) {
        int m = Integer.parseInt(JOptionPane.showInputDialog("Manu:\n[1]FCFS,\n[2]SJF\n[3]RR\n[4]Priority"));
        if(m==1)
        {
            FCFS();
        }
        else if(m==2)
        {
            SJF();
        }
        else if(m==3)
        {
            RR();
        }
        else if(m==4)
        {
            P();
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Error Message","Error!",JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void FCFS()
    {
        int bp[] = new int[5],wtp[]=new int[5],twt=0,awt,num;
        String output1[]=new String[10];
        for(num=0;num<5;num++){
            bp[num]=Integer.parseInt(JOptionPane.showInputDialog("Enter Burst time for "+(num+1)+" Process : "));
        }
        for(num=0;num<5;num++){
            if(num==0){
                wtp[num]=0;
            }
            else{
                wtp[num]=wtp[num-1]+bp[num-1];
            }
            output1[num]="\nWaiting time for P"+(num+1)+" is : "+wtp[num];
        }
        for(num=0;num<5;num++){
            twt=twt+wtp[num];
        }
        awt=twt/5;
        JOptionPane.showMessageDialog(null,output1,"FCFS",JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,"Average waiting time "+awt,"FCFS",JOptionPane.INFORMATION_MESSAGE);
    }
    public static void SJF()
    {
        int bp[] = new int[5],bpi[]=new int[5],wtp[]=new int[5],twt=0,awt,num,temp=0,temp1=0;
        String output1[]=new String[10];
        for(num=0;num<5;num++){
            bp[num]=Integer.parseInt(JOptionPane.showInputDialog("Enter Burst time for P"+(num+1)+" : "));
            bpi[num]=num;
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
        for(num=0;num<5;num++){
            if(num==0){
                wtp[num]=0;
            }
            else{
                wtp[num]=wtp[num-1]+bp[num-1];
            }
            output1[num]="\nWaiting time for P"+(bpi[num]+1)+" is : "+wtp[num];
        }
        for(num=0;num<5;num++){
            twt=twt+wtp[num];
        }
        awt=twt/5;
        JOptionPane.showMessageDialog(null,output1,"SJF",JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,"Average waiting time "+awt,"SJF",JOptionPane.INFORMATION_MESSAGE);
    }
    public static void RR()
    {
        
    }
    public static void P()
    {
        int bp[] = new int[5],bpi[]=new int[5],wtp[]=new int[5],pri[]=new int[5],twt=0,awt,num,temp=0,temp1=0,temp2=0;
        String output1[]=new String[10];
        for(num=0;num<5;num++){
            bp[num]=Integer.parseInt(JOptionPane.showInputDialog("Enter Burst time for P"+(num+1)+" : "));
            bpi[num]=num;
        }
        for(num=0;num<5;num++){
            pri[num]=Integer.parseInt(JOptionPane.showInputDialog("Enetr Priority for P"+(num+1)+" : "));
        }
        for(int i=0;i<5;i++){
            for(int j=i;j<5;j++){
                if(pri[i]<pri[j]){
                    temp2=pri[i];
                    pri[i]=pri[j];
                    pri[j]=temp2;
                    temp=bp[i];
                    bp[i]=bp[j];
                    bp[j]=temp;
                    temp1=bpi[i];
                    bpi[i]=bpi[j];
                    bpi[j]=temp1;
                }
            }
        }
         for(num=0;num<5;num++){
            if(num==0){
                wtp[num]=0;
            }
            else{
                wtp[num]=wtp[num-1]+bp[num-1];
            }
            output1[num]="\nWaiting time for P"+(bpi[num]+1)+" is : "+wtp[num];
        }
        for(num=0;num<5;num++){
            twt=twt+wtp[num];
        }
        awt=twt/5;
        JOptionPane.showMessageDialog(null,output1,"Priority",JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,"Average waiting time "+awt,"Priority",JOptionPane.INFORMATION_MESSAGE);
    }
}
