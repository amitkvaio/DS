package com.graph;

import java.util.*;

class CGraphDFS {
	private int vertices; // Number of vertices
	private List<List<Integer>> adjList; // Adjacency list representation
	private boolean isDirected; // To determine if the graph is directed or undirected

	// Initialization
	public CGraphDFS(int vertices, boolean isDirected) {
		this.vertices = vertices;
		this.isDirected = isDirected;
		adjList = new ArrayList<>();
		 
		// Initialize adjacency list
		for (int i = 0; i < vertices; i++) {
			adjList.add(new ArrayList<>());
		}
	}

	// Method to add an edge
	public void addEdge(int src, int dest) {
		adjList.get(src).add(dest); // Directed edge: src -> dest
		if (!isDirected) {
			System.out.println("Undirected");
			adjList.get(dest).add(src); // If undirected, add reverse edge
		}
	}
	
	private void dfsTraversal(int startNode) {
		boolean[] visited = new boolean[vertices]; // To track visited nodes
		List<Integer> result = new ArrayList<Integer>(); // For store the result
		
		dfs(startNode, visited, result);
		System.out.println(result);
	}
	
	private void dfs(int startNode, boolean[] visited, List<Integer> result) {
		if (visited[startNode] == true)
			return;

		visited[startNode] = true;
		result.add(startNode);

		for (Integer neighbor : adjList.get(startNode)) {
			if (!visited[neighbor]) {
				dfs(neighbor, visited, result);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("Directed Graph:");
		CGraphDFS directedGraph = new CGraphDFS(8, true);
		directedGraph.addEdge(0, 1);
		directedGraph.addEdge(0, 2);
		directedGraph.addEdge(1, 3);
		directedGraph.addEdge(2, 4);
		directedGraph.addEdge(3, 4);
		directedGraph.addEdge(2, 5);
		directedGraph.addEdge(5, 6);
		directedGraph.addEdge(5, 7);
		directedGraph.dfsTraversal(0);
		
		System.out.println("\nUndirected Graph:");
		CGraphDFS undirectedGraph = new CGraphDFS(8, false);
		undirectedGraph.addEdge(0, 1);
		undirectedGraph.addEdge(0, 2);
		undirectedGraph.addEdge(1, 3);
		undirectedGraph.addEdge(2, 4);
		undirectedGraph.addEdge(3, 4);
		undirectedGraph.addEdge(2, 5);
		undirectedGraph.addEdge(5, 6);
		undirectedGraph.addEdge(5, 7);
		undirectedGraph.dfsTraversal(0);
	}
}

/*
Use a boolean[] visited array to track visited nodes.
Use a recursive helper function to visit nodes in a depth-first manner.
Start from vertex 0 and explore its neighbors from left to right (as per the adjacency list).
Store the traversal order in a List<Integer>.


Time & Space Complexity

Time Complexity: O(V+E),where V is the number of vertices and EE is the number of edges.
Space Complexity: O(V) (for visited array and recursion stack).

*/