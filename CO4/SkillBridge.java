import java.util.*;

class SkillBridge {
    private int V;
    private List<List<Edge>> adj;

    // Edge class
    static class Edge {
        int dest, weight;

        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    // Constructor
    SkillBridge(int v) {
        V = v;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Add course dependency
    void addEdge(int src, int dest, int weight) {
        adj.get(src).add(new Edge(dest, weight));
    }

    // Dijkstra Algorithm
    void dijkstra(int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];

            for (Edge edge : adj.get(u)) {
                int v = edge.dest;
                int weight = edge.weight;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }

        System.out.println("\nDijkstra Shortest Paths:");
        for (int i = 0; i < V; i++) {
            System.out.println("Course " + i + " -> " + dist[i]);
        }
    }

    // Bellman-Ford Algorithm
    void bellmanFord(int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 1; i < V; i++) {
            for (int u = 0; u < V; u++) {
                for (Edge edge : adj.get(u)) {
                    int v = edge.dest;
                    int w = edge.weight;

                    if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                        dist[v] = dist[u] + w;
                    }
                }
            }
        }

        System.out.println("\nBellman-Ford Shortest Paths:");
        for (int i = 0; i < V; i++) {
            System.out.println("Course " + i + " -> " + dist[i]);
        }
    }

    // Floyd-Warshall Algorithm
    void floydWarshall() {
        int[][] dist = new int[V][V];

        for (int i = 0; i < V; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }

        for (int u = 0; u < V; u++) {
            for (Edge edge : adj.get(u)) {
                dist[u][edge.dest] = edge.weight;
            }
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE &&
                        dist[k][j] != Integer.MAX_VALUE &&
                        dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        System.out.println("\nFloyd-Warshall All-Pairs Shortest Paths:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == Integer.MAX_VALUE)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Topological Sort
    void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;

        for (Edge edge : adj.get(v)) {
            if (!visited[edge.dest]) {
                topologicalSortUtil(edge.dest, visited, stack);
            }
        }

        stack.push(v);
    }

    void topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        System.out.println("\nTopological Order of Courses:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        SkillBridge sb = new SkillBridge(6);

        // Course dependencies (source, destination, weight)
        sb.addEdge(0, 1, 2);
        sb.addEdge(0, 2, 4);
        sb.addEdge(1, 3, 7);
        sb.addEdge(2, 3, 1);
        sb.addEdge(3, 4, 3);
        sb.addEdge(4, 5, 2);

        sb.dijkstra(0);
        sb.bellmanFord(0);
        sb.floydWarshall();
        sb.topologicalSort();
    }
}