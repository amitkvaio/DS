package ecom.binarySearchTree;
//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
/*
int arr[] = {10,20,30,30,30,40,50,60,70,80,90,100};
output : [2,4]
TC : O(logn)
SC : O(1)
*/
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
//Find first the most & last most position of a element in sorted array
//Find the first and last index of a given element in sorted array.
public class DBSFirstAndLastOccurence {
	public static void main(String[] args) {
		int arr[] = {10,20,30,30,30,40,50,60,70,80,90,100};
		List<Integer> list = IntStream.of(arr).boxed().collect(Collectors.toList());
		int target =30;
		int stIndex  = getFirstMostOrLeftMostIndex(list, target);
		int lstIndex = getLastMostOrRightMostIndex(list,target);
		System.out.println(stIndex+"::"+lstIndex);	
		System.out.println("**************************");
		int stIndex1  = getFirstandLastIndex(list, target,true);
		int lstIndex2= getFirstandLastIndex(list, target,false);
		System.out.println(stIndex1+"::"+lstIndex2);	
	}
	
	public static int getFirstMostOrLeftMostIndex(List<Integer> list, int target) {
		int startIdx = 0;
		int endIdx = list.size() - 1;
		int left_most = -1;
		while (startIdx <= endIdx) {
			int mid = startIdx + (endIdx - startIdx) / 2; /// (s+e)/2

			if (list.get(mid) == target) {
				left_most = mid; //Considered possibly my answer.
				endIdx = mid - 1; // But We have to look more on left side if there is any more occurrence of a same elements.
				/// return mid;
			} else if (list.get(mid) < target) {
				startIdx = mid + 1;
			} else {
				endIdx = mid - 1;
			}
		}
		return left_most;
	}
	
	public static int getLastMostOrRightMostIndex(List<Integer> list, int target) {
		int startIdx = 0;
		int endIdx = list.size() - 1;
		int right_most = -1;
		while (startIdx <= endIdx) {
			int mid = startIdx + (endIdx - startIdx) / 2; /// (s+e)/2
			if (list.get(mid) == target) {
				right_most = mid;  //Considered possibly my answer.
				startIdx = mid + 1; // But We have to look more on right side if there is any more occurrence of a same elements.
				// return mid;
			} else if (list.get(mid) < target) {
				startIdx = mid + 1;
			} else {
				endIdx = mid - 1;
			}
		}
		return right_most;
	}
	
	public static int getFirstandLastIndex(List<Integer> list, int target,boolean getFirstStatus) {
		int startIdx = 0;
		int endIdx = list.size() - 1;
		int left_or_right_most = -1;
		while (startIdx <= endIdx) {
			int mid = startIdx + (endIdx - startIdx) / 2; /// (s+e)/2
			if (list.get(mid) == target) {
				if (getFirstStatus) {
					endIdx = mid - 1; //Get first index =LHS
				} else {
					startIdx = mid + 1; //Get last index = RHS
				}
				left_or_right_most = mid;
			} else if (list.get(mid) < target) {
				startIdx = mid + 1;
			} else {
				endIdx = mid - 1;
			}
		}
		return left_or_right_most;
	}
}
