package com.dds;
public class CParkingSystem {
	
	private int big;
	private int medium;
	private int small;

	public CParkingSystem(int big, int medium, int small) {
		this.big = big;
		this.medium = medium;
		this.small = small;
	}

	public boolean addCar(int carType) {
		if (carType == 1 && big != 0) {
			big = big - 1;
			return true;
		} else if (carType == 2 && medium != 0) {
			medium = medium - 1;
			return true;
		} else if (carType == 3 && small != 0) {
			small = small - 1;
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		CParkingSystem cParkingSystem = new CParkingSystem(1, 1, 0);
		System.out.println(cParkingSystem.addCar(1));
		System.out.println(cParkingSystem.addCar(2));
		System.out.println(cParkingSystem.addCar(3));
		System.out.println(cParkingSystem.addCar(1));
	}
}

/*
https://leetcode.com/problems/design-parking-system/description/
1603. Design Parking system

*/