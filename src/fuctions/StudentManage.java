package fuctions;

import entities.Student;
import fileProcess.FileProcess;
import fileProcess.FileTextProcess;

import java.util.ArrayList;

public class StudentManage {
    private final String STUDENT_BINARY_PATH = "DisplayOnFile/StudentList";
    private final String STUDENT_TEXT_PATH = "FileText/StudentList";
    private ArrayList<Student> studentList;

    public void addStudent(Student stu){
        studentList = (ArrayList<Student>) FileProcess.readFile(STUDENT_BINARY_PATH);
        if(studentList == null){
            studentList = new ArrayList<>();
        }
        studentList.add(stu);
        FileTextProcess.writeFile(makeStringList(studentList),STUDENT_TEXT_PATH);
        FileProcess.writeFile(studentList, STUDENT_BINARY_PATH);
    }

    public void updateStudent(Student stu){
        studentList = (ArrayList<Student>) FileProcess.readFile(STUDENT_BINARY_PATH);
        int index = 0;
        for (Student s: studentList) {
            if(s.getId().equals(stu.getId())){
                index = studentList.indexOf(s);
            }
        }
        studentList.remove(index);
        studentList.add(index,stu);
        FileTextProcess.writeFile(makeStringList(studentList),STUDENT_TEXT_PATH);
        FileProcess.writeFile(studentList, STUDENT_BINARY_PATH);
    }

    public void displayAllStudent(){
        studentList = (ArrayList<Student>) FileProcess.readFile(STUDENT_BINARY_PATH);
        for (Student s: studentList) {
            System.out.println(s.toString());
        }
    }
    public void displayStudentById(String id){
        Student stu = searchStudent(id);
        System.out.println(stu.toString());
    }

    public void removeStudent(String id){
        studentList = (ArrayList<Student>) FileProcess.readFile(STUDENT_BINARY_PATH);
        int index = 0;
        for (Student s: studentList) {
            if(s.getId().equals(id)){
                index = studentList.indexOf(s);
            }
        }
        studentList.remove(index);
        FileTextProcess.writeFile(makeStringList(studentList),STUDENT_TEXT_PATH);
        FileProcess.writeFile(studentList, STUDENT_BINARY_PATH);
    }

    public Student searchStudent(String id){
        studentList = (ArrayList<Student>) FileProcess.readFile(STUDENT_BINARY_PATH);
        for (Student s: studentList) {
            if(s.getId().equals(id)){
                return s;
            }
        }
        return null;
    }

    public boolean isContainStudent(String id){
        studentList = (ArrayList<Student>) FileProcess.readFile(STUDENT_BINARY_PATH);
        if(studentList == null){
            return false;
        }
        for (Student s: studentList) {
            if(s.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    private ArrayList<String> makeStringList(ArrayList<Student> list){
        ArrayList<String> result = new ArrayList<>();
        for (Student stu:list) {
            result.add(stu.toString());
        }
        return result;
    }

    public ArrayList<Student> getStudentList() {
        studentList = (ArrayList<Student>) FileProcess.readFile(STUDENT_BINARY_PATH);
        return studentList;
    }
}
