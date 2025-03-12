package com.graph;

//Adjacency Matrix representation in Java

public class AAdjancyMatrixRepresentationOfAGraph {
	private boolean adjMatrix[][];
	private int numVertices;

// Initialize the matrix
	public AAdjancyMatrixRepresentationOfAGraph(int numVertices) {
		this.numVertices = numVertices;
		adjMatrix = new boolean[numVertices][numVertices];
	}

// Add edges
	public void addEdge(int i, int j) {
		adjMatrix[i][j] = true;
		adjMatrix[j][i] = true;
	}

// Remove edges
	public void removeEdge(int i, int j) {
		adjMatrix[i][j] = false;
		adjMatrix[j][i] = false;
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
		AAdjancyMatrixRepresentationOfAGraph g = new AAdjancyMatrixRepresentationOfAGraph(4);
		System.out.println(g);
		
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		System.out.print("\nAfter adding the multiple Edge\n"+g.toString());
		
		g.removeEdge(2, 3);
		System.out.println("\nAfter Removal of Edge\n" +g.toString());
	}
}