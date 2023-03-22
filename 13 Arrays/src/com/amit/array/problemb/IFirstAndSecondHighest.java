package com.amit.array.problemb;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
//Msys
//Find the second Highest Number
public class IFirstAndSecondHighest {
	public static void main(String[] args) {
		int[] arr = { 100, 14, 46, 47, 94, 94, 52, 86, 36, 94, 89 };
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		System.out.println("First Maximum Number::"+list.stream()
			.max((x1, x2) -> x1.compareTo(x2)).get());
		secondMax(arr);
	}

	private static void secondMax(int[] arr) {
		int n = arr.length;
		int firsth = Integer.MIN_VALUE;
		int secondh = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			if (arr[i] > firsth) {
				secondh = firsth;
				firsth = arr[i];
			} else if (arr[i] > secondh) {
				secondh = arr[i];
			}
		}
		System.out.println("Second Highest Number::"+secondh);
	}
}
