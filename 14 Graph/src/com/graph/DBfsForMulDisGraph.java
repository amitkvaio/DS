package com.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Handle multiple disconnected components in a graph using BFS
public class DBfsForMulDisGraph {

	private int vertices;
	private List<List<Integer>> adjList;
	private boolean isDirected;

	// Constructor
	public DBfsForMulDisGraph(int vertices, boolean isDirected) {
		this.vertices = vertices;
		this.isDirected = isDirected;
		adjList = new ArrayList<>();

		for (int i = 0; i < vertices; i++) {
			adjList.add(new ArrayList<>());
		}
	}

	// Add edge to the graph
	public void addEdge(int src, int dest) {
		adjList.get(src).add(dest);
		if (!isDirected) {
			adjList.get(dest).add(src);
		}
	}

	// Traverse the whole graph (even if disconnected)
	public void bfsDisconnected() {
		boolean[] visited = new boolean[vertices];
		int componentCount = 0;

		for (int i = 0; i < vertices; i++) {
			if (!visited[i]) {
				componentCount++;
				System.out.print("Component " + componentCount + ": ");
				bfs(i, visited);
				System.out.println();
			}
		}
	}

	// BFS for a single component
	private void bfs(int startNode, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		visited[startNode] = true;
		queue.add(startNode);

		while (!queue.isEmpty()) {
			int node = queue.poll();
			System.out.print(node + " ");

			for (Integer neighbor : adjList.get(node)) {
				if (!visited[neighbor]) {
					visited[neighbor] = true;
					queue.add(neighbor);
				}
			}
		}
	}

	// Optional: Print adjacency list
	public void printAdjacencyList() {
		System.out.println("Adjacency List:");
		for (int i = 0; i < vertices; i++) {
			System.out.print(i + " -> ");
			for (int neighbor : adjList.get(i)) {
				System.out.print(neighbor + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		System.out.println("=== Undirected Disconnected Graph ===");

		DBfsForMulDisGraph graph = new DBfsForMulDisGraph(9, false);

		// Component 1: 0 - 1 - 2
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);

		// Component 2: 3 - 4
		graph.addEdge(3, 4);

		// Component 3: 5 - 6 - 7 - 8
		graph.addEdge(5, 6);
		graph.addEdge(6, 7);
		graph.addEdge(7, 8);

		graph.printAdjacencyList();
		System.out.println("\nBFS Traversal for Disconnected Graph:");
		graph.bfsDisconnected();
	}
}
/*
  
To handle multiple disconnected components in a graph using BFS, we need to
  modify the bfsTraversal method to: Traverse all nodes, even if the graph is
  disconnected. Start a new BFS for each unvisited node.
 
 Component 1:     Component 2:      Component 3:

    0               3                 5
    |               |                 |
    1               4                 6
    |
    2                                 |
                                      7
                                      |
                                      8
This version traverses all components, even if disconnected.
Each connected component is printed separately.
BFS is called only if the node hasn't been visited yet.
 */
