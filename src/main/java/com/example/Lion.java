package com.example;

import java.util.List;

public class Lion {

    boolean hasMane;
    Predator predator;
    public Lion(String sex) throws Exception {
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception ("Используйте допустимые значения пола животного - самей или самка");
        }
    }
    public Lion(Predator predator) throws Exception {
        this.predator = predator;
    }

    public int getKittens() {
        return predator.getKittens(1);
    }
    public int getKittens(int kittensCount) {
        return predator.getKittens(kittensCount);
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return predator.getFood();
    }
}