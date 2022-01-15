package com.kajih.practice10_3;

public class Main {
    public static void main(String[] args) {
        RandomQueue queue = new RandomQueue();

        queue.push("１番目");
        queue.push("２番目");
        queue.push("３番目");

        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
