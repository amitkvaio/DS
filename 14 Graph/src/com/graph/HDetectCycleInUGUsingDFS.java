package com.graph;

import java.util.ArrayList;
import java.util.List;

//Java Code: Detecting Cycle in an Undirected Graph Using DFS
public class HDetectCycleInUGUsingDFS {
	
	private int vertices;
	private List<List<Integer>> adjList ;
	
	public HDetectCycleInUGUsingDFS(int vertices) {
		this.vertices = vertices;
		adjList = new ArrayList<>();
		
		for (int i = 0; i < vertices; i++) {
			adjList.add(new ArrayList<Integer>());
		}
	}
	

    // Add edge to an undirected graph
    public void addEdge(int source, int destination) {
        adjList.get(source).add(destination);
        adjList.get(destination).add(source);
    }
    
    
    // Function to detect cycle in the graph
    public boolean isCyclic() {
        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) { // Check unvisited nodes (for disconnected graphs)
                if (isCycleUtil(i, visited, -1)) {//Assuming for starting node there is no parents so passing as -1
                    return true;
                }
            }
        }
        return false;
    }


	
	private boolean isCycleUtil(int node, boolean[] visited, int parent) {
		visited[node] = true;

		for (int neighbor : adjList.get(node)) {
			if (neighbor == parent) // Ignore the parent node
				continue;

			if (visited[neighbor]) // If visited again, cycle detected
				return true;

			if (isCycleUtil(neighbor, visited, node)) // Recursive DFS call
				return true;
		}
		return false;
	}


	public static void main(String[] args) {
		HDetectCycleInUGUsingDFS g = new HDetectCycleInUGUsingDFS(5);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(4, 1); // This edge creates a cycle
		System.out.println("Does the graph contain a cycle? " + g.isCyclic());
	}
}

/*
0 -- 1 -- 2
     |    |
     4 -- 3

Time Complexity
O(V + E) (where V is vertices and E is edges)
Each vertex and edge is processed once in DFS.
*/