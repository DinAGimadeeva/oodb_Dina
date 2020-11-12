package lab6.Entities;

import lab6.Annotations.Column;
import lab6.Annotations.Entity;

@Entity(name = "Author")
class Author extends Person {
    @Column(name = "info")
    private String info;

    Author(String name, String patronymic, String lastName, String info) {
        super(name, patronymic, lastName);
        this.info = info;
    }


    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Автор {" +
                "ФИО ='" + lastName + " " + name + " " + patronymic +
                ", информация ='" + info + '\'' + '}';

    }}



