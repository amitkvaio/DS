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

public class DBSFirstAndLastOccurence {
	public static void main(String[] args) {
		int arr[] = {10,20,30,30,30,40,50,60,70,80,90,100};
		List<Integer> list = IntStream.of(arr).boxed().collect(Collectors.toList());
		int target =30;
		int stIndex  = getFirstIndex(list, target);
		int lstIndex = getLastIndex(list,target);
		System.out.println(stIndex+"::"+lstIndex);	
		System.out.println("**************************");
		int stIndex1  = getFirstandLastIndex(list, target,true);
		int lstIndex2= getFirstandLastIndex(list, target,false);
		System.out.println(stIndex1+"::"+lstIndex2);	
	}
	
	public static int getFirstIndex(List<Integer> list, int target) {
		int s = 0;
		int e = list.size() - 1;
		int ans = -1;
		while (s <= e) {
			int mid = s + (e - s) / 2; /// (s+e)/2

			if (list.get(mid) == target) {
				ans = mid;
				e = mid - 1; /// LHS for first pos
				/// return mid;
			} else if (list.get(mid) < target) {
				s = mid + 1;
			} else {
				e = mid - 1;
			}
		}
		return ans;
	}
	
	public static int getLastIndex(List<Integer> list, int target) {
		int s = 0;
		int e = list.size() - 1;
		int ans = -1;
		while (s <= e) {
			int mid = s + (e - s) / 2; /// (s+e)/2
			if (list.get(mid) == target) {
				ans = mid;
				s = mid + 1; /// RHS for first pos
				/// return mid;
			} else if (list.get(mid) < target) {
				s = mid + 1;
			} else {
				e = mid - 1;
			}
		}
		return ans;
	}
	
	public static int getFirstandLastIndex(List<Integer> list, int target,boolean getFirstStatus) {
		int s = 0;
		int e = list.size() - 1;
		int ans = -1;
		while (s <= e) {
			int mid = s + (e - s) / 2; /// (s+e)/2
			if (list.get(mid) == target) {
				if (getFirstStatus) {
					e = mid - 1; //Get first index =LHS
				} else {
					s = mid + 1; //Get last index = RHS
				}
				ans = mid;
			} else if (list.get(mid) < target) {
				s = mid + 1;
			} else {
				e = mid - 1;
			}
		}
		return ans;
	}
}
