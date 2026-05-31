import java.util.*;

public class SkillBridgeGraph {

    private int vertices;
    private LinkedList<Integer>[] adjList;

    SkillBridgeGraph(int v) {
        vertices = v;
        adjList = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    void addEdge(int source, int destination) {
        adjList[source].add(destination);
        adjList[destination].add(source);
    }

    void BFS(int startVertex) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int neighbor : adjList[vertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    void DFSUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int neighbor : adjList[vertex]) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited);
            }
        }
    }

    void DFS(int startVertex) {
        boolean[] visited = new boolean[vertices];
        DFSUtil(startVertex, visited);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of content items: ");
        int n = sc.nextInt();

        SkillBridgeGraph graph = new SkillBridgeGraph(n);

        System.out.print("Enter number of similarity connections: ");
        int edges = sc.nextInt();

        System.out.println("Enter content similarity pairs:");

        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }

        System.out.print("Enter starting content ID: ");
        int start = sc.nextInt();

        System.out.println("\nBFS Content Recommendations:");
        graph.BFS(start);

        System.out.println("\n\nDFS Content Recommendations:");
        graph.DFS(start);

        sc.close();
    }
}