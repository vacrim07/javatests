package com.vapps.javatests.player;

import java.util.Random;

public class Dice {
    private int sides;

    public Dice(int sides) {
        this.sides = sides;
    }

    public Integer roll(){
        return new Random().nextInt(sides) +1 ;
    }
}
