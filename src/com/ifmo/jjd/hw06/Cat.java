package com.ifmo.jjd.hw06;

import java.util.Arrays;
import java.util.Objects;

public class Cat {
    private String name;
    private String color;
    private double weight;
    private int speed;
    private Mouse[] capturedMouse;

    public Cat(String name, String color, double weight, int speed, Mouse[] capturedMouse) {
        setName(name);
        setColor(color);
        setWeight(weight);
        setSpeed(speed);
        setCapturedMouse(capturedMouse);
    }

    public boolean captureMouse(Mouse mouse) {
        Objects.requireNonNull(mouse, "mouse не может быть null");
        if (mouse.getSpeed() > this.getSpeed()) return false;
        for (int i = 0; i < this.capturedMouse.length; i++) {
            if (this.capturedMouse[i] == null) {
                this.capturedMouse[i] = mouse;
                return true;
            }
        }
        return false;
    }

    public void clearCapturedMouse() {
        Arrays.fill(this.capturedMouse, null);
    }

    public void attackOnCat(Cat cat) {
        Objects.requireNonNull(cat, "cat не может быть null");
        if (this.getWeight() > cat.getWeight()) {
            for (int i = 0; i < cat.capturedMouse.length; i++) {
                if (cat.capturedMouse[i] != null) {
                    for (int j = 0; j < this.capturedMouse.length; j++) {
                        if (this.capturedMouse[j] == null) {
                            if (cat.capturedMouse[i].getSpeed() < this.speed) {
                                this.capturedMouse[j] = cat.capturedMouse[i];
                            }
                        }
                    }
                }
            }
            clearCapturedMouse();
        }
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().length() < 2) throw new IllegalArgumentException("Длинна имени менее 2, либо име нулевое");
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    private void setColor(String color) {
        if (color == null || color.trim().length() < 2) throw new IllegalArgumentException("Неверный цвет");
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    private void setWeight(double weight) {
        if (weight < 0.5 || weight > 40) throw new IllegalArgumentException("Вес кота неверен");
        this.weight = weight;
    }

    public int getSpeed() {
        return speed;
    }

    private void setSpeed(int speed) {
        if (speed < 0 || speed > 100) throw new IllegalArgumentException("Неверная скорость");
        this.speed = speed;
    }

    public Mouse[] getCapturedMouse() {
        return capturedMouse;
    }

    private void setCapturedMouse(Mouse[] capturedMouse) {
        Objects.requireNonNull(capturedMouse, "capturedMouse не может быть null");
        if (capturedMouse.length != 100)  throw new IllegalArgumentException("Неверный массив пойманных мышей");
        this.capturedMouse = capturedMouse;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                ", speed=" + speed +
                ", capturedMouse=" + Arrays.toString(capturedMouse) +
                '}';
    }
}
