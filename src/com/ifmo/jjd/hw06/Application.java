package com.ifmo.jjd.hw06;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Введите номер задачи (1-2) или 0 для выхода:");
            int userChoice = Integer.parseInt(in.nextLine());
            if (userChoice > 0) System.out.println("Выбрана задача №" + userChoice);
            if (userChoice == 0) break;
            switch (userChoice) {
                case 1:
                    System.out.println("Введите номер хранилища:");
                    int storageId = Integer.parseInt(in.nextLine());
                    Storage myStorage = new Storage(storageId);
                    while (true) {
                        System.out.println("Добавить новую книгу? (Д/Н)");
                        if (!"Д".equalsIgnoreCase(in.nextLine())) break;
                        System.out.println("Введите название книги:");
                        String title = in.nextLine();
                        System.out.println("Введите количество авторов");
                        int authorsCount = Integer.parseInt(in.nextLine());
                        if (authorsCount < 1) break;
                        Author[] authors = new Author[authorsCount];
                        for (int i = 1; i < authorsCount + 1; i++) {
                            System.out.println("Введите имя " + i + " -го автора:");
                            String name = in.nextLine().strip();
                            System.out.println("Введите фамилию " + i + " -го автора:");
                            String fullName = in.nextLine().strip();
                            authors[i - 1] = new Author(name, fullName);
                        }
                        System.out.println("Введите количество страниц:");
                        int numberOfPages = Integer.parseInt(in.nextLine());
                        System.out.println("Введите год издания:");
                        int yearOfPublishing = Integer.parseInt(in.nextLine());
                        Book myBook = new Book(title, authors, numberOfPages, yearOfPublishing);
                        System.out.println("Книга:");
                        System.out.println(myBook.toString());
                        if (myStorage.addBook(myBook)) {
                            System.out.println("Добавлена в хранилище");
                        } else {
                            System.out.println("Не добавлена в хранилище");
                        }
                        System.out.println(myStorage.toString());
                    }
                    break;
                case 2:
// К сожалению не успел доделать/проверить, сделал только классы и методы в этой задаче
                    break;
            }
        }
    }
}
