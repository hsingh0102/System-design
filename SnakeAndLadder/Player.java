package org.example;

public class Player {

    private String player;
    private int id;

    Player(String player, int id){
        this.player=player;
        this.id=id;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }
}
