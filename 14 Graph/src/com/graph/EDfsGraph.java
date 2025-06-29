package com.graph;

import java.util.*;

public class EDfsGraph {

	private int vertices; // Number of vertices
	private ArrayList<ArrayList<Integer>> adjList; // Adjacency list
	private boolean isDirected;

	public EDfsGraph(int vertices, boolean isDirected) {
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
		dfs(0, visited, result);
		return result;
	}

	// Print adjacency list
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
		System.out.println("Directed Graph:");
		EDfsGraph dirGraph = new EDfsGraph(8, true);
		dirGraph.addEdge(0, 1);
		dirGraph.addEdge(0, 2);
		dirGraph.addEdge(1, 3);
		dirGraph.addEdge(2, 4);
		dirGraph.addEdge(3, 4);
		dirGraph.addEdge(2, 5);
		dirGraph.addEdge(5, 6);
		dirGraph.addEdge(5, 7);
		
		dirGraph.printAdjacencyList();
		ArrayList<Integer> dirList = dirGraph.dfsOfGraph();
		System.out.println(dirList);
		System.out.println("******************");

		System.out.println("\nUndirected Graph:");
		EDfsGraph unDirGraph = new EDfsGraph(8, false);
		unDirGraph.addEdge(0, 1);
		unDirGraph.addEdge(0, 2);
		unDirGraph.addEdge(1, 3);
		unDirGraph.addEdge(2, 4);
		unDirGraph.addEdge(3, 4);
		unDirGraph.addEdge(2, 5);
		unDirGraph.addEdge(5, 6);
		unDirGraph.addEdge(5, 7);
		unDirGraph.printAdjacencyList();
		ArrayList<Integer> unDirList =unDirGraph.dfsOfGraph();
		System.out.println(unDirList);
	}
}

/*
Use a boolean[] visited array to track visited nodes.
Use a recursive helper function to visit nodes in a depth-first manner.
Start from vertex 0 and explore its neighbors from left to right (as per the adjacency list).
Store the traversal order in a List<Integer>.


Time & Space Complexity
***********************
Time Complexity: O(V+E),where V is the number of vertices and EE is the number of edges.
Space Complexity: O(V) (for visited array and recursion stack).


Directed Graph 
**************
0 → 1 → 3 → →4
|            ^
|           /
|          /
|         /
|        /
|       /
|      /
|     / 
 ↘   /      
   2 → 5 → 6
        ↘
          ↘
           7


Adjacency List:
Vertex:0 -> 1 2 
Vertex:1 -> 3 
Vertex:2 -> 4 5 
Vertex:3 -> 4 
Vertex:4 -> 
Vertex:5 -> 6 7 
Vertex:6 -> 
Vertex:7 -> 

Directed Graph:
DFS Traversal from node 0: [0, 1, 3, 4, 2, 5, 6, 7]

Undirected Graph
****************
     0
    / \
   1   2
   |   |\
   3---4 5
        / \
       6   7

Adjacency List:
Vertex:0 -> 1 2 
Vertex:1 -> 0 3 
Vertex:2 -> 0 4 5 
Vertex:3 -> 1 4 
Vertex:4 -> 2 3 
Vertex:5 -> 2 6 7 
Vertex:6 -> 5 
Vertex:7 -> 5 

Undirected Graph:
DFS Traversal from node 0: [0, 1, 3, 4, 2, 5, 6, 7]

*/