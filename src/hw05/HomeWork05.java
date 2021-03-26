package hw05;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWork05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Введите номер задачи (1-5) или 0 для выхода:");
            int userChoice = Integer.parseInt(in.nextLine());
            if (userChoice > 0) System.out.println("Выбрана задача №" + userChoice);
            if (userChoice == 0) break;
            switch (userChoice) {
                case 1:
//  Урок 5 Задача 1
                    System.out.println("Введите количество слов:");
                    int wordsCount = Integer.parseInt(in.nextLine());
                    if (wordsCount > 0 && wordsCount < Integer.MAX_VALUE - 8) {
                        String[] words = new String[wordsCount];
                        for (int i = 0; i < words.length; i++) {
                            System.out.println("Ваше слов (exit для завершения):");
                            words[i] = in.nextLine();
                            if ("exit".equalsIgnoreCase(words[i]) || "выход".equalsIgnoreCase(words[i])) {
                                words[i] = null;
                                break;
                            }
                            for (int j = 0; j < i; j++) {
                                if (words[j].equalsIgnoreCase(words[i])) {
                                    words[i] = null;
                                    --i;
                                    System.out.println("Вы повторяетесь!");
                                    break;
                                }
                            }
                        }
                        System.out.println(Arrays.toString(words));
                    } else {
                        System.out.println("Количество слов введено неверно!");
                    }
                    break;
                case 2:
//  Урок 5 Задача 2
                    System.out.println("Введите строку:");
                    String myString = in.nextLine();
                    System.out.println("Введите подстроку:");
                    String mySubString = in.nextLine();
                    if (myString.contains(mySubString)) {
                        String[] myArr = myString.split(mySubString);
                        int insertCount = myArr.length - 1;
                        System.out.println("Подстрока '" + mySubString + "' находится в строке '" + myString + "' " + insertCount + " раз.");
                    } else {
                        System.out.println("Подстрока '" + mySubString + "' в строке '" + myString + "' не найдена.");
                    }
                    break;
                case 3:
//  Урок 5 Задача 3
                    System.out.println("Введите строку:");
                    String palindrome = in.nextLine();
                    boolean isPalindrome = true;
                    char[] fromPalindrome = palindrome.replaceAll("\\s", "").toLowerCase().toCharArray();
                    for (int i = 0; i < fromPalindrome.length /2; i++) {
                        if (fromPalindrome[i] != fromPalindrome[fromPalindrome.length - i - 1]) {
                            isPalindrome = false;
                            break;
                        }
                    }
                    if (isPalindrome) {
                        System.out.println("Строка '" + palindrome + "' является полиндромом.");
                    } else {
                        System.out.println("Строка '" + palindrome + "' не является полиндромом.");
                    }
                    break;
                case 4:
//  Урок 5 Задача 4
                    System.out.println("Введите строку:");
                    String toUpper = in.nextLine();
                    String[] myWords = toUpper.strip().split(" ");
                    for (int i = 0; i < myWords.length; i++) {
                        myWords[i] = myWords[i].substring(0,1).toUpperCase() + myWords[i].substring(1).toLowerCase();
                    }
                    String result = String.join(" ",myWords);
                    System.out.println("Было: " + toUpper);
                    System.out.println("Стало: " + result);
                    break;
                case 5:
//  Урок 5 Задача 5
                    System.out.println("Введите слова через запятую:");
                    String allWords = in.nextLine();
                    System.out.println("Введите букву:");
                    String myLetter = in.nextLine();
                    if (myLetter.length() != 1) {
                        System.out.println("Это не буква!");
                        break;
                    }
                    String[] arrWords = allWords.split(",");
                    int myCount = 0;
                    for (int i = 0; i < arrWords.length; i++) {
                        if (arrWords[i].strip().substring(0,1).equals(myLetter)) {
                            myCount++;
                        }
                    }
                    System.out.println("Всего " + myCount + " слов с буквы " + myLetter);
                    break;
            }
        }
    }
}
