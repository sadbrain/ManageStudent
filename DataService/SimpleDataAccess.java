package DataService;
import Models.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class SimpleDataAccess {
    private ArrayList<Student> students = new ArrayList<>();


    public ArrayList<Student> getStudents() {
        return students;
    }
    public void load(){
        students.add(new Student());            
        students.add(new Student());
        students.add(new Student());
        for(int i = 0; i < students.size(); i++) {
            students.get(i).setId(i+1);
        } 

    }

    public void saveChanges(){}
}
