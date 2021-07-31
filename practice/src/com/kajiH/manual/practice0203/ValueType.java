package com.kajiH.manual.practice0203;

/*
型を指定する書式指定子

%	なし	書式指定子の開始	なし	なし
d	整数	10進数で出力	printf("%d", 123)	123
o	整数	8進数で出力	printf("%o", 123)	173
x	整数	16進数で出力	printf("%x", 123)	7b
e	小数	指数で出力	printf("%e", 123.4f)	1.23E+02
f	小数	小数点数出力	printf("%f", 123.4f)	123.4
s	文字列	文字列を出力	printf("%s", “abc”)	abc
c	文字	文字を出力	printf("%c", ‘a’)	a
b	真偽値	真偽値を出力	printf("%b", true)	true
 */

public class ValueType {

	public static void main(String[] args) {

		booleanType();
		byteType();
		shortType();
		intType();
		longType();
		doubleType();
		floatType();
		charType();

	}

	// practice 1
	private static void booleanType() {
		boolean hasElephantLongNose = true;
		boolean isJapanLargerThanAmerica = false;

		System.out.printf("象の鼻は長いか？ = %b\n", hasElephantLongNose);
		System.out.printf("日本はアメリカよりも大きいか？ = %b\n", isJapanLargerThanAmerica);
	}

	// practice 2
	private static void byteType() {
		// byte minByte = -128;
		// byte maxByte = 127;

		byte minByte = Byte.MIN_VALUE;
		byte maxByte = Byte.MAX_VALUE;

		System.out.printf("byte 型の最小値 = %4d\n", minByte);
		System.out.printf("byte 型の最大値 = %4d\n", maxByte);
	}

	// practice 3
	private static void shortType() {
		short minShort = Short.MIN_VALUE;
		short maxShort = Short.MAX_VALUE;

		System.out.printf("short 型の最小値 = %d\n", minShort);
		System.out.printf("short 型の最大値 = %d\n", maxShort);
	}

	// practice 4
	private static void intType() {
		int minInt = Integer.MIN_VALUE;
		int maxInt = Integer.MAX_VALUE;

		System.out.printf("int 型の最小値 = %d\n", minInt);
		System.out.printf("int 型の最大値 = %d\n", maxInt);
	}

	// practice 5
	private static void longType() {
		long minLong = Long.MIN_VALUE;
		long maxLong = Long.MAX_VALUE;
		long smallLong = -42332200000L;

		System.out.printf("long 型の最小値 = %d\n", minLong);
		System.out.printf("long 型の最大値 = %d\n", maxLong);
		System.out.printf("\nlong 型の負数 = %d\n", smallLong);
	}

	// practice 6
	private static void doubleType() {
		double minDouble = Double.MIN_VALUE;
		double maxDouble = Double.MAX_VALUE;

		System.out.printf("double 型の最小値 = %e\n", minDouble);
		System.out.printf("double 型の最大値 = %e\n", maxDouble);
	}

	// practice 7
	private static void floatType() {
		float minFloat = Float.MIN_VALUE;
		float maxFloat = Float.MAX_VALUE;
		float smallFloat = -42.3f;

		System.out.printf("float 型の最小値 = %s\n", minFloat);
		System.out.printf("float 型の最大値 = %s\n", maxFloat);
		System.out.println();
		System.out.printf("float 型の負数 = %s\n", smallFloat);
	}

	// practice 8
	private static void charType() {
		char alphabet = 'E';
		char number = '9';
		char symbol = '%';
		char japaneseChar = 'あ';

		System.out.printf("英字 = %c\n", alphabet);
		System.out.printf("数字 = %c\n", number);
		System.out.printf("記号 = %c\n", symbol);
		System.out.printf("日本語 = %c\n", japaneseChar);
	}
}
