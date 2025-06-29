package com.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
// Detect Cycle in Undirected Graph using BFS
public class GDetectCycleInUGUsingBFS {
	private int vertices;
	private List<List<Integer>> adjList ;
	
	public GDetectCycleInUGUsingBFS(int vertices) {
		this.vertices = vertices;
		adjList = new ArrayList<>();
		
		for (int i = 0; i < vertices; i++) {
			adjList.add(new ArrayList<Integer>());
		}
	}
	
	static class Pair{
		int source;
		int parents;
		public Pair(int source, int parents) {
			this.source = source;
			this.parents = parents;
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
                if (isCycleBFS(i, visited, -1)) {//Assuming for starting node there is no parents so passing as -1
                    return true;
                }
            }
        }
        return false;
    }


	
	private boolean isCycleBFS(int startingNode, boolean[] visited, int parent) {
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.offer(new Pair(startingNode, -1));
		
		visited[startingNode] = true;
		
		while(!queue.isEmpty()) {
			Pair pair = queue.poll();
			int source = pair.source;
			int prnts = pair.parents;
			
			for (Integer src : adjList.get(source)) {
				if(visited[src] == false) {
					queue.offer(new Pair(src,source));
					visited[src] = true;
				}else if(src !=prnts) {
					return true;
				}
			}
		}
		return false;
	}


	public static void main(String[] args) {
		GDetectCycleInUGUsingBFS g = new GDetectCycleInUGUsingBFS(5);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(4, 1); // This edge creates a cycle
		System.out.println("Does the graph contain a cycle? " + g.isCyclic());
	}
}
