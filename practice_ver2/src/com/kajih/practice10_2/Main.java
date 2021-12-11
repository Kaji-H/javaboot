package com.kajih.practice10_2;

public class Main {
    public static void main(String[] args) {
        // IQueue queue = new Queue();
        AbstractQueue queue = new Queue2();

        queue.push("１番目");
        queue.push("２番目");
        queue.push("３番目");

        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());

        queue.push("1 番目", 10);
        queue.push("2 番目", 10);
        queue.push("3 番目", 100);
        queue.push("4 番目", 50);

        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
