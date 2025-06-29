package com.graph;

import java.util.*;

class DBfsGraph {
	private int vertices;
	private List<List<Integer>> adjList;
	private boolean isDirected;

	// Constructor
	public DBfsGraph(int vertices, boolean isDirected) {
		this.vertices = vertices;
		this.isDirected = isDirected;
		adjList = new ArrayList<>();

		// Initialize adjacency list
		for (int i = 0; i < vertices; i++) {
			adjList.add(new ArrayList<>());
		}
	}

	// Add edge to the graph
	public void addEdge(int src, int dest) {
		adjList.get(src).add(dest);
		if (!isDirected) {
			adjList.get(dest).add(src); // Add reverse edge for undirected graph
		}
	}

	// Perform BFS traversal from a given start node
	public void bfsTraversal(int startNode) {
		boolean[] visited = new boolean[vertices];
		Queue<Integer> queue = new LinkedList<>();
		List<Integer> bfs = new ArrayList<>();

		visited[startNode] = true;
		queue.add(startNode);

		while (!queue.isEmpty()) {
			int node = queue.poll();
			bfs.add(node);

			for (Integer adjNode : adjList.get(node)) {
				if (!visited[adjNode]) {
					visited[adjNode] = true;
					queue.add(adjNode);
				}
			}
		}

		System.out.println("BFS Traversal starting from node " + startNode + ": " + bfs);
	}

	// Optional: Display the adjacency list (good for debugging)
	public void printAdjacencyList() {
		for (int i = 0; i < vertices; i++) {
			System.out.print(i + " -> ");
			for (int neighbor : adjList.get(i)) {
				System.out.print(neighbor + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		System.out.println("===== Directed Graph =====");
		DBfsGraph dirGraph = new DBfsGraph(5, true);
		dirGraph.addEdge(0, 1);
		dirGraph.addEdge(0, 2);
		dirGraph.addEdge(1, 3);
		dirGraph.addEdge(2, 4);
		dirGraph.addEdge(3, 4);
		dirGraph.printAdjacencyList();
		dirGraph.bfsTraversal(0);

		System.out.println("\n===== Undirected Graph =====");
		DBfsGraph unDirGraph = new DBfsGraph(5, false);
		unDirGraph.addEdge(0, 1);
		unDirGraph.addEdge(0, 2);
		unDirGraph.addEdge(1, 3);
		unDirGraph.addEdge(2, 4);
		unDirGraph.addEdge(3, 4);
		unDirGraph.printAdjacencyList();
		unDirGraph.bfsTraversal(0);
	}
}
