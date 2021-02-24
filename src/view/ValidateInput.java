package view;

import fuctions.StudentManage;
import fuctions.TeacherManage;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateInput {
    Scanner input = new Scanner(System.in);
    private StudentManage studentManage = new StudentManage();
    private TeacherManage teacherManage = new TeacherManage();

    public LocalDate inputDate(){
        String result = inputStr("(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})");
        String[] arr = result.split("/");
        int[] time = new int[3];
        for (int i = 0; i < 3; i++) {
            time[i] = Integer.parseInt(arr[i]);
        }
        return LocalDate.of(time[2],time[1],time[0]);
    }

    public String inputPassword(String regex){
        String result = input.nextLine();
        if(!isValidate(regex,result)){
            System.out.print("Password is wrong! Re-Enter:");
            result = inputStr(regex);
        }
        return result;
    }

    public String inputIdForAdd(){
        String result = inputStr("\\d{4}");
        if(studentManage.isContainStudent(result) || teacherManage.isContainTeacher(result)){
            System.out.print("This id already exist! Re-Enter: ");
            result = inputIdForAdd();
        }
        return result;
    }

    public String inputIdForSearch(){
        String result = inputStr("\\d{4}");
        if(!studentManage.isContainStudent(result) && !teacherManage.isContainTeacher(result)){
            System.out.print("This id not existed! Re-Enter: ");
            result = inputIdForSearch();
        }
        return result;
    }

    public String inputRole(){
        String result = input.nextLine();

        String[] roleList = {"Student","Teacher","Manager"};
        for (String str: roleList) {
            if(result.equals(str)){
                return result;
            }
        }

        System.out.print("Your input not match the format! Re-Enter:");
        result = inputRole();
        return result;
    }


    public String inputStr(String regex){
        String result = input.nextLine();
        if(!isValidate(regex,result)){
            System.out.print("Your input not match the format! Re-Enter:");
            result = inputStr(regex);
        }
        return result;
    }


    public boolean isValidate(String regex,String input){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }
}
