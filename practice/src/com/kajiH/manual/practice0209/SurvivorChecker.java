package com.kajiH.manual.practice0209;

import java.util.Random;

public class SurvivorChecker {

	public static void main(String[] args) {
		boolean isSurvive;
		String myName = "山本一郎";

		Random random = new Random();

		isSurvive = random.nextBoolean();

		if (isSurvive) {
			System.out.printf("%s は生きてるよ\n", myName);
		} else {
			System.out.printf("%s は死んでるよ\n", myName);
		}

	}

}
