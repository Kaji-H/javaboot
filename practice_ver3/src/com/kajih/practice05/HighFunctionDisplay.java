package com.kajih.practice05;

public class HighFunctionDisplay implements Printable, Showable {

    @Override
    public void show() {
        System.out.println("[HighFunctionDisplay] 表示しました");
    }

    @Override
    public void print() {
        System.out.println("[HighFunctionDisplay] 印刷しました。");
    }

}
