package com.graph;
import java.util.ArrayList;
import java.util.List;

public class Agraph {
	
	private int vertices; // Number of vertices
    private List<List<Integer>> adjList; // Adjacency list
	
	public Agraph(int vertices) {
		this.vertices = vertices;
		adjList = new ArrayList<List<Integer>>();
		
		for(int i = 0 ; i < vertices; i++) {
			adjList.add(new ArrayList<Integer>());
		}
	}
	
	// Initialize the adjacency list for each vertex
	public static void main(String[] args) {
		Agraph test = new Agraph(5);
		System.out.println(test.adjList);
		 for (int i = 0; i < test.adjList.size(); i++) {
			System.out.println(test.adjList.get(i));
		}
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