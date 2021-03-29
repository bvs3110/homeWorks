package com.ifmo.jjd.hw06;

import java.util.Arrays;
import java.util.Objects;

public class Storage {
    private int storageId;
    private Book[] books;

    public Storage(int storageId) {
        this.storageId = storageId;
        books = new Book[20];
    }

    public boolean addBook(Book book) {
        Objects.requireNonNull(book, "book не может быть null");
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                for (int j = 0; j < books.length; j++) {
                    if (books[j] != null && books[j].getTitle().equals(book.getTitle())) {
                        return false;
                    }
                }
                books[i] = book;
                return true;
            }
        }
        return false;
    }

    public int getStorageId() {
        return storageId;
    }

    public Book[] getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "storageId=" + storageId +
                ", books=" + Arrays.toString(books) +
                '}';
    }
}
