package amit.kumar.recursion;

public class NGemetricSeries {
	public static void main(String[] args) {
		System.out.println(geometricSum(3));
		System.out.println(geometricSum(4));
		System.out.println(geometricSum(5));
	}
	
	public static double geometricSum(int n) {
		return solution(n, 0);
	}

	public static double solution(int n, double res) {
		if (n < 0) {
			return res;
		}
		res = res + (1 / Math.pow(2, n));
		return solution((n - 1), res);
	}
}
// check the GeometricSeries.jpg
/*
Time Complexity	O(n)
Space Complexity	O(n)
*/