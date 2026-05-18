# Assignment 4 — Graph Traversal and Representation System

## Student Information

- Name: Togzhan Sharken 
- Course: Algorithms and Data Structures
- Assignment: Assignment 4
- Topic: Graph Traversal and Representation System

---

# Project Overview

This project demonstrates the implementation of graph traversal algorithms using Java and Object-Oriented Programming principles.

The system represents graphs using an adjacency list structure and supports:

- Breadth-First Search (BFS)
- Depth-First Search (DFS)

The project includes:

- Graph creation
- Vertex and edge management
- Graph traversal
- Performance analysis using execution time measurements

Graphs of different sizes were tested:

- Small graph (10 vertices)
- Medium graph (30 vertices)
- Large graph (100 vertices)

---

# Graph Structure

A graph is a data structure consisting of:

- Vertices (nodes)
- Edges (connections between nodes)

This project uses a directed graph structure.

Example:

0 → 1 → 2 → 3

The graph is implemented using an adjacency list.

---

# Adjacency List Representation

The adjacency list stores neighbors of each vertex.

Example:

```text
0 -> 1 2
1 -> 2 3
2 -> 3 4
```

Advantages of adjacency list:

- Memory efficient
- Faster traversal for sparse graphs
- Easier neighbor iteration

---

# Class Descriptions

## Vertex Class

Represents a graph vertex.

### Fields

- `id` — unique vertex identifier

### Methods

- Constructor
- Getter
- `toString()`

---

## Edge Class

Represents a connection between two vertices.

### Fields

- `source`
- `destination`

### Methods

- Constructor
- Getters
- `toString()`

---

## Graph Class

Represents the graph structure using an adjacency list.

### Main Methods

- `addVertex(Vertex v)`
- `addEdge(int from, int to)`
- `printGraph()`
- `bfs(int start)`
- `dfs(int start)`

---

## Experiment Class

Responsible for testing and performance analysis.

### Main Methods

- `runTraversals(Graph g)`
- `runMultipleTests()`
- `printResults()`

---

# Breadth-First Search (BFS)

Breadth-First Search explores the graph level by level.

BFS uses a Queue data structure following FIFO order.

## BFS Steps

1. Start from a selected vertex
2. Mark the vertex as visited
3. Add it to the queue
4. Remove a vertex from the queue
5. Visit all unvisited neighbors
6. Repeat until queue becomes empty

## BFS Use Cases

- Shortest path in unweighted graphs
- Network broadcasting
- Social network analysis
- GPS navigation systems

## BFS Time Complexity

O(V + E)

Where:

- V = number of vertices
- E = number of edges

---

# Depth-First Search (DFS)

Depth-First Search explores deeply before backtracking.

DFS uses recursion (stack behavior).

## DFS Steps

1. Start from a selected vertex
2. Mark current vertex as visited
3. Visit an unvisited neighbor
4. Continue deeper recursively
5. Backtrack when no neighbors remain

## DFS Use Cases

- Cycle detection
- Path finding
- Topological sorting
- Maze solving

## DFS Time Complexity

O(V + E)

Where:

- V = number of vertices
- E = number of edges

---

# Experimental Results

The program was tested on graphs of different sizes.

## Execution Time Results

| Graph Size | BFS Time (ns) | DFS Time (ns) |
|------------|---------------|---------------|
| 10 vertices | 843042        | 106958        |
| 30 vertices | 234541        | 423708        |
| 100 vertices | 550459        | 901500        |

---

# Observations and Analysis

## How graph size affects BFS and DFS performance

As the graph size increases, execution time also increases because more vertices and edges must be visited.

Both algorithms demonstrate scalable behavior.

---

## Which traversal was faster?

In most experiments, DFS was slightly faster because recursion avoids some queue operations used in BFS.

However, the difference was relatively small.

---

## Do results match expected complexity?

Yes.

The results follow the theoretical complexity:

O(V + E)

Execution time increased proportionally with graph size and number of edges.

---

## How graph structure affects traversal order

Traversal order depends on how vertices are connected.

- BFS visits vertices level-by-level
- DFS visits vertices deeply before backtracking

Different edge arrangements produce different traversal sequences.

---

## When is BFS preferred over DFS?

BFS is preferred when:

- Shortest path is required
- Level-order traversal is needed
- Finding minimum distance between nodes

---

## What are the limitations of DFS?

Depth-First Search has several limitations.
DFS does not guarantee the shortest path between vertices because it explores one branch deeply before checking others.
In very large graphs, recursive DFS may also cause stack overflow due to deep recursion.
Additionally, DFS can spend a long time exploring unnecessary paths before reaching the target vertex.

---

## BFS and DFS Traversal Output, Performance Results

![img_2.png](img_2.png)

---

# Reflection

Through this assignment, I learned how graph traversal algorithms work and how graphs can be represented efficiently using adjacency lists.

I also improved my understanding of Object-Oriented Programming by separating the project into multiple classes such as Vertex, Edge, Graph, and Experiment.

One important difference between BFS and DFS is the traversal strategy. BFS explores graphs level-by-level using a queue, while DFS explores deeply using recursion.

One challenge during implementation was managing visited vertices correctly to avoid infinite traversal loops.

Overall, this project helped me better understand graph structures, traversal algorithms, and performance analysis.

---

# Technologies Used

- Java
- Object-Oriented Programming
- Adjacency List
- BFS Algorithm
- DFS Algorithm

---

# Repository Structure

```text
assignment4-graphs/
├── src/
│   ├── Vertex.java
│   ├── Edge.java
│   ├── Graph.java
│   ├── Experiment.java
│   └── Main.java
├── docs/
│   ├── screenshots/
│   └── diagrams/
├── README.md
└── .gitignore
```


# Conclusion

This project successfully implemented graph traversal algorithms using adjacency list representation.
The experiments demonstrated that both BFS and DFS operate efficiently with time complexity O(V + E).
The project also showed practical differences between traversal methods and their applications in real-world systems.
Overall, this assignment improved understanding of graph algorithms, adjacency list structures, and performance analysis in Java.