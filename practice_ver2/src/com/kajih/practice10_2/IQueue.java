package com.kajih.practice10_2;

public interface IQueue {
    public void push(String data);

    public void push(String data, int priority);

    public String pop();
}
