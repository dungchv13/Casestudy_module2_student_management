package menus;

import entities.Student;
import entities.Teacher;
import view.ValidateInput;

import java.time.LocalDate;

public class ManagerMenu {
    private ValidateInput input = new ValidateInput();
    public Student menu1(){
        System.out.print("Enter student id:");
        String id = input.inputIdForAdd();
        System.out.print("Enter student name:");
        String name = input.inputStr("[A-Z].+");
        System.out.print("Enter student birth day:");
        LocalDate birthDay = input.inputDate();
        System.out.print("Enter student course:");
        String course = input.inputStr("C[01]\\d{3}K\\d");

        return new Student(id,name,birthDay,course);
    }
    public String menu2(){
        System.out.print("Enter student id:");
        return input.inputIdForSearch();
    }
    public Teacher menu3(){
        System.out.print("Enter teacher id:");
        String id = input.inputIdForAdd();
        System.out.print("Enter teacher name:");
        String name = input.inputStr("[A-Z].+");
        System.out.print("Enter teacher birth day:");
        LocalDate birthDay = input.inputDate();
        System.out.print("Enter teacher subjects:");
        String subjects = input.inputStr(".+");

        return new Teacher(id,name,birthDay,subjects);
    }

    public String menu4(){
        System.out.print("Enter teacher id:");
        return input.inputIdForSearch();
    }
    public String menu5(){
        System.out.print("Enter id:");
        return input.inputIdForSearch();
    }



}
