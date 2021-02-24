package fuctions;


import entities.Person;
import fileProcess.FileTextProcess;

import java.time.LocalDate;
import java.util.ArrayList;

public class NotificationManager {
    private final String BREAK_PATH = "FileText/Danh_sach_xin_nghi_phep";


    private final String WISHES_PATH = "FileText/Wishes";


    private final String COMPLAINTS_PATH = "FileText/Complaints";


    public void takeBreak(Person p){
        ArrayList<String> breakList = FileTextProcess.readFile(BREAK_PATH);
        if(breakList == null){
            breakList = new ArrayList<>();
        }

        String str = LocalDate.now()+": ("+p.getName()+", id:"+p.getId()+") want to take a day off";

        breakList.add(str);

        FileTextProcess.writeFile(breakList, BREAK_PATH);
    }

    public void wishes(Person p,String mess){
        ArrayList<String> wishesList = FileTextProcess.readFile(WISHES_PATH);
        if(wishesList == null){
            wishesList = new ArrayList<>();
        }

        String str = LocalDate.now()+": ("+p.getName()+", id:"+p.getId()+") :"+mess;

        wishesList.add(str);

        FileTextProcess.writeFile(wishesList,WISHES_PATH);
    }

    public void complaints(String mess){
        ArrayList<String> complaintsList = FileTextProcess.readFile(COMPLAINTS_PATH);
        if(complaintsList == null){
            complaintsList = new ArrayList<>();
        }

        String str = LocalDate.now()+": "+mess;
        complaintsList.add(str);

        FileTextProcess.writeFile(complaintsList,COMPLAINTS_PATH);
    }
}
