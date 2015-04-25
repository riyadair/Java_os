#include<cstdio>
#include<iostream>
using namespace std;
int main()
{
    int i,j,n1,n2,m[10],mi[10],p[10],flag,ch,temp,temp1;
    printf("Enter memory partition :\t");
    cin>>n1;
    cout<<"Enter memory size for :\t";
    for(i=1;i<=n1;i++)
    {
        cout<<"\nPartition "<<i<<" :\t";
        cin>>m[i];
        mi[i]=i;
    }
    cout<<"\nEnter process:\t";
    cin>>n2;
    cout<<"\nenter memory size for\n";
    for(i=1;i<=n2;i++)
    {
        cout<<"\nProcess "<<i<<" :\t";
        cin>>p[i];
    }
    cout<<"***********Manu:**********\n1.First Fit\n2.Best Fit\n3.Worst Fit\n4.Next Fit.\nEnter Choice :";
    cin>>ch;
    int count=0;
    switch(ch)
    {
        case 1:
            for(i=1;i<=n2;i++)
            {
                flag=1;
                for(j=1;j<=n1;j++)
                {
                    if(m[j]>=p[i])
                    {
                        cout<<"\nProcess "<<i<<" whose size is "<<p[i]<<"KB allocated at:\t"<<mi[j];
                        m[j]=m[j]-p[i];
                        break;
                    }
                    else
                    {
                        flag++;
                    }
                }
                if(flag>n1)
                {
                    cout<<"\nProcess "<<i<<" whose memory size is "<<p[i]<<" can't allocated\n";
                }
            }
            break;
        case 2:
            for(i=1;i<=n1;i++)
            {
                for(j=i;j<=n1;j++)
                {
                    if(m[i]>m[j])
                    {
                        temp=m[i];
                        m[i]=m[j];
                        m[j]=temp;
                        temp1=mi[i];
                        mi[i]=mi[j];
                        mi[j]=temp1;
                    }
                }
            }
            for(i=1;i<=n2;i++)
            {
                flag=1;
                for(j=1;j<=n1;j++)
                {
                    if(m[j]>=p[i])
                    {
                        cout<<"\nProcess "<<i<<" whose size is "<<p[i]<<"KB allocated at "<<mi[j];
                        m[j]=m[j]-p[i];
                        break;
                    }
                    else
                    {
                        flag++;
                    }
                }
                if(flag>n1)
                {
                    cout<<"\nProcess "<<i<<" whose memory size is "<<p[i]<<" can't allocated\n";
                }
            }
            break;
        case 3:
            for(i=1;i<=n1;i++)
            {
                for(j=i;j<=n1;j++)
                {
                    if(m[i]<m[j])
                    {
                        temp=m[i];
                        m[i]=m[j];
                        m[j]=temp;
                        temp1=mi[i];
                        mi[i]=mi[j];
                        mi[j]=temp1;
                    }
                }
            }
            for(i=1;i<=n2;i++)
            {
                flag=1;
                for(j=1;j<=n1;j++)
                {
                    if(m[j]>=p[i])
                    {
                        cout<<"\nProcess "<<i<<" whose size is "<<p[i]<<"KB allocated at "<<mi[j];
                        m[j]=m[j]-p[i];
                        break;
                    }
                    else
                    {
                        flag++;
                    }
                }
                if(flag>n1)
                {
                    cout<<"\nProcess "<<i<<" whose memory size is "<<p[i]<<" can't allocated\n";
                }
            }
            break;
        /*case 4:
            for(i=0;i<na;i++)
            {

            }
            break;*/
        default:
            printf("\nEnter valid choice.\n");
    }
    return 0;
}
