package com.graph;

public class INumberOfIslands {
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;

		int rows = grid.length;
		int cols = grid[0].length;
		int islandCount = 0;

		// Traverse every cell
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				// Start DFS when you find '1'
				if (grid[i][j] == '1') {
					islandCount++;
					dfs(grid, i, j);
				}
			}
		}
		return islandCount;
	}

	// DFS to visit all adjacent lands
	private void dfs(char[][] grid, int i, int j) {
		int rows = grid.length;
		int cols = grid[0].length;

		// Base case: boundary or water
		if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '0') {
			return;
		}

		// Mark current land as visited
		grid[i][j] = '0';

		// Visit all 4 directions
		dfs(grid, i + 1, j); // Down
		dfs(grid, i - 1, j); // Up
		dfs(grid, i, j + 1); // Right
		dfs(grid, i, j - 1); // Left
	}

    public static void main(String[] args) {
    	INumberOfIslands obj = new INumberOfIslands();
        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        int count = obj.numIslands(grid);
        System.out.println("Number of islands: " + count); // Output: 3
    }
}

/*
You are given an m x n 2D binary grid:
    '1' represents land
    '0' represents water
You need to return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.


Approach
*********
Loop through each cell in the grid.
When you encounter a '1' (unvisited land), start DFS to mark the entire island.
After each full DFS, increment your island count.
In DFS, mark the visited land by setting it to '0'.


Grid Indexes:
(0,0) (0,1) (0,2)
(1,0) (1,1) (1,2)
(2,0) (2,1) (2,2)

Suppose we are currently standing on a land cell at (i, j)=(1,1)
(i,j) == Right → Next column (i, j+1)
(i,j) == Left  → Previous column (i, j-1)
(i,j) == Down  → Next row (i+1,j)
(i,j) == Up    → Previous row (i-1,i)

Grid Content:
1     1     0
1     0     0
0     0     1


Time & Space Complexity
    Time: O(m × n) – Each cell visited once.
    Space: O(m × n) – Recursion stack in worst case (or you can use iterative DFS to reduce it).


// Visit all 4 directions
dfs(grid, i + 1, j); // Down
dfs(grid, i - 1, j); // Up
dfs(grid, i, j + 1); // Right
dfs(grid, i, j - 1); // Left

Explore all 4 connected directions.
This will keep marking connected land cells as visited (part of the same island).
*/
