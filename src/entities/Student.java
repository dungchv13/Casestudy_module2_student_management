package entities;

import java.time.LocalDate;

public class Student extends Person {
    private String courseName;

    public Student() {
    }

    public Student(String id, String name, LocalDate birthDay, String courseName) {
        super(id, name, birthDay);
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + super.getId() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", birthDay='" + super.getBirthDay() +'\'' +
                ", courseName='" + courseName + '\'' +
                "} ";
    }
}
