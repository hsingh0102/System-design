package org.example;

import javax.swing.plaf.metal.MetalTabbedPaneUI;

public class Dice {

    private int noOfDice;

    Dice(int dice){
        this.noOfDice=dice;
    }

    int rollDice(){
        return ((int) (Math.random()*(6*noOfDice - 1*noOfDice))) + 1;
    }
}
