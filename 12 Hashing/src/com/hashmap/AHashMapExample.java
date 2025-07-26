package com.hashmap;

import java.util.HashMap;

public class AHashMapExample {
	public static void main(String[] args) {
		HashMap<String, Integer> products = new HashMap<String, Integer>();
		
		//add some key-value pairs
		products.put("Apple", 10);
		products.put("Banana", 5);
		products.put("Orange", 15);
		products.put("Guava", 20);
		
		//retrieve a value by its key
		int stock = products.get("Apple");
		System.out.println("The stock of Apple is: "+ stock);
		
		//update the value of a key
		products.put("Banana", 0);
		
		//Remove a key-value pair
		products.remove("Orange");
		
		//Iterate over  the key-value pairs
		for (String product : products.keySet()) {
			int stk = products.get(product);
			System.out.println(product +":" + stk);
		}
	}
}
/*
The stock of Apple is: 10
Guava:20
Apple:10
Banana:0

Why Hashmap
Efficient Retrieval
Flexibility : Hash maps can store any type of object as a key or value
Space efficiency : Hash map use an array of buckets to store key-value pairs.
Constant-time operation
*/