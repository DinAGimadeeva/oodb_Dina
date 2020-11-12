package lab6.Entities;


import lab6.Annotations.Column;
import lab6.Annotations.Entity;
import lab6.Annotations.OneToMany;

import java.util.HashSet;
@Entity(name = "Library")
public class Library {
    @Column(name = "titleOfLibrary")
    private String titleOfLibrary;
    @Column(name = "books")
    @OneToMany(rightSide = Book.class)
    private HashSet<Book> books = new HashSet<>();


    Library(String title_of_library, HashSet<Book> books) {
        this.titleOfLibrary = title_of_library;
        this.books = books;
    }

    Library(String name) {
        this.titleOfLibrary = name;
    }

    void addBook(Book book) {
        books.add(book);
    }

    void removeBook(Book book) {
        books.remove(book);
    }

    public String getTitleOfLibrary() {
        return titleOfLibrary;
    }

    public void setTitleOfLibrary(String titleOfLibrary) {
        this.titleOfLibrary = titleOfLibrary;
    }

    HashSet<Book> getBooks() {
        return books;
    }

    public void setBooks(HashSet<Book> books) {
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
