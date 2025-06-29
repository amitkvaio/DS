package com.graph;

import java.util.*;

class FDfsForMultDisGraph {
	private int vertices; // Number of vertices
	private ArrayList<ArrayList<Integer>> adjList; // Adjacency list
	private boolean isDirected;

	public FDfsForMultDisGraph(int vertices, boolean isDirected) {
		this.vertices = vertices;
		this.isDirected = isDirected;
		adjList = new ArrayList<>();
		for (int i = 0; i < vertices; i++) {
			adjList.add(new ArrayList<>());
		}
	}

	// Add edge
	public void addEdge(int src, int dest) {
		adjList.get(src).add(dest);
		if (!isDirected) {
			adjList.get(dest).add(src);
		}
	}

	// Recursive DFS
	private void dfs(int node, boolean[] visited, ArrayList<Integer> result) {
		visited[node] = true;
		result.add(node);
		for (int neighbor : adjList.get(node)) {
			if (!visited[neighbor]) {
				dfs(neighbor, visited, result);
			}
		}
	}
	 
	// Handles disconnected graph
	public ArrayList<Integer> dfsOfGraph() {
		boolean[] visited = new boolean[vertices];
		ArrayList<Integer> result = new ArrayList<>();

		for (int i = 0; i < vertices; i++) {
			if (!visited[i]) {
				dfs(i, visited, result);
			}
		}
		return result;
	}

	// Optional: Print adjacency list
	public void printAdjacencyList() {
		System.out.println("Adjacency List:");
		for (int i = 0; i < vertices; i++) {
			System.out.print("Vertex:" + i + " -> ");
			for (int neighbor : adjList.get(i)) {
				System.out.print(neighbor + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		System.out.println("=== Undirected Disconnected Graph - DFS ===");

		FDfsForMultDisGraph graph = new FDfsForMultDisGraph(9, false);

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
		System.out.println("\nDFS Traversal for Disconnected Graph:");
		ArrayList<Integer> result = graph.dfsOfGraph();
		System.out.println(result);
	}
}
/*
Component 1:     Component 2:      Component 3:

    0               3                 5
    |               |                 |
    1               4                 6
    |                                 |
    2                                 |
                                      7
                                      |
                                      8

Output:
*******
=== Undirected Disconnected Graph - DFS ===
Adjacency List:
Vertex:0 -> 1 
Vertex:1 -> 0 2 
Vertex:2 -> 1 
Vertex:3 -> 4 
Vertex:4 -> 3 
Vertex:5 -> 6 
Vertex:6 -> 5 7 
Vertex:7 -> 6 8 
Vertex:8 -> 7  

DFS Traversal for Disconnected Graph:
[0, 1, 2, 3, 4, 5, 6, 7, 8]

Summary
*********
    We loop through all vertices.
    If a vertex is unvisited, we perform DFS on it.
    This handles disconnected graphs cleanly.
    Each DFS output corresponds to a connected component.
*/