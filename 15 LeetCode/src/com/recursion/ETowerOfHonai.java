package com.recursion;

public class ETowerOfHonai {
	public static void main(String[] args) {
		System.out.println(towerOfHonai(2, 'A', 'B', 'C'));
		System.out.println(towerOfHonai(3, 'A', 'B', 'C'));
		System.out.println(towerOfHonai(0, 'A', 'B', 'C'));
	}
	
	//T.C : O(2^n)
	//S.C : O(n) - Recursion Stack Space
	
	public static long towerOfHonai(int N, char from, char to, char aux) {
		// No moves needed for zero disks
		if (N == 0) {
			System.out.println("move disk " + N + " from rod " + from + " to rod " + to);
			return 0;
		}
		
		//If Disk is 1 then moves would be 1
		if(N==1) {
			return 1;
		}

		 // Move n-1 disks from 'from' to 'aux' using 'to' as auxiliary
		long count = towerOfHonai(N - 1, from, aux, to);

		System.out.println("move disk " + N + " from rod " + from + " to rod " + to);
		count++;

		// Move n-1 disks from 'aux' to 'to' using 'from' as auxiliary
		count = count + towerOfHonai(N - 1, aux, to, from);

		return count;
	}
}

/*
1
2
3		
From | to | aux

x = solve ((n-1) disks : from_rod-->aux_rod : with the help of to_rod)
		
			1
3			2
From | to | aux

1 : nth rod : From_rod --> to_rod

			1
		3	2
From | to | aux

y = solve((n-1)disks : aux_rod-->to_rod : with the help of from_rod)
		1
		2	
		3	
From | to | aux

Total move  = x + 1 + y

https://www.geeksforgeeks.org/problems/tower-of-hanoi-1587115621/1

In the Tower of Hanoi puzzle, you are given n disks stacked in ascending order (smallest at the top) on the first of three rods. The goal is to move all disks to the third rod following two rules: only one disk can be moved at a time, and a disk can only be placed on top of a larger disk. Given the number of disks n and three rods labeled as from, to, and aux (starting rod, target rod, and auxiliary rod, respectively),  returns the total number of moves needed to transfer all disks from the starting rod to the target rod.

Examples:

Input: n = 2
Output: 3
Explanation: For n =2 , steps will be as follows in the example and total 3 steps will be taken.
move disk 1 from rod 1 to rod 2
move disk 2 from rod 1 to rod 3
move disk 1 from rod 2 to rod 3

Input: n = 3
Output: 7
Explanation: For N=3 , steps will be as follows in the example and total 7 steps will be taken.
move disk 1 from rod 1 to rod 3
move disk 2 from rod 1 to rod 2
move disk 1 from rod 3 to rod 2
move disk 3 from rod 1 to rod 3
move disk 1 from rod 2 to rod 1
move disk 2 from rod 2 to rod 3
move disk 1 from rod 1 to rod 3

Input: n = 0
Output: 0
Explanation: Total 0 steps will be taken.

Constraints:
0 <= n <= 16

*/