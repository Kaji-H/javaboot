package com.kajiH.practice0206;

public class DoubtfulNamingRules {// 1
	public static void main(String[] args) {
		int value = 555;// 2
		double myDouble = 23;// 3

		double result = value / myDouble;// 4,5,6

		System.out.printf("%d ÷ %d = %d%n", value, myDouble, result);// 7,8,9
	}
}