package com.problem.soving01;

import java.util.Arrays;
import java.util.stream.Stream;

public class IRemovingDupElementsUsingjava8 {
	public static void main(String[] args) {
		String[] arryStr = { "wipro", "wipro", "digi", "done", "start", "digi" };
		Stream.of(arryStr).distinct().forEach(str -> System.out.println(str));
		System.out.println("**************************************************");
		int count = (int) Stream.of(arryStr).distinct().count();
		System.out.println(count);
		Arrays.asList(arryStr).stream().distinct().forEach(s -> System.out.println(s));
	}
}