package com.ifmo.jjd.hw0701;

abstract public class People {
    protected String name;
    protected int age;

    public People(String name, int age) {
        if (name == null || name.strip().length() < 2) throw new IllegalArgumentException("Слишком короткое имя!");
        if (age < 0 || age > 130) throw new IllegalArgumentException("Возраст уазан неверно!");
        this.name = name.strip();
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
