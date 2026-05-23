import java.util.*;

public class Graph {

    private Map<Integer, Vertex> vertices;

    private Map<Integer, List<Edge>> adjacencyList;

    private List<Edge> edges;

    public Graph() {

        vertices = new HashMap<>();

        adjacencyList = new HashMap<>();

        edges = new ArrayList<>();
    }

    public void addVertex(Vertex v) {

        vertices.put(v.getId(), v);

        adjacencyList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    public void addEdge(int from, int to, int weight) {

        if (!vertices.containsKey(from) || !vertices.containsKey(to)) {

            System.out.println("Vertex does not exist.");
            return;
        }

        Edge edge = new Edge(vertices.get(from), vertices.get(to), weight);

        adjacencyList.get(from).add(edge);

        edges.add(edge);
    }

    public void printGraph() {

        System.out.println("\n===== GRAPH STRUCTURE =====");

        for (int vertex : adjacencyList.keySet()) {

            System.out.print(vertex + " -> ");

            for (Edge edge : adjacencyList.get(vertex)) {

                System.out.print(
                        edge.getDestination().getId() +
                                "(" + edge.getWeight() + ") "
                );
            }

            System.out.println();
        }
    }

    public void bfs(int start) {

        Set<Integer> visited = new HashSet<>();

        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);

        queue.offer(start);

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {

            int current = queue.poll();

            System.out.print(current + " ");

            for (Edge edge : adjacencyList.get(current)) {

                int neighbor = edge.getDestination().getId();

                if (!visited.contains(neighbor)) {

                    visited.add(neighbor);

                    queue.offer(neighbor);
                }
            }
        }

        System.out.println();
    }

    public void dfs(int start) {

        Set<Integer> visited = new HashSet<>();

        System.out.print("DFS Traversal: ");

        dfsRecursive(start, visited);
        System.out.println();
    }

    private void dfsRecursive(int current, Set<Integer> visited) {

        visited.add(current);

        System.out.print(current + " ");

        for (Edge edge : adjacencyList.get(current)) {

            int neighbor = edge.getDestination().getId();

            if (!visited.contains(neighbor)) {

                dfsRecursive(neighbor, visited);
            }
        }
    }

    public void dijkstra(int start) {

        int size = vertices.size();
        int[] distances = new int[size];

        boolean[] visited = new boolean[size];

        Arrays.fill(distances, Integer.MAX_VALUE);

        distances[start] = 0;

        for (int i = 0; i < size - 1; i++) {

            int currentVertex = getMinDistanceVertex(distances, visited);

            visited[currentVertex] = true;

            for (Edge edge : adjacencyList.get(currentVertex)) {

                int neighbor = edge.getDestination().getId();

                int weight = edge.getWeight();

                if (!visited[neighbor]
                        && distances[currentVertex] != Integer.MAX_VALUE
                        && distances[currentVertex] + weight < distances[neighbor]) {

                    distances[neighbor] = distances[currentVertex] + weight;
                }            }
        }

        printDijkstraResults(start, distances);
    }

    private int getMinDistanceVertex(int[] distances, boolean[] visited) {

        int min = Integer.MAX_VALUE;

        int minIndex = -1;

        for (int i = 0; i < distances.length; i++) {

            if (!visited[i] && distances[i] < min) {

                min = distances[i];

                minIndex = i;
            }
        }

        return minIndex;
    }

    private void printDijkstraResults(int start, int[] distances) {

        System.out.println("\n===== DIJKSTRA SHORTEST PATHS =====");

        System.out.println("Starting Vertex: " + start);

        for (int i = 0; i < distances.length; i++) {

            System.out.println(
                    "Distance from " + start + " to " + i +
                            " = " + distances[i]
            );
        }
    }

    public int getVertexCount() {
        return vertices.size();
    }
}