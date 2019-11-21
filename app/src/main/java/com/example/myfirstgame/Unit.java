package com.example.myfirstgame;

public class Unit {
    private String name = "Unit_1";
    private int health = 100;
    private String state = "idle";
    private int damage = 25;

    public Unit(String name, int health, int damage){
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public String getName(){
        return name;
    }

    public int getHealth(){
        return health;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public String getState(){
        return state;
    }

    public void setState(String state){
        this.state = state;
    }
}
