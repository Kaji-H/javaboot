package com.kajiH.manual.practice0205;

/*
 * データ型を変換することを型キャストと言います。
 */

public class Cast {

	public static void main(String[] args) {

		convertDoubleToInteger();
		convertCharToInteger();
	}

	// practice 1
	private static void convertDoubleToInteger() {
		double myDouble = 1.9;
		int downToInt = (int) myDouble;
		float upToFloat = (float) downToInt;

		System.out.printf("ダウンキャスト double -> int\n%.1f -> %d\n\n", myDouble,
				downToInt);

		System.out.printf("アップキャスト int -> float\n%d -> %.1f", downToInt,
				upToFloat);
	}

	// practice 2
	private static void convertCharToInteger() {
		char myChart = 'a';
		int ascii = myChart;
		int castAscii = (int) myChart;

		System.out.println("char -> int への自動キャスト");
		System.out.printf("%c -> %d\n\n", myChart, ascii);

		System.out.println("char -> int へのアップキャスト");
		System.out.printf("%c -> %d\n", myChart, castAscii);
	}

}
