package lab1;

import lab1.Author;
import lab1.Section;

import java.util.Objects;

class Book implements Comparable<lab2.Book> {
    private Section section;
    private String title;
    private lab2.Author author;
    private String dateOfPublishing;
    private double price;

    Book(Section section, String title, lab2.Author author, String dateOfPublishing, double price) {
        this.section = section;
        this.title = title;
        this.author = author;
        this.dateOfPublishing = dateOfPublishing;
        this.price = price;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getDateOfPublishing() {
        return dateOfPublishing;
    }

    public void setDateOfPublishing(String dateOfPublishing) {
        this.dateOfPublishing = dateOfPublishing;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Книга{" +
                "секция = " + section +
                ", название = '" + title + '\'' +
                ", автор = " + author +
                ", дата публикации = '" + dateOfPublishing + '\'' +
                ", цена = " + price +
                '}';
    }

    // переопредлили equals и hashCode, чтобы нельзя было добавить книги со всеми одинковыми параметрами
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        lab1.Book book = (lab1.Book) o;
        return Double.compare(book.price, price) == 0 &&
                section == book.section &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                Objects.equals(dateOfPublishing, book.dateOfPublishing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(section, title, author, dateOfPublishing, price);
    }

    //метод для сравнения в сортировке
    @Override
    public int compareTo(lab2.Book o) {
        return (int) (this.getPrice() - o.getPrice());
    }
}
