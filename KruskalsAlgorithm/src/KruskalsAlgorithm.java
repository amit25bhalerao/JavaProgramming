import java.util.Scanner;

public class KruskalsAlgorithm
{
    static Scanner s = new Scanner(System.in);
    static int n,a[][],parent[],t[][],sum,count,u,v,i,j,k,min;

    static void read_adjacency()
    {
        System.out.println("Enter The Number Of Vertices");
        n=s.nextInt();

        System.out.println("Enter The Values Into The Adjacency Matrix");
        a=new int[n+1][n+1];

        for(i=1;i<=n;i++)
        {
            for(j=1;j<=n;j++)
            {
                a[i][j]=s.nextInt();

                if((a[i][j]==0)&&(i!=j))
                {
                    a[i][j]=Integer.MAX_VALUE;
                }
            }
        }
    }

    static void minimumcostspanningtree()
    {
        parent=new int[n+1];
        t=new int[n-1][3];
        count=0;
        sum=0;
        k=0;
        u=0;
        v=0;

        for(i=1;i<=n;i++)
        {
            parent[i]=i;
        }

        while(count!=(n-1))
        {
            min=Integer.MAX_VALUE;

            for(i=1;i<=n;i++)
            {
                for(j=1;j<=n;j++)
                {
                    if((a[i][j]!=0)&&(a[i][j]<min))
                    {
                        min=a[i][j];
                        u=i;
                        v=j;
                    }
                }
            }

            if(min==Integer.MAX_VALUE)
                break;

            i=u;
            while(parent[i]!=i)
                i=parent[i];

            j=v;
            while (parent[j]!=j)
                j=parent[j];

            if(i!=j)
            {
                t[k][0]=u;
                t[k][1]=v;
                t[k][2]=min;
                k++;
                count++;
                sum+=min;
                parent[j]=i;
            }

            a[u][v]=a[v][u]=Integer.MAX_VALUE;
        }

        if(count==(n-1))
        {
            System.out.println("The Minimum Cost Spanning Tree Is Displayed Below");
            System.out.println("S\tD\tW");

            for(i=0;i<n-1;i++)
            {
                System.out.println(t[i][0]+"\t"+t[i][1]+"\t"+t[i][2]);
            }

            System.out.println("The Minimum Cost Of Spanning Tree Is "+sum);
        }
        else
        {
            System.out.println("Minimum Spanning Tree Doesnt Exists");
        }
    }

    public static void main(String[] args)
    {
        read_adjacency();
        minimumcostspanningtree();
    }
}
