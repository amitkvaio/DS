package com.graph;

//Adjancy List representation in Java

import java.util.*;

class BAdjancyListRepresentation {
	
	int vertices;
	List<List<Integer>> adjList;
	
	public BAdjancyListRepresentation(int vertices) {
		this.vertices = vertices;

		// Create the graph
		adjList = new ArrayList<>(vertices);
		for (int i = 0; i < vertices; i++) {
			adjList.add(new ArrayList<Integer>());
		}
	}

	// Add edge
	void addEdge(int src, int dest) {
		adjList.get(src).add(dest);
		adjList.get(dest).add(src);
	}

	public static void main(String[] args) {
		BAdjancyListRepresentation adj = new BAdjancyListRepresentation(4);
		// Add edges
		adj.addEdge(0, 1);
		adj.addEdge(0, 2);
		adj.addEdge(0, 3);
		adj.addEdge(1, 2);

		adj.printGraph(adj.adjList);
	}

	// Print the graph
	void printGraph(List<List<Integer>> adjList) {
		for (int i = 0; i < adjList.size(); i++) {
			System.out.print("\nVertex " + i + ":");
			for (int j = 0; j < adjList.get(i).size(); j++) {
				System.out.print("-> " + adjList.get(i).get(j));
			}
		}
	}
}
