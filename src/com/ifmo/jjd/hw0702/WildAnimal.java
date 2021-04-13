package com.ifmo.jjd.hw0702;

public class WildAnimal extends Animal {
    private int force;
    private int driveAway = 0;

    public WildAnimal(String name, String type, int weight, int speed, int force) {
        super(name, type, weight, speed);
        if(force < 1) throw new IllegalArgumentException("Неверное знаяение Force!");
        this.force = force;
    }

    public int getForce() {
        return force;
    }

    public int getDriveAway() {
        return driveAway;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public void driveAway() {
        this.driveAway ++;
    }

}
