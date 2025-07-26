package bcom.logical.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EMergeIntervals {
	
	public static void main(String[] args) {
		int[][] intervals = { { 1, 3 }, { 15, 18 }, { 2, 6 }, { 16, 17 }, { 8, 9 } };
		int[][] result = merge(intervals);
		System.out.println("**********");
		print(result);
	}

	public static int[][] merge(int[][] intervals) {
		
		//print(intervals);
		//Here intervals is the 2D arrays { { 1, 3 }, { 15, 18 }, { 2, 6 }, { 16, 17 }, { 8, 9 } }
		// a = {1,3}. a[0] meaning start time of the first interval
		// b = {15,18}, b[0] meaning start time of 2nd interval 
		//Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		Arrays.sort(intervals, new IntervalComparator()); // Sorting the array based on start time.
		print(intervals);
		/*
		After sort
			0	1
		0	[1, 3]
		1	[2, 6]
		2	[8, 9]
		3	[15, 18]
		4	[16, 17]
		*/
		int start = intervals[0][0];
		int end = intervals[0][1];
		
		List<int[]> res = new ArrayList<>();
		
		for (int[] arr : intervals) {
			if(arr[0] <= end) {
				end = Math.max(end, arr[1]);
				//System.out.println(end + " :" + arr[1]);
				//break;
			}else {
				res.add(new int[] {start,end});
				start = arr[0];
				end = arr[1];
			}
		}
		res.add(new int[] {start,end});
		
		return res.toArray(new int[0][]);
	}

	
	
	private static void print(int[][] intervals) {
		//Printing the intervals, this is not required.
		for (int[] interval : intervals) {
			//System.out.println("{" + interval[0] + "," + interval[1] + "}");
			System.out.println(Arrays.toString(interval));
		}
	}
	
	
}

//Step 1: Create a separate comparator class
class IntervalComparator implements Comparator<int[]> {
	@Override
	public int compare(int[] a, int[] b) {
		return Integer.compare(a[0], b[0]); // Compare by start time
	}
}
/*
DryRun
*****
➤ 1st Iteration: {1, 3}
Current start = 1, end = 3
arr[0] = 1, which is <= 3 → merge
Update end = max(3, 3) = 3


➤ 2nd Iteration: {2, 6}
arr[0] = 2 ≤ end = 3 → merge
Update end = max(3, 6) = 6

➤ 3rd Iteration: {8, 9}
arr[0] = 8 > end = 6 → no overlap
✅ Add merged interval {1, 6} to result
Set new start = 8, end = 9


➤ 4th Iteration: {15, 18}
arr[0] = 15 > end = 9 → no overlap
✅ Add {8, 9}
Set start = 15, end = 18


➤ 5th Iteration: {16, 17}
arr[0] = 16 ≤ end = 18 → merge
Update end = max(18, 17) = 18

✅ Add final interval {15, 18} after loop ends
✅ Final Result in res:

[
  {1, 6},
  {8, 9},
  {15, 18}
]

✅ Output:

{1,6}
{8,9}
{15,18}

*/