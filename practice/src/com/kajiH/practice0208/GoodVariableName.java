package com.kajiH.practice0208;

public class GoodVariableName {
	public static void main(String[] args) {

		int myAge = 23;
		int myWeight = 62;
		int myFatherAge = 45;

		int sumAges = myFatherAge + myAge;

		System.out.println("ぼくの名前は、山本一郎");
		System.out.printf("年齢は %d 歳です.", myAge);
		System.out.printf("体重は %d 歳です.", myWeight);
		System.out.printf("パパの年齢は %d 歳です.", myFatherAge);
		System.out.printf("パパとぼくの年齢を合わせると %d 歳です.", sumAges);
	}
}
