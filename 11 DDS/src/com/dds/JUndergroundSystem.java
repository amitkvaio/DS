package com.dds;
import java.util.HashMap;
import java.util.Map;

public class JUndergroundSystem {
	
	private static class CheckInPair {
		public String startStation;
		public int checkInTime;

		public CheckInPair(String startStation, int checkInTime) {
			this.startStation = startStation;
			this.checkInTime = checkInTime;
		}
	}
	
	private static class Pair {
		public int travelTime;
		public int count;

		public Pair(int travelTime, int count) {
			this.travelTime = travelTime;
			this.count = count;
		}
	}
	
	public Map<Integer,CheckInPair> checkInMap;
	public Map<String,Pair> checkOutMap;
	
	public JUndergroundSystem() {
		checkInMap = new HashMap<Integer, JUndergroundSystem.CheckInPair>();
		checkOutMap = new HashMap<String, JUndergroundSystem.Pair>();
	}
	
	public void checkIn(int id,String startStation, int checkInTime) {
		checkInMap.put(id, new CheckInPair(startStation, checkInTime));
	}
	
	public void checkOut(int id, String endStation, int checkOutTime) {
		if (!checkInMap.containsKey(id)) 
				return;
		CheckInPair checkInPair = checkInMap.remove(id);
		int travelTime = checkOutTime - checkInPair.checkInTime;
		String rout = checkInPair.startStation + "-->" + endStation;
		
		if (checkOutMap.containsKey(rout)) {
			Pair pair = checkOutMap.remove(rout);
			checkOutMap.put(rout, new Pair(pair.travelTime + travelTime, pair.count + 1));
		}else {
			checkOutMap.put(rout, new Pair(travelTime, 1));
		}
		
	}
	
	public double getAverageTime(String startStation, String endStation) {
		String rout = startStation + "-->" + endStation;
		Pair pair = checkOutMap.get(rout);
		return (double)pair.travelTime / pair.count;
	}
	
	public static void main(String[] args) {
		JUndergroundSystem sys = new JUndergroundSystem();
		sys.checkIn(10, "Leyton", 3);
		sys.checkOut(10, "Paradise", 8); // Customer 10 "Leyton" -> "Paradise" in 8-3 = 5
		System.out.println(sys.getAverageTime("Leyton", "Paradise")); // return 5.00000, (5) / 1 = 5
		sys.checkIn(5, "Leyton", 10);
		sys.checkOut(5, "Paradise", 16); // Customer 5 "Leyton" -> "Paradise" in 16-10 = 6
		System.out.println(sys.getAverageTime("Leyton", "Paradise")); // return 5.50000, (5 + 6) / 2 = 5.5
		sys.checkIn(2, "Leyton", 21);
		sys.checkOut(2, "Paradise", 30); // Customer 2 "Leyton" -> "Paradise" in 30-21 = 9
		System.out.println(sys.getAverageTime("Leyton", "Paradise")); // return 6.66667, (5 + 6 + 9) / 3 = 6.66667
	}
}
/*
https://leetcode.com/problems/design-underground-system/description/
LeetCode : 1396
*/