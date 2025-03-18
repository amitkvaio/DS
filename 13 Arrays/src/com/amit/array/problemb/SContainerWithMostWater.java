package com.amit.array.problemb;

public class SContainerWithMostWater {
	
	public static int getMostWaterArea(int [] heights) {
		int left = 0 ;
		int right = heights.length -1;
		int area = 0 ;
		while(left < right) {
			int minHight = Math.min(heights[left], heights[right]);
			int width  = right - left;
			area = Math.max(area, minHight * width);
			
			if(heights[left] < heights [right]) {
				left++;
			}else {
				right--;
			}
		}
		return area;
	}
	
	
	public static void main(String[] args) {
		int [] heights = {1,8,6,2,5,4,8,3,7};
		System.out.println(getMostWaterArea(heights));
	}
}

/*
https://leetcode.com/problems/container-with-most-water/
LC : 11

*/