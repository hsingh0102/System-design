package org.example;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Snake and Ladder Game");

        Dice dice = new Dice(1);

        Player p1 = new Player("Hariom",1);
        Player p2 = new Player("Ashutosh",2);
        Player p3 = new Player("Nidhi",3);

        Queue<Player> allPlayer = new LinkedList<>();
        allPlayer.offer(p1);
        allPlayer.offer(p2);
        allPlayer.offer(p3);

        Jumper snake1 = new Jumper(10,2);
        Jumper snake2 = new Jumper(99,12);
        Jumper snake3 = new Jumper(55,4);
        Jumper snake4 = new Jumper(38,16);
        Jumper snake5 = new Jumper(88,13);
        List<Jumper> snakes = new ArrayList<>();
        snakes.add(snake1);
        snakes.add(snake2);
        snakes.add(snake3);
        snakes.add(snake4);
        snakes.add(snake5);

        Jumper ladder1 = new Jumper(5,25);
        Jumper ladder2 = new Jumper(40,89);
        List<Jumper> ladders = new ArrayList<>();
        ladders.add(ladder1);
        ladders.add(ladder2);

        Map<String ,Integer> positionOfPlayer = new HashMap<>();
        positionOfPlayer.put("Hariom",0);
        positionOfPlayer.put("Ashutosh",0);
        positionOfPlayer.put("Nidhi",0);

        CrossBoard game = new CrossBoard(dice ,allPlayer, snakes, ladders , positionOfPlayer ,100);
        game.start();
    }
}