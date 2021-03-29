package com.ifmo.jjd.hw06;

public class Mouse {
    private int speed;

    public Mouse(int speed) {
        setSpeed(speed);
    }

    private void setSpeed(int speed) {
        if (speed < 0 || speed > 100) throw new IllegalArgumentException("Неверная скорость");
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return "Mouse{" +
                "speed=" + speed +
                '}';
    }
}
