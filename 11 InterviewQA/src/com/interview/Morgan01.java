package com.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Morgan01 {
	public static void main(String[] args) {
		List list = new ArrayList<>();
		/*
		for (Object object : reverse(list)) {
			
		}
		*/
	}
	
	public static Iterator reverse(List list) {
		Collections.reverse(list);
		return list.iterator();
	}
}
