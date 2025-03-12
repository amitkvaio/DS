package com.dds;

import java.util.HashMap;
import java.util.Map;

import java.util.*;

public class KFoodRatingSystem {
	// Maps each food item to its rating and cuisine
	private Map<String, FoodItem> foodData;

	// Maps each cuisine type to a sorted set of food items
	private Map<String, TreeSet<String>> cuisineFoods;

	// Constructor to initialize the system
	public KFoodRatingSystem(String[] foods, String[] cuisines, int[] ratings) {
		foodData = new HashMap<>(); // Stores the food items with their ratings and cuisines
		cuisineFoods = new HashMap<>(); // Maps cuisine to a sorted set of food items

		for (int i = 0; i < foods.length; i++) {
			foodData.put(foods[i], new FoodItem(foods[i], cuisines[i], ratings[i]));

			// Initialize a TreeSet for each cuisine if not already present
			if (!cuisineFoods.containsKey(cuisines[i])) {
				cuisineFoods.put(cuisines[i], new TreeSet<>(new FoodComparator()));
			}

			cuisineFoods.get(cuisines[i]).add(foods[i]); // Add food to the sorted set
		}
	}

	// Method to change the rating of a food item
	public void changeRating(String food, int newRating) {
		FoodItem item = foodData.get(food);
		String cuisine = item.cuisine;

		cuisineFoods.get(cuisine).remove(food); // Remove the food from the sorted set
		item.rating = newRating; // Update the food rating
		cuisineFoods.get(cuisine).add(food); // Reinsert the food to maintain order
	}

	// Method to return the highest-rated food item for a given cuisine
	public String highestRated(String cuisine) {
		return cuisineFoods.get(cuisine).first(); // Return the first element in the sorted set
	}

	// Custom class to store food item details
	private static class FoodItem {
		String name;
		String cuisine;
		int rating;

		FoodItem(String name, String cuisine, int rating) {
			this.name = name;
			this.cuisine = cuisine;
			this.rating = rating;
		}
	}

	// Custom comparator to sort foods by rating and then lexicographically
	private class FoodComparator implements Comparator<String> {
		@Override
		public int compare(String food1, String food2) {
			int ratingComparison = Integer.compare(foodData.get(food2).rating, foodData.get(food1).rating); // Compare
			if (ratingComparison != 0) {
				return ratingComparison;
			}
			return food1.compareTo(food2); // If ratings are equal, compare lexicographically
		}
	}
	
	public static void main(String[] args) {
		KFoodRatingSystem foodRatings = new KFoodRatingSystem(
				new String[] {"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"}, 
				new String[] {"korean", "japanese", "japanese", "greek", "japanese", "korean"},
				new int[] {9, 12, 8, 15, 14, 7});
		System.out.println(foodRatings.highestRated("korean")); // return "kimchi"
		                                    // "kimchi" is the highest rated korean food with a rating of 9.
		System.out.println(foodRatings.highestRated("japanese")); // return "ramen"
		                                      // "ramen" is the highest rated japanese food with a rating of 14.
		foodRatings.changeRating("sushi", 16); // "sushi" now has a rating of 16.
		System.out.println(foodRatings.highestRated("japanese")); // return "sushi"
		                                      // "sushi" is the highest rated japanese food with a rating of 16.
		foodRatings.changeRating("ramen", 16); // "ramen" now has a rating of 16.
		System.out.println(foodRatings.highestRated("japanese")); // return "ramen"
		                                      // Both "sushi" and "ramen" have a rating of 16.
		                                      // However, "ramen" is lexicographically smaller than "sushi".
	}
	
}

/*
https://leetcode.com/problems/design-a-food-rating-system/description/
Leetcode : 2353
*/
