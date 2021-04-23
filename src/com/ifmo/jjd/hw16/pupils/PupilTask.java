package com.ifmo.jjd.hw16.pupils;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PupilTask {
    public static void main(String[] args) {

        // Используя Stream API:

        Pupil pupil1 = new Pupil("Вася", Pupil.Gender.MALE, LocalDate.parse("2010-08-04"));
        Pupil pupil2 = new Pupil("Петя", Pupil.Gender.MALE, LocalDate.parse("2011-09-05"));
        Pupil pupil3 = new Pupil("Вова", Pupil.Gender.MALE, LocalDate.parse("2012-07-06"));
        Pupil pupil4 = new Pupil("Маша", Pupil.Gender.FEMALE, LocalDate.parse("2010-06-07"));
        Pupil pupil5 = new Pupil("Глаша", Pupil.Gender.FEMALE, LocalDate.parse("2011-05-08"));
        Pupil pupil6 = new Pupil("Саша", Pupil.Gender.FEMALE, LocalDate.parse("2012-04-09"));

        // 1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Pupil.Gender, ArrayList<Pupil>>

        Map<Pupil.Gender, ArrayList<Pupil>> resMap = Stream.of(pupil1, pupil2, pupil3, pupil4, pupil5, pupil6)
                .collect(Collectors.groupingBy(pupil -> pupil.getGender(), Collectors.toCollection(ArrayList::new)));
        System.out.println(resMap);

        // 2. Найти средний возраст учеников

        Double averageAge = Stream.of(pupil1, pupil2, pupil3, pupil4, pupil5, pupil6)
                .mapToInt(pupil -> Period.between(pupil.getBirth(), LocalDate.now()).getYears())
                .average().getAsDouble();
        System.out.println(averageAge);

        // 3. Найти самого младшего ученика

        Pupil minAge = Stream.of(pupil1, pupil2, pupil3, pupil4, pupil5, pupil6)
                .max(Comparator.comparing(Pupil::getBirth)).get();
        System.out.println(minAge);

        // 4. Найти самого взрослого ученика

        Pupil maxAge = Stream.of(pupil1, pupil2, pupil3, pupil4, pupil5, pupil6)
                .min(Comparator.comparing(Pupil::getBirth)).get();
        System.out.println(maxAge);

        // 5. Собрать учеников в группы по году рождения

        Map<Integer, ArrayList<Pupil>> yearMap = Stream.of(pupil1, pupil2, pupil3, pupil4, pupil5, pupil6)
                .collect(Collectors.groupingBy(pupil -> pupil.getBirth().getYear(), Collectors.toCollection(ArrayList::new)));
        System.out.println(yearMap);

        // 6. Оставить учеников с неповторяющимися именами,
        // имена и дату рождения оставшихся вывести в консоль.
        // Например, [Иван, Александра, Ольга, Иван, Ольга] -> [Иван, Александра, Ольга]

        Map<String, LocalDate> originalMap = Stream.of(pupil1, pupil2, pupil3, pupil4, pupil5, pupil6)
                .collect(Collectors.toMap(pupil -> pupil.getName(), pupil -> pupil.getBirth(), (item1, item2) -> item1));
        System.out.println(originalMap);

        // 7. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке), собрать в список (List)

        List<Pupil> sortedList = Stream.of(pupil1, pupil2, pupil3, pupil4, pupil5, pupil6)
                .sorted(Comparator.comparing(Pupil::getGender)
                        .thenComparing(Comparator.comparing(Pupil::getBirth)
                                .thenComparing(Comparator.comparing(Pupil::getName, Comparator.reverseOrder())
                                )))
                .collect(Collectors.toList());
        System.out.println(sortedList);

        // 8. Вывести в консоль всех учеников в возрасте от N до M лет

        List<Pupil> ageGateList = Stream.of(pupil1, pupil2, pupil3, pupil4, pupil5, pupil6)
                .filter(pupil -> Period.between(pupil.getBirth(), LocalDate.now()).getYears() < 12 && Period.between(pupil.getBirth(), LocalDate.now()).getYears() > 8)
                .collect(Collectors.toList());
        System.out.println(ageGateList);

        // 9. Собрать в список всех учеников с именем=someName

        List<Pupil> nameList = Stream.of(pupil1, pupil2, pupil3, pupil4, pupil5, pupil6)
                .filter(pupil -> pupil.getName().equals("Вася"))
                .collect(Collectors.toList());
        System.out.println(nameList);

        // 10. Собрать Map<Pupil.Gender, Integer>, где Pupil.Gender - пол, Integer - суммарный возраст учеников данного пола

        
    }
}
