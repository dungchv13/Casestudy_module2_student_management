package entities;

import java.time.LocalDate;

public class Teacher extends Person{
    private String subjects;

    public Teacher() {
    }

    public Teacher(String id, String name, LocalDate birthDay, String subjects) {
        super(id, name, birthDay);
        this.subjects = subjects;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + super.getId() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", birthDay='" + super.getBirthDay() +'\'' +
                "subjects='" + subjects + '\'' +
                "} ";
    }
}
