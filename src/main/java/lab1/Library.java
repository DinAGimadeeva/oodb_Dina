package lab1;


import lab1.Book;

import java.util.HashSet;

public class Library {
    private String titleOfLibrary;
    private HashSet<lab2.Book> books = new HashSet<>();


    Library(String title_of_library, HashSet<lab2.Book> books) {
        this.titleOfLibrary = title_of_library;
        this.books = books;
    }

    Library(String name) {
        this.titleOfLibrary = name;
    }

    void addBook(lab2.Book book) {
        books.add(book);
    }

    void removeBook(lab2.Book book) {
        books.remove(book);
    }

    public String getTitleOfLibrary() {
        return titleOfLibrary;
    }

    public void setTitleOfLibrary(String titleOfLibrary) {
        this.titleOfLibrary = titleOfLibrary;
    }

    HashSet<lab2.Book> getBooks() {
        return books;
    }

    public void setBooks(HashSet<lab2.Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Библиотека {" +
                "навзание = '" + titleOfLibrary + '\'' +
                ", список книг = " + books +
                '}';
    }
}
