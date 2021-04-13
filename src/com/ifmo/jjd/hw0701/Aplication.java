package com.ifmo.jjd.hw0701;

import java.util.Arrays;

public class Aplication {
    public static void main(String[] args) {

        Schoolchild[] schoolchilds = new Schoolchild[3];
        schoolchilds[0] = new Schoolchild("Вася", 12, "Математика", 5);
        schoolchilds[1] = new Schoolchild("Вова", 11, "Физика", 4);
        schoolchilds[2] = new Schoolchild("Петя", 10, "Химия", 3);

        Teacher[] teachers = new Teacher[3];
        teachers[0] = new Teacher("Мария Петровна", 35, "Химия", 1);
        teachers[1] = new Teacher("Вера Ивановна", 29, "Физика", 2);
        teachers[2] = new Teacher("Зоя Викеньтьевна", 43, "Литература", 5);

        Director director = new Director("Тамара Георгиевна", 51);

        School school = new School("Школа №1", director, teachers, schoolchilds);
        System.out.println(school);
        System.out.println(Arrays.toString(schoolchilds));
        school.schoolDay();
        System.out.println(Arrays.toString(schoolchilds));

    }
}
