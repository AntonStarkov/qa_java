package com.example;

import java.util.List;

public interface Predator {

    List<String> eatMeat() throws Exception;

    public int getKittens(int kittensCount);
    public int getKittens();

    public List<String> getFood() throws Exception;
}
