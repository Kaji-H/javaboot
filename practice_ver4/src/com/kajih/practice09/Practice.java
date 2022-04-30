package com.kajih.practice09;

/***
 * Stream API コードがよく見やすくなる
 * for文より見やすい
 * for文の別の書き方のようなもの
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Practice {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 4, 3, 1);

        //
        integerList.stream() // streamの取得
                // 中間操作
                // .sorted(Comparator.reverseOrder()) // 降順に並べ替える
                // .sorted((a, b) -> Integer.compare(a, b))// 昇順に並べ替える

                .forEach(i -> System.out.println(i)); // 終端操作

        Animal dog = () -> "わんわん";
        Animal cat = () -> "にゃー";
        Animal elephant = () -> "ぞうぞう";
        List<Animal> animalList = Arrays.asList(dog, cat, elephant);
        animalList.stream() // streamの取得
                .map(animal -> animal.getCry()) // 中間操作

                .forEach(cry -> System.out.println(cry));
        // 終端操作 for-each文と同様
        // for (Animal animal : animalList) {
        // System.out.println(animal.getCry());
        // }
    }

    interface Animal {
        String getCry(); // 鳴き声を取得
    }
}
