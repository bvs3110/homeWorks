package com.ifmo.jjd.hw06;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Objects;

public class Book {
    private String title;
    private Author[] authors;
    private int numberOfPages;
    private int yearOfPublishing;

    public Book(String title, Author[] authors, int numberOfPages, int yearOfPublishing) {
        setTitle(title);
        setAuthors(authors);
        setNumberOfPages(numberOfPages);
        setYearOfPublishing(yearOfPublishing);
    }

    private void setTitle(String title) {
        if (title == null || title.trim().length() < 3) throw new IllegalArgumentException("Длинна названия менее 3, либо название нулевое");
        this.title = title;
    }

    public void setAuthors(Author[] authors) {
        Objects.requireNonNull(authors, "authors не может быть null");
        if (authors.length < 1) throw new IllegalArgumentException("Количество авторов неверно");
        this.authors = authors;
    }

    private void setNumberOfPages(int numberOfPages) {
        if (numberOfPages < 5) throw new IllegalArgumentException("Количество страниц менее 5");
        this.numberOfPages = numberOfPages;
    }

    private void setYearOfPublishing(int yearOfPublishing) {
        if (yearOfPublishing < 1300 || yearOfPublishing > Calendar.getInstance().get(Calendar.YEAR)) throw new IllegalArgumentException("Неправильный год издания книги");
        this.yearOfPublishing = yearOfPublishing;
    }

    public String getTitle() {
        return title;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authors=" + Arrays.toString(authors) +
                ", numberOfPages=" + numberOfPages +
                ", yearOfPublishing=" + yearOfPublishing +
                '}';
    }
}
