package lab7.Entities;

import lab6.Annotations.Column;
import lab6.Annotations.Entity;

@Entity(name = "Person")
class Person {
    @Column(name = "name")
    String name;
    @Column(name = "patronymic")
    String patronymic;
    @Column(name = "lastName")
    String lastName;


    Person(String name, String patronymic, String lastName) {
        this.name = name;
        this.patronymic = patronymic;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
