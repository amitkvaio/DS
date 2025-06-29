package com.graph;

 
//Adjacency Matrix representation of an directed graph

public class AAdjancyMatRepDirGraph {
	private boolean adjMatrix[][];
	private int numVertices;

	// Constructor to initialize the matrix
	public AAdjancyMatRepDirGraph(int numVertices) {
		this.numVertices = numVertices;
		this.adjMatrix = new boolean[numVertices][numVertices];
	}

	// Method to add an edge between two vertices
	public void addEdge(int i, int j) {
		if (isValidVertex(i) && isValidVertex(j)) {
			adjMatrix[i][j] = true; // Only one direction for directed graph
		}
	}

	// Method to remove an edge between two vertices
	public void removeEdge(int i, int j) {
		if (isValidVertex(i) && isValidVertex(j)) {
			adjMatrix[i][j] = false;
		}
	}

	// Helper method to check if vertex is valid
	private boolean isValidVertex(int v) {
		return v >= 0 && v < numVertices;
	}

	// Print the matrix
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < numVertices; i++) {
			s.append(i + ": ");
			for (boolean j : adjMatrix[i]) {
				s.append((j ? 1 : 0) + " ");
			}
			s.append("\n");
		}
		return s.toString();
	}

	public static void main(String args[]) {
		AAdjancyMatRepDirGraph g = new AAdjancyMatRepDirGraph(4);
		System.out.println(g);

		g.addEdge(1, 0);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 0);
		System.out.print("After adding the multiple Edge\n" + g.toString());

		g.removeEdge(2, 3);
		System.out.println("\nAfter Removal of Edge\n" + g.toString());
	}
}
/*
  Above graph
   
   0
   ^^  
   | \
   |  \  
   |   \ 
   |    \
   |     \   
   |      \
   |   2--->3
   |  ^
   | / 
   1/

After adding the multiple Edge
0: 0 0 0 0 
1: 1 0 1 0 
2: 0 0 0 1 
3: 1 0 0 0  
   
After removal of edge 2 -->3 graph
  Above graph
   
   0
   ^^  
   | \
   |  \  
   |   \ 
   |    \
   |     \   
   |      \
   |   2   3
   |  ^
   | / 
   1/

After Removal of Edge
0: 0 0 0 0 
1: 1 0 1 0 
2: 0 0 0 0 
3: 1 0 0 0  
*/