#include<cstdio>
#include<iostream>
#include<queue>
using namespace std;
int main()
{
    int re,pro;
    printf("Enter total number of process:");
    cin>>pro;
    printf("Enter total number of resource:");
    cin>>re;
    int avai[re],allo[pro][re],max[pro][re],need[pro][re];
    printf("Available  :");
    for(int i=0;i<re;i++)
    {
        cin>>avai[i];
    }
    printf("Allocation :");
    for(int i=0;i<pro;i++)
    {
        for(int j=0;j<re;j++)
        {
          cin>>allo[i][j];
        }
    }
    printf("Max :");
    for(int i=0;i<pro;i++)
    {
        for(int j=0;j<re;j++)
        {
            cin>>max[i][j];
            need[i][j]=max[i][j]-allo[i][j];
        }
    }
    /*cout<<"Need :\n";
    for(int i=0;i<pro;i++)
    {
        for(int j=0;j<re;j++)
        {
           cout<<need[i][j];
        }
        cout<<"\n";
    }*/
    int flag[pro],se[pro];
    for(int i=0;i<pro;i++)
        flag[i]=0;
    int count1=0,count;
    //do
    //{
        for(int k=0;k<pro;k++)
        {
            for(int i=0;i<pro;i++)
            {
                count=0;
                if(flag[i]==0)
                {
                    //count=0;
                    for(int j=0;j<re;j++)
                    {
                        if(avai[j]>=need[i][j])
                            count++;
                    }
                    if(count==re)
                    {
                        count1++;
                        se[count1-1]=i;
                        flag[i]=1;
                        for(int j=0;j<re;j++)
                            avai[j]+=allo[i][j];
                        break;
                    }
                }
            }
        }
        if(count1!=pro)
        {
            printf("\n---------------IT'S AN UNSAFE STATE---------------");
            //break;
        }
    //}
    //while(true);
    if(count1==pro)
    {
       printf("\n *******************IT'S A SAFE STATE*******************");
       printf("\n The safe sequence is....\n");
       for(int i=0;i<pro;i++)
        printf("\t P%d",se[i]);
       printf("\n");
       printf("\n The available matrix is now : ");
       for(int i=0;i<re;i++)
        printf("\t %d",avai[i]);
    }
    return 0;
}
