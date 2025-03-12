package com.graph;

import java.util.*;

class DGraphBFS {
	private int vertices;
	private List<List<Integer>> adjList;
	private boolean isDirected;

	// Constructor
	public DGraphBFS(int vertices, boolean isDirected) {
		this.vertices = vertices;
		this.isDirected = isDirected;
		adjList = new ArrayList<>();

		for (int i = 0; i < vertices; i++) {
			adjList.add(new ArrayList<>());
		}
	}

	// Add edges
	public void addEdge(int src, int dest) {
		adjList.get(src).add(dest);
		if (!isDirected) {
			adjList.get(dest).add(src);
		}
	}

	public void bfsTraversal(int startNode) {
		boolean[] visited = new boolean[vertices];
		Queue<Integer> queue = new LinkedList<>();
		List<Integer> result = new ArrayList<Integer>();

		visited[startNode] = true;
		queue.add(startNode);

		while (!queue.isEmpty()) {
			int node = queue.poll();
			result.add(node);

			for (Integer neighbor : adjList.get(node)) {
				if (!visited[neighbor]) {
					visited[neighbor] = true;
					queue.add(neighbor);
				}
			}
		}
		System.out.println(result);
	}

	public static void main(String[] args) {
		System.out.println("Directed Graph:");
		DGraphBFS directedGraph = new DGraphBFS(5, true);
		directedGraph.addEdge(0, 1);
		directedGraph.addEdge(0, 2);
		directedGraph.addEdge(1, 3);
		directedGraph.addEdge(2, 4);
		directedGraph.addEdge(3, 4);
		directedGraph.bfsTraversal(0);

		System.out.println("\nUndirected Graph:");
		DGraphBFS undirectedGraph = new DGraphBFS(5, false);
		undirectedGraph.addEdge(0, 1);
		undirectedGraph.addEdge(0, 2);
		undirectedGraph.addEdge(1, 3);
		undirectedGraph.addEdge(2, 4);
		undirectedGraph.addEdge(3, 4);
		undirectedGraph.bfsTraversal(0);
	}
}
