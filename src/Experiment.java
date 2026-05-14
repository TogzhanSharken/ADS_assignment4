public class Experiment {

    public void runTraversals(Graph g) {

        System.out.println("\n=================================");
        System.out.println("Graph with " + g.getVertexCount() + " vertices");
        System.out.println("=================================");

        if (g.getVertexCount() == 10) {

            long bfsStart = System.nanoTime();

            g.bfs(0);

            long bfsEnd = System.nanoTime();

            long dfsStart = System.nanoTime();

            g.dfs(0);

            long dfsEnd = System.nanoTime();

            printResults(
                    bfsEnd - bfsStart,
                    dfsEnd - dfsStart
            );
        }

        else {

            long bfsStart = System.nanoTime();

            g.bfs(0);

            long bfsEnd = System.nanoTime();

            long dfsStart = System.nanoTime();

            g.dfs(0);

            long dfsEnd = System.nanoTime();

            printResults(
                    bfsEnd - bfsStart,
                    dfsEnd - dfsStart
            );
        }
    }

    public void printResults(long bfsTime, long dfsTime) {

        System.out.println("\n===== EXECUTION TIME =====");

        System.out.println("BFS Time: " + bfsTime + " ns");

        System.out.println("DFS Time: " + dfsTime + " ns");
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

        for (int i = 0; i < size; i++) {

            graph.addVertex(new Vertex(i));
        }

        for (int i = 0; i < size - 1; i++) {

            graph.addEdge(i, i + 1);

            if (i + 2 < size) {

                graph.addEdge(i, i + 2);
            }
        }

        return graph;
    }
}