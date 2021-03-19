package hw02;

import java.util.Scanner;

public class HomeWork02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Введите номер задачи или 0 для выхода:");
            int userChoice = in.nextInt();
            System.out.println(userChoice);
            if (userChoice == 0) break;
            switch (userChoice) {
                case 1:
//  Задача 1: оператор if
                    System.out.println("Введите количество верных ответов:");
                    int count = in.nextInt();
                    if (count > 0 && count <= 100) {
                        if (count <= 39) {
                            System.out.println("Попробуйте в следующий раз.");
                        } else if (count <= 59) {
                            System.out.println("Удовлетворительно.");
                        } else if (count <= 89) {
                            System.out.println("Хорошо.");
                        } else {
                            System.out.println("Отлично!");
                        }
                    } else {
                        System.out.println("Количество верный ответов должно быть от 0 до 100!");
                    }
                    break;
                case 2:
//  Задача 2: оператор switch
                    System.out.println("Введите первый операнд:");
                    double oa = in.nextDouble();
                    System.out.println("Введите второй операнд:");
                    double ob = in.nextDouble();
                    System.out.println("Введите оператор:");
                    int oc = in.nextInt();
                    switch (oc) {
                        case 3:
                            System.out.println(oa + ob);
                            break;
                        case 5:
                            System.out.println(oa - ob);
                            break;
                        case 7:
                            System.out.println(oa * ob);
                            break;
                        case 9:
                            System.out.println(oa / ob);
                            break;
                        default:
                            System.out.println("Указан неверный оператор");
                    }
                    break;
                case 3:
//  Задача 3: while
                    System.out.println("Введите количество тарелок:");
                    int plate = in.nextInt();
                    System.out.println("Введите количество моющего средства:");
                    double tablet = in.nextDouble();
                    if (plate <= 0) {
                        System.out.println("Мало тарелок!");
                        break;
                    }
                    if (tablet <= 0) {
                        System.out.println("Мало моющего средства!");
                        break;
                    }
                    int plateTotal = plate, tmp;
                    while (plate != 0 && tablet >= 0.5) {
                        --plate;
                        tablet -= 0.5;
                        tmp = plateTotal - plate;
                        System.out.println("Вымыто " + tmp + " тарелок, осталось " + tablet + " моющего средства.");
                    }
                    if (plate > 0) {
                        System.out.println("Моющего средства не хватило, осталось " + plate + " тарелок.");
                    } else {
                        System.out.println("Все тарелки вымыты, осталось " + tablet + " моющего средства.");
                    }
                    break;
                case 4:
//  Задача 4: Угадайте наше число
                    int number = (int) (Math.random() * 10), userNumber;
                    if (number == 0) ++number;
                    do {
                        System.out.println("Мы загадали число, введите Ваше:");
                        userNumber = in.nextInt();
                        if (userNumber == 0) {
                            break;
                        } else if (userNumber > number) {
                            System.out.println("Загаданное число меньше!");
                        } else if (userNumber < number) {
                            System.out.println("Загаданное число больше!");
                        } else {
                            System.out.println("Вы угадали!");
                        }
                    } while (userNumber != number);
                    break;
                case 5:
//  Задача 5: Math.random()
                    int random = (int) (Math.random() * 490 + 10);
                    if (random > 25 && random < 200) {
                        System.out.println("Чило " + random + " попадает в интервал [25;200]");
                    } else {
                        System.out.println("Чило " + random + " не попадает в интервал [25;200]");
                    }
                    break;
                case 6:
//  Задача 6: Угадаем Ваше число
                    System.out.println("Загадайте число от 1 до 100");
                    int point = 50, half = 25, say;
                    while (half > 0) {
                        System.out.println("Вы загадали число " + point + " ? 0 - нет, 1 - да");
                        say = in.nextInt();
                        if (say == 1) {
                            System.out.println("Мы угадали!");
                            break;
                        }
                        System.out.println("Ваше число больше чем " + point + " ? 0 - нет, 1 - да");
                        say = in.nextInt();
                        if (say == 1) {
                            point += half;
                        } else {
                            point -= half;
                        }
                        half /= 2;
                        half++;
                    }
                    break;

            }
        }
    }
}
