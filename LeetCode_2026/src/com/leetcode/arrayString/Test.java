package com.leetcode.arrayString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {
	//Find the 2nd highest and count
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(100);
		list.add(200);
		list.add(300);
		list.add(400);
		list.add(100);
		list.add(200);
		list.add(300);
		list.add(100);
		list.add(500);
		
		 list.stream().collect(Collectors.groupingBy(x->x, Collectors.counting()))
				.forEach((k,v)->System.out.println(k +":"+v));
		
		Map<Integer,Long> map1 =list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		map1.entrySet()
		.stream()
		.sorted(Map.Entry.<Integer, Long>comparingByValue().reversed()).limit(2).skip(1)
		.collect(Collectors.toMap(Entry::getKey, Entry::getValue))
		.forEach((k,v)->System.out.println(k +":"+v));
	}
}
