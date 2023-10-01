package com.scraft.application;

import java.util.List;
import java.util.Random;

public class Randomizer<T> {

    public T getRandomlyFrom(List<T> items) {
        Random random = new Random();
        return items.get(random.nextInt(items.size()));
    }

}
