package com.kajih.practice10;

import java.util.ArrayList;
import java.util.List;

/*
*  メソッド参照　メソッドそのものを代入すること
*  friends.forEach(System.out::print);
*
*  クラス名::メソッド名　、　インスタンス変数名::メソッド名
*　引数があってる必要あり？
*  List<String> の場合 method(String a)　のものじゃないと使えない
*/
public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        names.add("a");
        names.add("b");
        names.add("c");
        names.add("e");

        // names.forEach(System.out::println);
        Test test = new Test();
        names.forEach(test::show);
        // names.forEach(test::showInt);//error
        // names.forEach(test::showAho);//error

        List<Integer> num = new ArrayList<>();

        num.add(1);
        num.add(2);
        num.add(3);
        num.add(33);

        num.forEach(test::showInt);
        // num.forEach(test::showAho);//error
    }
}
