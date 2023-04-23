package model;

import java.util.Random;

public class Die {
    private final int NUMBER_OF_FACES = 6;

    int roll() {
        return new Random().nextInt(1, NUMBER_OF_FACES + 1);
    }
}
