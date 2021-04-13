package com.ifmo.jjd.exam01;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        //Немного данных для примера
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
        Subscription mySubs3 = new Subscription("Сидор", "Сидоров", LocalDate.parse("2002-01-01"), LocalDate.parse("2021-10-10"), LocalTime.parse("00:00:00"),  LocalTime.parse("23:59:59"), 3);
        mySubs3.addFitnessZone(myZone1);
        mySubs3.addFitnessZone(myZone2);
        mySubs3.addFitnessZone(myZone3);
        myFitness.addSubscription(mySubs1);
        myFitness.addSubscription(mySubs2);
        myFitness.addSubscription(mySubs3);

        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("1 - Начать работу фитнеса");
            System.out.println("2 - Добавить новый абонемент");
            System.out.println("3 - Начать занятие по абонементу");
            System.out.println("4 - Закончить занятие по абонементу");
            System.out.println("5 - Вывести информацию о текущих посетителях");
            System.out.println("8 - Вывести информацию о зарегистрированных посетителях");
            System.out.println("9 - Завершить работу фитнеса");
            System.out.println("0 - выход");
            int userChoice = Integer.parseInt(in.nextLine());
            if (userChoice == 0) break;
            switch (userChoice) {
                case 1:
                    //Начать работу фитнеса
                    myFitness.openFitness();
                    break;

                case 2:
                    //Добавить новый абонемент
                    System.out.println("Введите имя:");
                    String myFirstName = in.nextLine().strip();
                    System.out.println("Введите фамилию:");
                    String myLastName = in.nextLine().strip();
                    System.out.println("Введите Год рождения ГГГГ-ММ-ДД:");
                    String myBirthDate = in.nextLine().strip();
                    System.out.println("Введите дату окончания ГГГГ-ММ-ДД:");
                    String myEndDate = in.nextLine().strip();
                    System.out.println("Введите время начала занятий ЧЧ:ММ:СС:");
                    String myStartTime = in.nextLine().strip();
                    System.out.println("Введите время окончания занятий ЧЧ:ММ:СС:");
                    String myEndTime = in.nextLine().strip();
                    System.out.println("Введите кол-во доступных зон:");
                    int myZoneCount = Integer.parseInt(in.nextLine());
                    Subscription mySubsN = new Subscription(myFirstName, myLastName, LocalDate.parse(myBirthDate), LocalDate.parse(myEndDate), LocalTime.parse(myStartTime), LocalTime.parse(myEndTime), myZoneCount);
                    for (int j = 0; j < mySubsN.getFitnessZones().length; j++) {
                        System.out.println("Выберите " + j + " зону:");
                        for (int i = 0; i < myFitness.getFitnessZones().length; i++) {
                            if (myFitness.getFitnessZones()[i] != null) System.out.println(i + " " + myFitness.getFitnessZones()[i].getFitnessZoneName());
                        }
                        int myZoneNum = Integer.parseInt(in.nextLine());
                        mySubsN.addFitnessZone(myFitness.getFitnessZones()[myZoneNum]);
                    }
                    myFitness.addSubscription(mySubsN);
                    break;

                case 3:
                    //Начать занятие по абонементу
                    for (int i = 0; i < myFitness.getSubscriptions().length; i++) {
                        if (myFitness.getSubscriptions()[i] != null) System.out.println(i + " " + myFitness.getSubscriptions()[i].getFirstName() + " " + myFitness.getSubscriptions()[i].getLastName());
                    }
                    System.out.println("Выберите абонемент: ");
                    int mySubs = Integer.parseInt(in.nextLine());
                    for (int i = 0; i < myFitness.getFitnessZones().length; i++) {
                        if (myFitness.getFitnessZones() != null) System.out.println(i + " " + myFitness.getFitnessZones()[i].getFitnessZoneName());
                    }
                    System.out.println("Выберите зону: ");
                    int myZone = Integer.parseInt(in.nextLine());
                    System.out.println(myFitness.getSubscriptions()[mySubs].startTraining(myFitness, myFitness.getFitnessZones()[myZone]));
                    break;

                case 4:
                    //Закончить занятие по абонементу
                    for (int i = 0; i < myFitness.getSubscriptions().length; i++) {
                        if (myFitness.getSubscriptions()[i] != null) System.out.println(i + " " + myFitness.getSubscriptions()[i].getFirstName() + " " + myFitness.getSubscriptions()[i].getLastName());
                    }
                    System.out.println("Выберите абонемент: ");
                    int mySubsEnd = Integer.parseInt(in.nextLine());
                    for (int i = 0; i < myFitness.getFitnessZones().length; i++) {
                        if (myFitness.getFitnessZones() != null) System.out.println(i + " " + myFitness.getFitnessZones()[i].getFitnessZoneName());
                    }
                    System.out.println("Выберите зону: ");
                    int myZoneEnd = Integer.parseInt(in.nextLine());
                    myFitness.getSubscriptions()[mySubsEnd].stopTraining(myFitness, myFitness.getFitnessZones()[myZoneEnd]);
                    break;

                case 5:
                    //Вывести информацию о текущих посетителях
                    for (FitnessZone fitnessZone : myFitness.getFitnessZones()) {
                        for (Subscription subscription : fitnessZone.getSubscriptions()) {
                            if(subscription != null) System.out.println(myFitness.getFitnessName() + " " + fitnessZone.getFitnessZoneName() + " " + subscription.toString());
                        }
                    }
                    break;

                case 8:
                    //Вывести информацию о зарегистрированных посетителях
                    for (Subscription subscription : myFitness.getSubscriptions()) {
                        if(subscription != null) System.out.println(subscription.toString());
                    }
                    break;

                case 9:
                    //Завершить работу фитнеса
                    myFitness.closeFitness();
                    break;

            }
        }
    }
}
