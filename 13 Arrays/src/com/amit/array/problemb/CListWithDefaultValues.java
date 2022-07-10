package com.amit.array.problemb;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//List with default values
public class CListWithDefaultValues {
	public static void main(String[] args) {
		ListWithdefaultValues1();
		System.out.println("----------");
		ListWithdefaultValues2();
	}

	private static void ListWithdefaultValues1() {
		Integer[] integers = new Integer[10];
		Arrays.fill(integers, -2);
		List<Integer> integerList = Arrays.asList(integers);
		integerList.forEach(x->System.out.println(x));
	}
	
	private static void ListWithdefaultValues2() {
		List<Integer> list = Collections.nCopies(5, -1);
		list.forEach(x->System.out.println(x));
	}
}
