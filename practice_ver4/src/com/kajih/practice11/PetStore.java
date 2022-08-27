package com.kajih.practice11;

import com.kajih.practice11.Bird.Bird;
import com.kajih.practice11.Bird.Eagle;
import com.kajih.practice11.Bird.Pigeon;

// ジェネリックスとはJavaをはじめとする多くのオブジェクト指向型言語で採用される仕組み
// <>で囲んで利用し<~>に型を記載し指定できる機能
// 主にListに使われる
// 例：　List<String> list = new ArrayList<>()

// ジェネリックスを活用したクラスの紹介
// public class Practice<T>{
//     private T first;
//     private T second;

//     public Practice(T first,T second){
//         this.first = first;
//         this.second = second;
//     }
// }

// main Practice p = new Practice<String>("aa","bb");

public class PetStore {
    public static void main(String[] args) {
        Cage<Bird> birdCage = new Cage<>();

        birdCage.addBird(new Eagle("ハクトウワシ"));
        birdCage.addBird(new Pigeon("伝書鳩"));
        birdCage.addBird(new Eagle("オジロワシ"));

        for (Bird bird : birdCage.getBirds()) {
            bird.fly();
            bird.showDetails();
            System.out.println();
        }
    }
}
