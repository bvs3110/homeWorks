package com.ifmo.jjd.hw0702;

public class PetAnimal extends Animal{
    private int health;
    final private int startHealth;
    private boolean isEdible;
    private int resource;

    public PetAnimal(String name, String type, int weight, int speed, int health, boolean isEdible, int resource) {
        super(name, type, weight, speed);
        if(health < 1) throw new IllegalArgumentException("Неверное знаяение Health!");
        this.health = health;
        this.startHealth = health;
        this.isEdible = isEdible;
        if(resource < 0) throw new IllegalArgumentException("Неверное знаяение Resource!");
        this.resource = resource;
    }

    public int getHealth() {
        return health;
    }

    public boolean isEdible() {
        return isEdible;
    }

    public int getResource() {
        return resource;
    }

    public void addHealth() {
        if(health + 1 < startHealth) health++;
    }

}
