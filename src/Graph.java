import java.util.*;

public class Graph {

    private Map<Integer, Vertex> vertices;

    private Map<Integer, List<Integer>> adjacencyList;

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

    public void addEdge(int from, int to) {

        if (!vertices.containsKey(from) || !vertices.containsKey(to)) {

            System.out.println("Vertex does not exist.");
            return;
        }

        adjacencyList.get(from).add(to);

        Edge edge = new Edge(vertices.get(from), vertices.get(to));
        edges.add(edge);
    }

    public void printGraph() {

        System.out.println("\n===== GRAPH STRUCTURE =====");

        for (int vertex : adjacencyList.keySet()) {

            System.out.print(vertex + " -> ");

            for (int neighbor : adjacencyList.get(vertex)) {

                System.out.print(neighbor + " ");
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

            for (int neighbor : adjacencyList.get(current)) {

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

        for (int neighbor : adjacencyList.get(current)) {

            if (!visited.contains(neighbor)) {

                dfsRecursive(neighbor, visited);
            }
        }
    }

    public int getVertexCount() {
        return vertices.size();
    }
}