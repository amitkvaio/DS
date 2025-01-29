package com.recursion;

import java.util.ArrayList;
import java.util.List;
//N-Queens | 2 Approaches | Super Detailed | Magic Of Recursion | Recursion Concepts And Questions
public class KNQueens {
	
	private static List<List<String>> result = new ArrayList<>();
	
	public static void main(String[] args) {
		List<List<String>> solveNQueens = solveNQueens(4);
		for (List<String> list : solveNQueens) {
			for (String str : list) {
				System.out.println(str);
			}
			System.out.println();
		}
	}
	
	//Approach-1 (Simple dfs)
	//T.C : O(N!) - Read the reason above
	//S.C : O(N) to store the result
	public static List<List<String>> solveNQueens(int n) {
		if (n == 0)
			return result;

		List<String> board = new ArrayList<>();
		// For n = 3, board = {"...", "...", "..."} initially
		for (int i = 0; i < n; i++) {
			StringBuilder row = new StringBuilder();
			for (int j = 0; j < n; j++) {
				row.append('.');
			}
			board.add(row.toString());
		}

		solve(board, 0);

		return result;
	}
	
	
	private static void solve(List<String> board, int row) {
		if (row == board.size()) {
			result.add(new ArrayList<>(board));
			return;
		}

		// Place one queen at every row and check before placing
		// in every direction where there is a risk of being attacked
		// i.e., up, diagonally because we are placing queens from
		// the top row to the bottom row, so we need to check if we put a queen
		// vertically up in some row or diagonally upwards in some row

		for (int i = 0; i < board.size(); i++) {
			if (isValid(board, row, i)) {
				StringBuilder newRow = new StringBuilder(board.get(row));
				newRow.setCharAt(i, 'Q');
				board.set(row, newRow.toString());

				solve(board, row + 1);

				newRow.setCharAt(i, '.');
				board.set(row, newRow.toString());
			}
		}
	}
	
	private static boolean isValid(List<String> board, int row, int col) {
		// Look for up
		for (int i = row; i >= 0; i--) {
			if (board.get(i).charAt(col) == 'Q')
				return false;
		}

		// Check left diagonal upwards
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board.get(i).charAt(j) == 'Q')
				return false;
		}

		// Check right diagonal upwards
		for (int i = row, j = col; i >= 0 && j < board.size(); i--, j++) {
			if (board.get(i).charAt(j) == 'Q')
				return false;
		}
		return true;
	}
}












/*

51. N-Queens
https://leetcode.com/problems/n-queens/description/

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

Example 2:

Input: n = 1
Output: [["Q"]]

 

Constraints:

    1 <= n <= 9



https://github.com/MAZHARMIK/Interview_DS_Algo/blob/master/Backtracking/N-Queens.cpp

*/