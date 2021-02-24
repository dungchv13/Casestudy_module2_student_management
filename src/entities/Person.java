package entities;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Person implements Serializable {
    private String id;
    private String name;
    private LocalDate birthDay;


    public Person() {
    }

    public Person(String id, String name, LocalDate birthDay) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }



    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthDay=" + birthDay +
                '}';
    }
}
