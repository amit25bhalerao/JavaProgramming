import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Edge
{
    int source, dest;

    public Edge(int source, int dest)
    {
        this.source = source;
        this.dest = dest;
    }
}

class Graph
{
    List<List<Integer>> adjList = null;

    Graph(List<Edge> edges, int N)
    {
        adjList = new ArrayList<>(N);

        for (int i = 0; i < N; i++)
        {
            adjList.add(i, new ArrayList<>());
        }

        // add edges to the undirected graph
        for (int i = 0; i < edges.size(); i++)
        {
            int src = edges.get(i).source;
            int dest = edges.get(i).dest;

            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
    }
}

public class HamiltonianCycle
{
    public static void printAllHamiltonianPaths(Graph g, int v, boolean[] visited, List<Integer> path, int N)
    {
        // if all the vertices are visited, then
        // hamiltonian path exists
        if (path.size() == N)
        {
            // print hamiltonian path
            for (int i : path)
                System.out.print(i + " ");
            System.out.println();

            return;
        }

        // Check if every edge starting from vertex v leads
        // to a solution or not
        for (int w : g.adjList.get(v))
        {
            // process only unvisited vertices as hamiltonian
            // path visits each vertex exactly once
            if (!visited[w])
            {
                visited[w] = true;
                path.add(w);

                // check if adding vertex w to the path leads
                // to solution or not
                printAllHamiltonianPaths(g, w, visited, path, N);

                // Backtrack
                visited[w] = false;
                path.remove(path.size()-1);
            }
        }
    }

    /**
     *  (new Edge(0, 1), new Edge(0, 2), new Edge(0, 4),
     *                 new Edge(1, 2), new Edge(1, 5),
     *                 new Edge(2, 3), new Edge(2, 4),
     *                 new Edge(3,4), new Edge(3,5)
     * @param args
     */
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);

        List<Edge> edges = Arrays.asList
                ( new Edge(0,1), new Edge(0,2), new Edge(0,3),
                  new Edge(1,2), new Edge(1, 4),
                  new Edge(2,3), new Edge(2, 4),
                  new Edge(3,4), new Edge(3, 5)
        );

        final int N = 6;

        Graph g = new Graph(edges, N);

        System.out.println("Enter The Starting Vertex");
        int start = s.nextInt();

        List<Integer> path = new ArrayList<>();
        path.add(start);

        boolean visited[] = new boolean[N];
        visited[start] = true;

        System.out.println("The List Of Hamiltonian Cycle Paths Are Displayed Below");

        printAllHamiltonianPaths(g, start, visited, path, N);
    }
}