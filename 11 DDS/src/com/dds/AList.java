package com.dds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
You have given the list of Integer and its corresponding index has saved in HashMap with its value.
Delete an given elements from the List in O(1), if you have already given the index of Removal elements.
*/
public class AList {
	
	private static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	private static List<Integer> list = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		insert(10);
		insert(20);
		insert(50);
		insert(40);
		insert(30);
		System.out.println(list);
		System.out.println(map);
		
		//Want to remove 50 in O(1);
		int remval = 50;
		int indexRemVal = map.get(remval);
		 
		System.out.println("\nIndex of : "+remval +" is : "+indexRemVal);
		int lastElemetIdx = list.size()-1;
		
		//if we directly remove the 50 then all the number after that need to swap one step before, so it will takes O(n)
		//Replace 50 position with the last elements.
		list.set(indexRemVal, list.get(lastElemetIdx));
		System.out.println(list);
		
		//Replace last position with 50 // This is not required.
		list.set(lastElemetIdx, remval);
		System.out.println(list);
		
		//Removing last elements in O(1)
		list.remove(lastElemetIdx);
		map.remove(remval);
		
		//After removing printing the list
		System.out.println(list);
		System.out.println(map);
	}
	
	public static boolean insert(int val) {
		if (map.containsKey(val))
			return false;
		list.add(val);
		map.put(val, list.size() - 1);
		return true;
	}
}
