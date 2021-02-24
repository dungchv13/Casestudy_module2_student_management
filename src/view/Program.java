package view;

import entities.Student;
import entities.Teacher;
import fuctions.NotificationManager;
import fuctions.StudentManage;
import fuctions.TeacherManage;
import menus.ManagerMenu;
import menus.StudentMenu;
import menus.TeacherMenu;

public class Program {
    private static Program instance;

    private Program(){
    }

    public static Program getInstance() {
        if(instance == null){
            instance = new Program();
        }
        return instance;
    }


    private ValidateInput input = new ValidateInput();
    private NotificationManager notificationManager = new NotificationManager();
    private StudentManage studentManage = new StudentManage();
    private TeacherManage teacherManage = new TeacherManage();

    public void login(){
        do{
            System.out.println("-----------Login-----------");
            System.out.print("Enter your role(Student/Teacher/Manager): ");
            String role = input.inputRole();
            if(role.equals("Manager")){
                System.out.print("Enter password:");
                String password = input.inputPassword("789153");
                programForManager();
            }else {
                System.out.print("Enter password(your id): ");
                String id = input.inputIdForSearch();
                if(role.equals("Teacher")){
                    programForTeacher(teacherManage.searchTeacher(id));
                }else{
                    programForStudent(studentManage.searchStudent(id));
                }
            }
        }while(true);
    }

    public void programForManager(){
        ManagerMenu menu = new ManagerMenu();
        do {
            System.out.println("---------MANAGER_MENU---------");
            System.out.println("1.Thêm học viên.");
            System.out.println("2.Xóa học viên.");
            System.out.println("3.Thêm giáo viên.");
            System.out.println("4.Xóa giáo viên.");
            System.out.println("5.Tìm kiếm học viên hoặc giáo viên theo id.");
            System.out.println("6.lấy file danh sách học viên.");
            System.out.println("7.lấy file danh sach giáo viên.");
            System.out.println("8.Lấy file danh sách các học sinh xin nghỉ. ");
            System.out.println("9.Lấy file danh sách mong muốn và than phiền của học viên.");
            System.out.println("0.Exit");
            System.out.print("Enter :");
            int choice = Integer.parseInt(input.inputStr("[0-9]"));
            switch (choice){
                case 1:
                    System.out.println("************************");
                    studentManage.addStudent(menu.menu1());
                    System.out.println("************************");
                    studentManage.displayAllStudent();
                    break;
                case 2:
                    System.out.println("************************");
                    studentManage.removeStudent(menu.menu2());
                    System.out.println("************************");
                    studentManage.displayAllStudent();
                    break;
                case 3:
                    System.out.println("************************");
                    teacherManage.addTeacher(menu.menu3());
                    System.out.println("************************");
                    teacherManage.displayAllTeacher();
                    break;
                case 4:
                    System.out.println("************************");
                    teacherManage.removeTeacher(menu.menu4());
                    System.out.println("************************");
                    teacherManage.displayAllTeacher();
                    break;
                case 5:
                    System.out.println("************************");
                    String id = menu.menu5();
                    if(teacherManage.isContainTeacher(id)){
                        teacherManage.displayTeacherById(id);
                    }else{
                        studentManage.displayStudentById(id);
                    }
                    System.out.println("************************");
                    break;
                case 6:
                    System.out.println("************************");
                    System.out.println("E:\\module2\\case_Study_module2_QuanLyHocSinh\\FileText\\StudentList");
                    System.out.println("************************");
                    break;
                case 7:
                    System.out.println("************************");
                    System.out.println("E:\\module2\\case_Study_module2_QuanLyHocSinh\\FileText\\TeacherList");
                    System.out.println("************************");
                    break;
                case 8:
                    System.out.println("************************");
                    System.out.println("E:\\module2\\case_Study_module2_QuanLyHocSinh\\FileText\\Danh_sach_xin_nghi_phep");
                    System.out.println("************************");
                    break;
                case 9:
                    System.out.println("************************");
                    System.out.println("E:\\module2\\case_Study_module2_QuanLyHocSinh\\FileText\\Wishes");
                    System.out.println("************************");
                    break;
                case 0:
                    System.exit(0);
            }
        }while(true);


    }

    public void programForTeacher(Teacher teacher){
        TeacherMenu menu = new TeacherMenu();
        do{
            System.out.println("----------TeacherMenu---------");
            System.out.println("1.Xửa thông tin cá nhân.");
            System.out.println("2.Gửi mong muốn.");
            System.out.println("3.Gửi than phiền.");
            System.out.println("4.Xin nghỉ phép.");
            System.out.println("5.Xem thông tin cá nhân.");
            System.out.println("6.Xem thông tin các học sinh.");
            System.out.println("7.Nhập trạng thái cho học sinh.");
            System.out.println("0.Exit");
            System.out.print("Enter :");
            int choice = Integer.parseInt(input.inputStr("[0-7]"));
            switch (choice){
                case 1:
                    System.out.println("************************");
                    Teacher t1 = menu.menu1(teacher);
                    teacher = t1;
                    teacherManage.updateTeacher(t1);
                    System.out.println("************************");
                    break;
                case 2:
                    System.out.print("Enter your wishes: ");
                    String str2 = input.inputStr(".+");
                    notificationManager.wishes(teacher,str2);
                    break;
                case 3:
                    System.out.println("************************");
                    System.out.print("Enter your complaints: ");
                    String str3 = input.inputStr(".+");
                    notificationManager.complaints(str3);
                    System.out.println("************************");
                    break;
                case 4:
                    System.out.println("************************");
                    System.out.println("Thông báo xin nghỉ đã được gửi.");
                    notificationManager.takeBreak(teacher);
                    System.out.println("************************");
                    break;
                case 5:
                    System.out.println("************************");
                    System.out.println(teacher.toString());
                    System.out.println("************************");
                    break;
                case 6:
                    System.out.println("************************");
                    studentManage.displayAllStudent();
                    System.out.println("************************");
                    break;
                case 7:
                    System.out.println("************************");
                    menu.menu7(studentManage);
                    System.out.println("************************");
                    break;
                case 0:
                    System.exit(0);
            }
        }while(true);

    }


    public void programForStudent(Student student){
        StudentMenu menu = new StudentMenu();
        do{
                System.out.println("------StudentMenu------");
                System.out.println("1.Xửa thông tin cá nhân.");
                System.out.println("2.Gửi mong muốn.");
                System.out.println("3.Gửi than phiền.");
                System.out.println("4.Xin nghỉ phép.");
                System.out.println("5.Xem thông tin cá nhân.");
                System.out.println("6.Xem thông tin các giáo viên.");
                System.out.println("0.Exit");
                System.out.print("Enter :");
                int choice = Integer.parseInt(input.inputStr("[0-6]"));
                switch (choice){
                    case 1:
                        System.out.println("************************");
                        Student s1 = menu.menu1(student);
                        student = s1;
                        studentManage.updateStudent(s1);
                        System.out.println("************************");
                        break;
                    case 2:
                        System.out.println("************************");
                        System.out.print("Enter your wishes: ");
                        String str2 = input.inputStr(".+");
                        notificationManager.wishes(student,str2);
                        System.out.println("************************");
                        break;
                    case 3:
                        System.out.println("************************");
                        System.out.print("Enter your complaints: ");
                        String str3 = input.inputStr(".+");
                        notificationManager.complaints(str3);
                        System.out.println("************************");
                        break;
                    case 4:
                        System.out.println("************************");
                        System.out.println("Thông báo xin nghỉ đã được gửi.");
                        notificationManager.takeBreak(student);
                        System.out.println("************************");
                        break;
                    case 5:
                        System.out.println("************************");
                        System.out.println(student.toString());
                        System.out.println("************************");
                        break;
                    case 6:
                        System.out.println("************************");
                        teacherManage.displayAllTeacher();
                        System.out.println("************************");
                        break;
                    case 0:
                        System.exit(0);
                }
        }while(true);

    }
}
