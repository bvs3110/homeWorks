package com.ifmo.jjd.hw0702;

public class Farmer {
    private String name;
    private int resource = 5;

    public String getName() {
        return name;
    }

    public int getResource() {
        return resource;
    }

    @Override
    public String toString() {
        return "Farmer{" +
                "name='" + name + '\'' +
                ", resource=" + resource +
                '}';
    }
}
