package com.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HRatInMaze {
	public static void main(String[] args) {
		 int[][] mat1 = {
		            {1, 0, 0, 0},
		            {1, 1, 0, 1},
		            {1, 1, 0, 0},
		            {0, 1, 1, 1}
		        };
		 System.out.println(findPaths(mat1)); // Output: [DDRDRR, DRDDRR]
	}

	private static List<String> findPaths(int[][] mat) {
		List<String> result = new ArrayList<>();
		int n = mat.length;
		if (mat[0][0] == 0 || mat[n - 1][n - 1] == 0) {
			return result; // No path if the start or end is blocked
		}
		boolean[][] visited = new boolean[n][n];
		dfs(mat, 0, 0, "", visited, result);
		Collections.sort(result); // Sort paths lexicographically
		return result;
	}

	 private static void dfs(int[][] mat, int x, int y, String path, boolean[][] visited, List<String> result) {
		int n = mat.length;
		
		// If the destination is reached, add the path to the result
        if (x == n - 1 && y == n - 1) {
            result.add(path);
            return;
        }
        
        // Mark the current cell as visited
        visited[x][y] = true;
        
     // Possible directions: Down, Left, Right, Up
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, -1, 1, 0};
        char[] directions = {'D', 'L', 'R', 'U'};
        
		for (int i = 0; i < 4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];

			if (isSafe(newX, newY, mat, visited)) {
				dfs(mat, newX, newY, path + directions[i], visited, result);
			}
		}
		// Backtrack: Unmark the current cell
        visited[x][y] = false;
        
	}
	 
	private static boolean isSafe(int x, int y, int[][] mat, boolean[][] visited) {
		int n = mat.length;
		return x >= 0 && x < n && y >= 0 && y < n && mat[x][y] == 1 && !visited[x][y];
	}
}
/*
Base Case:
    If the destination (n-1, n-1) is reached, add the constructed path to the result.

Backtracking :
	Mark the cell as visited before recursive calls and unmark it afterward to explore other paths.

DFS Traversal:
    Start from (0, 0) and recursively explore all possible paths.
    Use a visited matrix to avoid revisiting cells in the same path.
*/