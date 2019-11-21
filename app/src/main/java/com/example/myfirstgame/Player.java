package com.example.myfirstgame;

import android.widget.TextView;

public class Player extends Unit{

    public Player(String name, int health, int damage) {
        super(name, health, damage);
    }

    public void attack(TextView consoleText, Enemy enemy){
        setState("attack");
        if (enemy.getState() != "defend"){
            enemy.setHealth(enemy.getHealth() - getDamage());
            consoleText.append("<< (" + getState() + ") " + getName() + " наносит урон " + getDamage() + " " + enemy.getName() + "\n");
            consoleText.append("У " + enemy.getName() + " осталось " + enemy.getHealth() + " хп\n");
        }
        else if (enemy.getState() == "defend"){
            consoleText.append("<< (" + enemy.getState() + ") " + enemy.getName() + " отражает удар.\n");
        }
        setState("idle");
    }
    public void defend(TextView consoleText){
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
