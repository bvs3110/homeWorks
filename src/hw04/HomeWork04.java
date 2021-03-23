package hw04;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWork04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Введите номер задачи (1-5) или 0 для выхода:");
            int userChoice = in.nextInt();
            if (userChoice > 0) System.out.println("Выбрана задача №" + userChoice);
            if (userChoice == 0) break;
            switch (userChoice) {
                case 1:
//  Урок 4 Задача 1
                    int[] myArray = new int[20];
                    int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, mini = 0, maxi = 0, tmp;
                    for (int i = 0; i < myArray.length; i++) {
                        myArray[i] = (int) (Math.random() * 497 + 3);
                        if (myArray[i] >= max) {
                            max = myArray[i];
                            maxi = i;
                        }
                        if (myArray[i] <= min) {
                            min = myArray[i];
                            mini = i;
                        }
                    }
                    System.out.println("До изменения " + Arrays.toString(myArray));
                    tmp = myArray[maxi];
                    myArray[maxi] = myArray[mini];
                    myArray[mini] = tmp;
                    System.out.println("После изменения " + Arrays.toString(myArray));
                    break;
                case 2:
//  Урок 4 Задача 2
                    int[] srcArray = {78, 32, 76, 100, 0, 6301, 331, 77, 24, 2, 90};
                    Arrays.sort(srcArray);
//                  Захотелось заранее узнать размеры массивов, можно было определить с запасом 11
                    int oddNum = 0, evenNum = 0;
                    for (int element : srcArray) {
                        if (element % 2 == 0) {
                            ++evenNum;
                        } else {
                            ++oddNum;
                        }
                    }
                    int[] oddArray = new int[oddNum], evenArray = new int[evenNum];
                    oddNum = 0;
                    evenNum = 0;
                    for (int element : srcArray) {
                        if (element % 2 == 0) {
                            evenArray[evenNum] = element;
                            ++evenNum;
                        } else {
                            oddArray[oddNum] = element;
                            ++oddNum;
                        }
                    }
                    System.out.println("Исходный массив " + Arrays.toString(srcArray));
                    System.out.println("Четный массив " + Arrays.toString(evenArray));
                    System.out.println("Нечетный массив " + Arrays.toString(oddArray));
                    break;
                case 3:
//  Урок 4 Задача 3
                    int[] srcArray3 = {-321, 894, -45, 782, -29, 12, -88};
                    int minus = 0;
                    for (int element : srcArray3) {
                        if (element < 0) {
                            ++minus;
                        }
                    }
                    int[] minusArray = new int[minus];
                    minus = 0;
                    for (int element : srcArray3) {
                        if (element < 0) {
                            minusArray[minus] = element;
                            ++minus;
                        }
                    }
                    System.out.println("Исходный массив " + Arrays.toString(srcArray3));
                    System.out.println("Отрицательный массив " + Arrays.toString(minusArray));
                    break;
                case 4:
//  Урок 4 Задача 4
                    int[] evenArray4 = new int[10];
                    for (int i = 0; i < evenArray4.length; i++) {
                        evenArray4[i] = i * 2 + 2;
                    }
                    System.out.println("Исходный массив " + Arrays.toString(evenArray4));
                    for (int i = evenArray4.length - 1; i >= 0 ; i--) {
                        System.out.println("Элемент массива с номером " + i + " равен " + evenArray4[i]);
                    }
                    break;
                case 5:
//  Урок 4 Задача 5                    
                    int[] randomArray = new int[11], countArray = new int[3];
                    int maxElement = 0, maxIndex = 0;
                    for (int i = 0; i < randomArray.length; i++) {
                        randomArray[i] = (int) (Math.random() * 4 - 2);
                    }
                    System.out.println("Исходный массив " + Arrays.toString(randomArray));
                    for (int element : randomArray) {
                        switch (element) {
                            case -1:
                                ++countArray[0];
                                break;
                            case 0:
                                ++countArray[1];
                                break;
                            case 1:
                                ++countArray[2];
                                break;
                        }
                    }
                    for (int i = 0; i < countArray.length; i++) {
                        if (countArray[i] > maxElement) {
                            maxElement = countArray[i];
                            maxIndex = i;
                        }
                    }
                    --maxIndex;
                    System.out.println("В данном массиве чаще встречается значение " + maxIndex + " (" + maxElement + " раз).");
                    break;
            }
        }
    }
}
