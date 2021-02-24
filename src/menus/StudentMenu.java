package menus;

import entities.Student;
import view.ValidateInput;

import java.time.LocalDate;

public class StudentMenu {
    private ValidateInput input = new ValidateInput();
    public Student menu1(Student student){
        String id = student.getId();
        System.out.print("Enter name:");
        String name = input.inputStr("[A-Z].+");
        System.out.print("Enter birth day:");
        LocalDate birthDay = input.inputDate();
        System.out.print("Enter course:");
        String course = input.inputStr("C[01]\\d{3}K\\d");

        return new Student(id,name,birthDay,course);
    }
}
