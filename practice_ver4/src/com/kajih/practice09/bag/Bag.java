package com.kajih.practice09.bag;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private int size;
    private int freeSpace;
    private List<Item> itemList = new ArrayList<>();

    public Bag(int size) {
        this.size = size;
        this.freeSpace = size;
    }

    public void put(Item item) {
        int itemSize = item.getSize();

        if (this.freeSpace - itemSize < 0) {
            System.out.println("error");
            return;
        }
        this.freeSpace -= itemSize;
        itemList.add(item);
    }

    public void check() {
        System.out.println("空き　" + freeSpace);
        for (Item item : itemList) {
            System.out.println(item.getName() + "   " + item.getSize());
        }
    }

    public void out(Item item) {
        try {
            itemList.remove(itemList.indexOf(item));
        } catch (IndexOutOfBoundsException e) {
            return;
        }

        freeSpace += item.getSize();

    }

    public void sortNamesInAscendingOrder() {
        itemList.sort((itemA, itemB) -> itemA.name.compareTo(itemB.name));
    }

}
