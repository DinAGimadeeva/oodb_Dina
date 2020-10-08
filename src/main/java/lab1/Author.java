package lab1;

import lab1.Person;

import java.util.Objects;

class Author extends lab1.Person {
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



