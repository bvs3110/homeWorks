package com.ifmo.jjd.hw0702;

abstract public class Animal {
    final private String name;
    final private String type;
    private int weight;
    final private int speed;

    public Animal(String name, String type, int weight, int speed) {
        if(name == null || name.strip().length() < 2) throw new IllegalArgumentException("Неверное знаяение Name!");
        this.name = name.strip();
        if(type == null || type.strip().length() < 2) throw new IllegalArgumentException("Неверное знаяение Type!");
        this.type = type.strip();
        if(weight < 1 || weight > 5000) throw new IllegalArgumentException("Неверное знаяение Weight!");
        this.weight = weight;
        if(speed < 1 || speed > 150) throw new IllegalArgumentException("Неверное знаяение Speed!");
        this.speed = speed;
    }

    public void setWeight(int weight) {
        if(weight < 1 || weight > 5000) throw new IllegalArgumentException("Неверное знаяение Weight!");
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return "Animals{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", weight=" + weight +
                ", speed=" + speed +
                '}';
    }
}
