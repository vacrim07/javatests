package com.vapps.javatests.player;

public class Player {

    private Dice dice;
    private Integer minNumberToWin;

    public Player(Dice dice, Integer minNumberToWin) {
        this.dice = dice;
        this.minNumberToWin = minNumberToWin;
    }

    public Boolean play(){
        Integer diceNumber = dice.roll();
        return diceNumber > minNumberToWin;
    }
}
