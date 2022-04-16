package leet.code.problem;
// https://leetcode.com/problems/fizz-buzz/
public class D {
	public static void main(String[] args) {
		fizzBuzz(15);
	}
	public static void fizzBuzz(int n) {
		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				System.out.println("FizzBuzz");
			} else if (i % 3 == 0) {
				System.out.println("Fizz");
			} else if (i % 5 == 0) {
				System.out.println("Buzz");
			} else {
				System.out.println(i);
			}
		}
	}
}
/*
TC : O(n)
SC : O(1)

*/