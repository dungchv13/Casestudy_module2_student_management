package menus;

import entities.Student;
import entities.Teacher;
import fileProcess.FileTextProcess;
import fuctions.StudentManage;
import view.ValidateInput;

import java.time.LocalDate;
import java.util.ArrayList;

public class TeacherMenu {
    private ValidateInput input = new ValidateInput();
    public Teacher menu1(Teacher teacher){
        String id = teacher.getId();
        System.out.print("Enter name:");
        String name = input.inputStr("[A-Z].+");
        System.out.print("Enter birth day:");
        LocalDate birthDay = input.inputDate();
        System.out.print("Enter subjects:");
        String subjects = input.inputStr("C[01]\\d{3}K\\d");

        return new Teacher(id,name,birthDay,subjects);
    }
    public void menu7(StudentManage studentManage){
        System.out.println("X mean pass module,O mean not pass module");
        ArrayList<String> transcript = new ArrayList<>();
        transcript.add("X mean pass module,O mean not pass module");
        for (Student stu:studentManage.getStudentList()) {
            System.out.print(stu.toString()+": ");
            String xo = input.inputStr("[XO]");
            transcript.add(stu.toString()+": "+xo);
        }
        FileTextProcess.writeFile(transcript,"E:\\module2\\case_Study_module2_QuanLyHocSinh\\FileText\\Transcript");
    }
}
