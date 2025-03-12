package com.graph;
import java.util.ArrayList;
import java.util.List;

public class Bgraph {
	
	private int vertices;
	private List<List<Integer>> adjList;
	
	public Bgraph(int vertices) {
		this.vertices = vertices;
		adjList = new ArrayList<List<Integer>>();
		
		for (int i = 0; i < this.vertices ; i++) {
			adjList.add(new ArrayList<Integer>());
		}
	}
	
	private void addEdge(int src, int dest) {
		adjList.get(src).add(dest);
	}
	
	private void printAdList(List<List<Integer>> adjList) {
		for(int i = 0 ; i < adjList.size(); i ++) {
			System.out.print(i + ": ");
			for (Integer integer : adjList.get(i)) {
				 System.out.print(integer + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Bgraph graph = new Bgraph(5); // 5 nodes (0 to 4)

        // Adding edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        // Print adjacency list
        graph.printAdList(graph.adjList);
	}
}
/*
0: 1 2 
1: 3 
2: 4 
3: 4 
4: 

Time & Space Complexity:

    Time Complexity:
        Adding an edge: O(1)O(1)
        Printing the graph: O(V+E)O(V+E), where VV is the number of vertices and EE is the number of edges.
    Space Complexity: O(V+E)O(V+E), since we store all edges in an adjacency list.
*/