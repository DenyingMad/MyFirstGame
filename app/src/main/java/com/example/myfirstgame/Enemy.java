package com.example.myfirstgame;

import android.widget.TextView;

public class Enemy extends Unit{
    public Enemy(String name, int health, int damage) {
        super(name, health, damage);
    }

    public void chooseAction(TextView consoleText, Player player){
        int x = (int)(0 + Math.random() * 2);
        switch (x){
            case 0:
                attack(consoleText, player);
                break;
            case 1:
                defend(consoleText);
                break;
            default:
                break;
        }
    }

    private void attack(TextView consoleText, Player player){
        setState("attack");
        if (player.getState() != "defend"){
            player.setHealth(player.getHealth() - getDamage());
            consoleText.append("<< (" + getState() + ") " + getName() + " наносит урон " + getDamage() + " " + player.getName() + "\n");
            consoleText.append("У " + player.getName() + " осталось " + player.getHealth() + " хп\n");
        }
        else if (player.getState() == "defend"){
            consoleText.append("<< (" + player.getState() + ") " + player.getName() + " отражает удар.\n");
        }
        setState("idle");
    }
    private void defend(TextView consoleText){
        if (getState() == "defend"){
            setState("idle");
            consoleText.append("<< (" + getState() + ") " + getName() + " выходит из защиты\n");
        }
        else{
            setState("defend");
            consoleText.append("<< (" + getState() + ") " + getName() + " защищается.\n");
        }
    }
}
