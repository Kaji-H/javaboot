package com.kajih.practice08;

import java.util.function.Function;

public class App {
    public static void main(String[] args) {
        String name = "山本一郎";

        String functionsName = applyFunctions(name);

        System.out.println(functionsName);
    }

    private static String applyFunctions(String name) {
        String functionName;

        // ラムダ式
        // Function<T,R> 引数の型、戻り値の型を指定 メソッドは R apply(T);
        // Function<Integer,String> func....; String a = func.apply(10);

        // UnaryOperator<T> 引数、戻り値の型が同じ メソッドはFunctionと同じ T apply(T);

        // Consumer<T> 引数の型を指定 メソッド void accept(T);
        // Consumer<String> con ....; con.accept("aaa");

        // Predicate<T> 引数の型を指定 メソッド boolean test(T);
        // Predicate<String> pre ....; boolean a = pre.test("aaa");

        Function<String, String> pickOutFirstChar = (word) -> word.substring(0, 2);
        Function<String, String> duplicateWord = (word) -> word + word;

        functionName = duplicateWord.apply(pickOutFirstChar.apply(name));

        return functionName;
    }
}
