package com.ifmo.jjd.рц0702;

public class Animals {
    private String name;
    private String type;
    private int weight;
    private int speed;

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
