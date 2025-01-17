import java.util.Scanner;

public class DijkstrasAlgorithm
{
    static int V,src;

    int minDistance(int dist[], Boolean sptSet[])
    {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
        {
            if (!sptSet[v] && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }
        }

        return min_index;
    }

    void printSolution(int dist[], int n)
    {
        for (int i = 0; i < V; i++)
        {
            System.out.println("Vertex"+i + " Is At A Distance Of " + dist[i]+" From "+src);
        }
    }

    void dijkstra(int graph[][], int src)
    {
        int dist[] = new int[V];

        Boolean sptSet[] = new Boolean[V];

        for (int i = 0; i < V; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[src] = 0;

        for (int count = 0; count < V - 1; count++)
        {
            int u = minDistance(dist, sptSet);

            sptSet[u] = true;

            for (int v = 0; v < V; v++)
            {
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
            }

        }

        printSolution(dist, V);
    }

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);

        int n;

        System.out.println("Enter The Number Of Nodes In The Graph");
        n=s.nextInt();

        V=n;

        System.out.println("Enter The Source Vertex");
        src=s.nextInt();

        if(src>=n)
        {
            System.out.println("Invalid Input Entered..Program Will Terminate");
            System.exit(0);
        }

        System.out.println("Enter The Values Into The Adjacency Matrix");

        int graph[][] = new int[n][n];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                graph[i][j]=s.nextInt();
            }
        }

        DijkstrasAlgorithm d = new DijkstrasAlgorithm();
        d.dijkstra(graph, src);
    }
}


