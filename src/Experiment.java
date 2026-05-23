import java.util.Random;

public class Experiment {

    public void runTraversals(Graph g) {

        System.out.println("\n=================================");
        System.out.println("Graph with " + g.getVertexCount() + " vertices");
        System.out.println("=================================");

        long bfsStart = System.nanoTime();

        g.bfs(0);

        long bfsEnd = System.nanoTime();

        long dfsStart = System.nanoTime();

        g.dfs(0);

        long dfsEnd = System.nanoTime();

        long dijkstraStart = System.nanoTime();

        g.dijkstra(0);

        long dijkstraEnd = System.nanoTime();

        printResults(
                bfsEnd - bfsStart,
                dfsEnd - dfsStart,
                dijkstraEnd - dijkstraStart
        );
    }

    public void printResults(long bfsTime,
                             long dfsTime,
                             long dijkstraTime) {

        System.out.println("\n===== EXECUTION TIME =====");

        System.out.println("BFS Time: " + bfsTime + " ns");

        System.out.println("DFS Time: " + dfsTime + " ns");

        System.out.println("Dijkstra Time: " + dijkstraTime + " ns");
    }

    public void runMultipleTests() {

        Graph smallGraph = createGraph(10);

        Graph mediumGraph = createGraph(30);

        Graph largeGraph = createGraph(100);

        smallGraph.printGraph();

        runTraversals(smallGraph);

        runTraversals(mediumGraph);

        runTraversals(largeGraph);
    }

    private Graph createGraph(int size) {

        Graph graph = new Graph();

        Random random = new Random();

        for (int i = 0; i < size; i++) {

            graph.addVertex(new Vertex(i));
        }

        for (int i = 0; i < size - 1; i++) {

            graph.addEdge(i, i + 1, random.nextInt(9) + 1);
            if (i + 2 < size) {

                graph.addEdge(i, i + 2, random.nextInt(9) + 1);
            }
        }

        return graph;
    }
}