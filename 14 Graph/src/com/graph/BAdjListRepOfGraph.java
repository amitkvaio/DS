package com.graph;

//Adjancy List representation in Java for directed and undirected graph.

import java.util.*;

public class BAdjListRepOfGraph {
	
	private int vertices;
	private List<List<Integer>> adjList;
	private boolean isDirected;

	// Constructor
	public BAdjListRepOfGraph(int vertices, boolean isDirected) {
		this.vertices = vertices;
		this.isDirected = isDirected;
		adjList = new ArrayList<>();

		for (int i = 0; i < vertices; i++) {
			adjList.add(new ArrayList<>());
		}
	}

	// Add edge method
	public void addEdge(int u, int v) {
		adjList.get(u).add(v);
		if (!isDirected) {
			adjList.get(v).add(u);
		}
	}


	// main
	public static void main(String[] args) {

		// Example 1: Undirected Graph
		BAdjListRepOfGraph undirectedGraph = new BAdjListRepOfGraph(4, false);
		undirectedGraph.addEdge(0, 1);
		undirectedGraph.addEdge(0, 2);
		undirectedGraph.addEdge(1, 2);
		undirectedGraph.addEdge(2, 3);
		undirectedGraph.printGraph();

		System.out.println();

		// Example 2: Directed Graph
		BAdjListRepOfGraph directedGraph = new BAdjListRepOfGraph(4, true);
		directedGraph.addEdge(0, 1);
		directedGraph.addEdge(0, 2);
		directedGraph.addEdge(1, 2);
		directedGraph.addEdge(2, 3);
		directedGraph.printGraph();
	}

	// Print adjacency list
	public void printGraph() {
		System.out.println(isDirected ? "Directed Graph:" : "Undirected Graph:");
		for (int i = 0; i < vertices; i++) {
			System.out.print("Vertex " + i + " → ");
			for (int neighbor : adjList.get(i)) {
				System.out.print(neighbor + " ");
			}
			System.out.println();
		}
	}
}
/*
   (0)
   / \
 (1)-(2)
        \
        (3)

Adjacency List:
Vertex 0 → 1 2
Vertex 1 → 0 2
Vertex 2 → 0 1 3
Vertex 3 → 2

   (0) → (1)
    ↓     ↓
   (2) → (3)

Adjacency List:
Vertex 0 → 1 2
Vertex 1 → 2
Vertex 2 → 3
Vertex 3 →



*/
