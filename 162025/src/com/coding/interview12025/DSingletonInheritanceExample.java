package com.coding.interview12025;

public class DSingletonInheritanceExample {
	public static void main(String[] args) {
		// Get single instance of the child class
		SingletonChild obj1 = SingletonChild.getInstance();
		SingletonChild obj2 = SingletonChild.getInstance();

		// Checking if both references point to the same object
		System.out.println(obj1 == obj2); // Output: true
	}
}


class Parent {
    protected Parent() {  // Protected constructor to allow subclass instantiation
        System.out.println("Parent Constructor Called");
    }
}

//Child class (Singleton)
class SingletonChild extends Parent {
	private static SingletonChild instance;

	private SingletonChild() { // Private constructor to prevent direct instantiation
		System.out.println("SingletonChild Constructor Called");
	}

	public static SingletonChild getInstance() {
		if (instance == null) {
			instance = new SingletonChild(); // Create a single instance
		}
		return instance;
	}
}
