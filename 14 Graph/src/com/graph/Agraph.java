package com.graph;
import java.util.ArrayList;
import java.util.List;

public class Agraph {

	private int vertices; // Number of vertices
	private List<List<Integer>> adjList; // Adjacency list

	// Constructor
	public Agraph(int vertices) {
		this.vertices = vertices;
		adjList = new ArrayList<>();

		// Initialize empty list for each vertex
		for (int i = 0; i < vertices; i++) {
			adjList.add(new ArrayList<>());
		}
	}

	// Method to print the adjacency list
	public void printAdjList() {
		for (int i = 0; i < adjList.size(); i++) {
			System.out.print("Vertex " + i + ": ");
			for (int neighbor : adjList.get(i)) {
				System.out.print(neighbor + " ");
			}
			System.out.println();
		}
	}

	// Main method to test the graph
	public static void main(String[] args) {
		Agraph graph = new Agraph(5);
		System.out.println("Empty adjacency list structure:");

		// Print each vertex's neighbors (all will be empty initially)
		graph.printAdjList();
	}
}

/*
Graph Initialization:
    We initialize an ArrayList of ArrayLists to store the adjacency list.
    Each index represents a node, and its list contains all neighboring nodes.

Adding Edges:
    addEdge(int src, int dest) adds a directed edge from src → dest.

Printing the Graph:
    We iterate over the adjacency list and print the neighbors of each node.

*/