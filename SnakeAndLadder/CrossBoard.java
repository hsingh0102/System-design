package org.example;

import java.util.*;

public class CrossBoard {

    private Dice dice;
    private Queue<Player> allPlayer;
    private List<Jumper> Snakes;
    private List<Jumper> Ladders;
    private Map<String , Integer> positionOfPlayer;
    int broardSize;

    public CrossBoard(Dice dice, Queue<Player> allPlayer, List<Jumper> snakes, List<Jumper> ladders, Map<String, Integer> positionOfPlayer, int broardSize) {
        this.dice = dice;
        this.allPlayer = allPlayer;
        Snakes = snakes;
        Ladders = ladders;
        this.positionOfPlayer = positionOfPlayer;
        this.broardSize = broardSize;
    }

    void start(){
        while(allPlayer.size()>1){
            Player player = allPlayer.poll();
            int currentPosition = positionOfPlayer.get(player.getPlayer());
            int nxtCell= currentPosition + dice.rollDice();

            if(nxtCell > broardSize ){allPlayer.offer(player);}
            else if (nxtCell == broardSize) {
                System.out.println("\u001B[34mSuccess: " + player.getPlayer() + " wins the match\u001B[0m");
            }
            else{
                int nxtPositin[]={nxtCell};
                Snakes.forEach(n->{
                    if(n.startPoint==nxtCell){
                        nxtPositin[0]=n.endPoint;
                    }
                });

                if(nxtPositin[0]!=nxtCell) System.out.println("\u001B[31mWarning: snake bites " + player.getPlayer() + " at " + nxtCell + "\u001B[0m");

                Ladders.forEach(n->{
                    if(n.startPoint==nxtCell){
                        nxtPositin[0]=n.endPoint;
                    }
                });
                if(nxtPositin[0]!=nxtCell) System.out.println("\u001B[32mAchievement: " + player.getPlayer() + " gets a ladder at " + nxtCell + "\u001B[0m");

                if(nxtPositin[0]==broardSize) System.out.println("\u001B[34mSuccess: " + player.getPlayer() + " wins the match\u001B[0m");

                else{
                    positionOfPlayer.put(player.getPlayer(), nxtPositin[0]);
                    System.out.println(player.getPlayer() + " is at position "+ nxtPositin[0]);
                    allPlayer.offer(player);
                }
            }
        }

    }
}
