package com.leetcode.easy.b;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DcountStudents {
	public static void main(String[] args) {
		System.out.println(countStudentsUsingQueueStack(new int[] {1,1,0,0}, new int[] {0,1,0,1}));//0
		System.out.println(countStudentsUsingQueueStack(new int[] {1,1,1,0,0,1}, new int[] {1,0,0,0,1,1}));//3
		System.out.println("***********************************************");
		System.out.println(countStudents(new int[] {1,1,0,0}, new int[] {0,1,0,1}));//0
		System.out.println(countStudents(new int[] {1,1,1,0,0,1}, new int[] {1,0,0,0,1,1}));//3
	}
	
	//Approach-1 (Simply simulate whatever the problem asks for)
	//T.C : O(n)
	//S.C : O(n)
	public static int countStudentsUsingQueueStack(int[] students, int[] sandwiches) {
		int len = students.length;
		Queue<Integer> que = new LinkedList<>();
		Stack<Integer> st = new Stack<>();

		for (int i = 0; i < len; i++) {
			st.push(sandwiches[len - i - 1]);
			que.add(students[i]);
		}

		int lastServed = 0;
		while (!que.isEmpty() && lastServed < que.size()) {
			if (st.peek() == que.peek()) {
				st.pop();
				que.poll();
				lastServed = 0;
			} else {
				que.add(que.peek());
				que.poll();
				lastServed++;
			}
		}
		return que.size();
	}
	
	public static int countStudents(int[] stud, int[] sand) {
		int n = stud.length;
		int[] arr = new int[2];
		// arr[0] = count of student who like circular
		// arr[1] = count of student who like square

		for (int x : stud)
			arr[x]++;

		for (int i = 0; i < n; i++) {
			if (arr[sand[i]] == 0)
				return n - i;
			arr[sand[i]]--;
		}
		return 0;
	}
}
/*

1700 Number of Students Unable to eat lunch.

https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/description/

*/
