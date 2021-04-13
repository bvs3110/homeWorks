package com.ifmo.jjd.hw0701;

public class Director extends People{
    public Director(String name, int age) {
        super(name, age);
    }
    public boolean StartLessons(School school) {
        if (school == null || school.getDirector() != this) return false;
        school.setLessonsStart(true);
        return true;
    }

    public boolean StopLessons(School school) {
        if (school == null || school.getDirector() != this) return false;
        school.setLessonsStart(false);
        return true;
    }

    @Override
    public String toString() {
        return "Director{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
