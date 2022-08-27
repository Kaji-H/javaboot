package com.kajih.practice09.bag;

public class Main {
    private static int BAG_SIZE = 10;

    public static void main(String[] args) {
        Bag myBag = new Bag(BAG_SIZE);

        Item aaa = new Item("aaa", 2);

        myBag.put(aaa);
        myBag.put(new Item("bbb", 7));
        myBag.put(new Item("ccc", 2));

        myBag.check();

        myBag.out(aaa);

        myBag.put(aaa);
        myBag.put(new Item("ccc", 2));

        myBag.check();

        myBag.sortNamesInAscendingOrder();

        myBag.check();
    }
}
