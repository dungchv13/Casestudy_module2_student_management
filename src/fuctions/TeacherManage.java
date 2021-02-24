package fuctions;


import entities.Teacher;
import fileProcess.FileProcess;
import fileProcess.FileTextProcess;

import java.util.ArrayList;

public class TeacherManage {
    private final String TEACHER_PATH = "DisplayOnFile/TeacherList";
    private final String TEACHER_TEXT_PATH = "FileText/TeacherList";
    private ArrayList<Teacher> teacherList;

    public void addTeacher(Teacher teacher){
        teacherList = (ArrayList<Teacher>) FileProcess.readFile(TEACHER_PATH);
        if(teacherList == null){
            teacherList = new ArrayList<>();
        }
        teacherList.add(teacher);
        FileTextProcess.writeFile(makeStringList(teacherList), TEACHER_TEXT_PATH);
        FileProcess.writeFile(teacherList,TEACHER_PATH);
    }

    public void updateTeacher(Teacher teacher){
        teacherList = (ArrayList<Teacher>) FileProcess.readFile(TEACHER_PATH);
        int index = 0;
        for (Teacher t: teacherList) {
            if(t.getId().equals(teacher.getId())){
                index = teacherList.indexOf(t);
            }
        }
        teacherList.remove(index);
        teacherList.add(index,teacher);
        FileTextProcess.writeFile(makeStringList(teacherList), TEACHER_TEXT_PATH);
        FileProcess.writeFile(teacherList,TEACHER_PATH);
    }

    public void displayAllTeacher(){
        teacherList = (ArrayList<Teacher>) FileProcess.readFile(TEACHER_PATH);
        for (Teacher t: teacherList) {
            System.out.println(t.toString());
        }
    }
    public void displayTeacherById(String id){
        Teacher teacher = searchTeacher(id);
        System.out.println(teacher.toString());
    }

    public void removeTeacher(String id){
        teacherList = (ArrayList<Teacher>) FileProcess.readFile(TEACHER_PATH);
        int index = 0;
        for (Teacher t: teacherList) {
            if(t.getId().equals(id)){
                index = teacherList.indexOf(t);
            }
        }
        teacherList.remove(index);
        FileTextProcess.writeFile(makeStringList(teacherList), TEACHER_TEXT_PATH);
        FileProcess.writeFile(teacherList,TEACHER_PATH);
    }

    public Teacher searchTeacher(String id){
        teacherList = (ArrayList<Teacher>) FileProcess.readFile(TEACHER_PATH);
        for (Teacher t: teacherList) {
            if(t.getId().equals(id)){
                return t;
            }
        }
        return null;
    }

    public boolean isContainTeacher(String id){
        teacherList = (ArrayList<Teacher>) FileProcess.readFile(TEACHER_PATH);
        if(teacherList == null){
            return false;
        }
        for (Teacher t: teacherList) {
            if(t.getId().equals(id)){
                return true;
            }
        }
        return false;
    }



    private ArrayList<String> makeStringList(ArrayList<Teacher> list){
        ArrayList<String> result = new ArrayList<>();
        for (Teacher teacher:list) {
            result.add(teacher.toString());
        }
        return result;
    }



}
