import java.util.Scanner;

public class Prims
{

    // Function to find the vertex with minimum key value
    static int findMinKey(int[] key, boolean[] mstSet, int V) 
    {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < V; v++) 
        {
            if (!mstSet[v] && key[v] < min) 
            {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // Function to print the constructed MST
    static void printMST(int[] parent, int[][] graph, int V) 
    {
        int totalCost = 0;
        System.out.println("Edge   Weight");
        for (int i = 1; i < V; i++) 
        {
            System.out.println(parent[i] + " - " + i + "    " + graph[i][parent[i]]);
            totalCost += graph[i][parent[i]];
        }
        System.out.println("Total cost of MST: " + totalCost);
    }

    // Function to implement Prim's algorithm
    static void primMST(int[][] graph, int V) 
    {
        int[] parent = new int[V];  // Stores MST
        int[] key = new int[V];     // Key values used to pick minimum weight edge
        boolean[] mstSet = new boolean[V]; // To represent set of vertices included in MST

        // Initialize all keys as INFINITE
        for (int i = 0; i < V; i++) 
        {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        // Always include first vertex in MST
        key[0] = 0;     // Make key 0 so that this vertex is picked first
        parent[0] = -1; // First node is always root of MST

        // The MST will have V vertices
        for (int count = 0; count < V - 1; count++) 
        {
            // Pick the minimum key vertex not yet included in MST
            int u = findMinKey(key, mstSet, V);
            mstSet[u] = true;

            // Update key and parent of the adjacent vertices
            for (int v = 0; v < V; v++) 
            {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) 
                {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        // Print the constructed MST
        printMST(parent, graph, V);
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        // Input number of vertices
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        int[][] graph = new int[V][V];

        // Input adjacency matrix
        System.out.println("Enter adjacency matrix:");
        for (int i = 0; i < V; i++) 
        {
            for (int j = 0; j < V; j++) 
            {
                graph[i][j] = sc.nextInt();
                if (i == j) {
                    graph[i][j] = 0; // No self-loop
                }
            }
        }

        // Run Prim's MST
        primMST(graph, V);

        sc.close();
    }
}
