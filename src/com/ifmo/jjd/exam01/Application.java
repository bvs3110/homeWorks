package com.ifmo.jjd.exam01;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Aplication {
    public static void main(String[] args) {
        Fitness myFitness = new Fitness("Наш Фитнес", 3, 100);
        FitnessZone myZone1 = new FitnessZone("Бассейн");
        FitnessZone myZone2 = new FitnessZone("Тренажерный зал");
        FitnessZone myZone3 = new FitnessZone("Групповые занятия");
        myFitness.addZone(myZone1);
        myFitness.addZone(myZone2);
        myFitness.addZone(myZone3);
        Subscription mySubs1 = new Subscription("Иван", "Иванов", LocalDate.parse("2000-01-01"), LocalDate.parse("2021-12-12"), LocalTime.parse("08:00:00"),  LocalTime.parse("22:00:00"), 2);
        mySubs1.addFitnessZone(myZone1);
        mySubs1.addFitnessZone(myZone2);
        Subscription mySubs2 = new Subscription("Петр", "Петров", LocalDate.parse("2001-01-01"), LocalDate.parse("2021-11-11"), LocalTime.parse("08:00:00"),  LocalTime.parse("16:00:00"), 2);
        mySubs2.addFitnessZone(myZone2);
        mySubs2.addFitnessZone(myZone3);
        Subscription mySubs3 = new Subscription("Сидор", "Сидоров", LocalDate.parse("2002-01-01"), LocalDate.parse("2021-10-10"), LocalTime.parse("08:00:00"),  LocalTime.parse("16:00:00"), 2);
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("1 - Начать работу фитнеса");
            System.out.println("2 - Добавить новый абонемент");
            System.out.println("3 - Начать занятие по абонементу");
            System.out.println("4 - Закончить занятие по абонементу");
            System.out.println("5 - Вывести информацию о текущих посетителей");
            System.out.println("9 - Завершить работу фитнеса");
            System.out.println("Или 0 для выхода:");
            int userChoice = Integer.parseInt(in.nextLine());
            if (userChoice > 0) System.out.println("Выбрана задача №" + userChoice);
            if (userChoice == 0) break;
            switch (userChoice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        }
    }
}
