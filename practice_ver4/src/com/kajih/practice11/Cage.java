package com.kajih.practice11;

import java.util.ArrayList;
import java.util.List;

import com.kajih.practice11.Bird.Bird;
import com.kajih.practice11.Bird.Eagle;

public class Cage<T> {

    private List<T> birds = new ArrayList<>();

    public void addBird(T bird) {
        birds.add(bird);
    }

    public List<T> getBirds() {
        return birds;
    }
}
