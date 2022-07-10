package acom.recursion.basic;
//Geo-Metric sum
/*
TN = a1 * r^(n-1)
check the HGeoMetriProgresion.png
*/
public class HGeoMetricProgressionSum {
	public static void main(String[] args) {
		int num =3;
		System.out.println(gSum(num));
	}
	
	public static double gSum(int k) {
		//Base Case
		if(k==0)
			return 1;
		//Assumption
		double smallAns = gSum(k-1);
		
		//Calculation
		return smallAns + 1.0/Math.pow(2, k);
	}
}
