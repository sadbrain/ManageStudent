package DataService;

import java.util.ArrayList;
import Models.Student;
public class StudentRepository {
    protected SimpleDataAccess context;

    public StudentRepository(SimpleDataAccess context) {
        this.context = context;
    }
    
    public void saveChange() {context.saveChanges();}

    public ArrayList<Student> students () {return context.getStudents();}

    public Student[] select() {return context.getStudents().toArray(new Student[context.getStudents().size()]);}

    public Student select(int id){
        for (Student s : context.getStudents()) {
            if(s.getId() == id){
                return s;
            }
        }
        return null;
    }
    public void insert(Student student){
        int i = context.getStudents().size();
        int id = i == 0 ? 1 : context.getStudents().get(i-1).getId() + 1;
        student.setId(id);
        context.getStudents().add(student);
    }
    public Student[] select(String key)
    {
        ArrayList<Student> list = new ArrayList<Student>();
        String k = key.toLowerCase();
        for (Student student : students()) {
            boolean login = student.getName().toLowerCase().contains(k);
            if(login){
                list.add(student);
            }
        }
        return list.toArray(new Student[list.size()]);
        

    }
    public void sort(Student[] list)
    {
        int n = list.length;  
        Student temp;  
        for(int i=0; i < n; i++){  
                 for(int j=1; j < (n-i); j++){  
                          if(list[j-1].getName().compareTo(list[j].getName()) > 0){  
                                 //swap elements  
                                 temp = list[j-1];  
                                 list[j-1] = list[j];  
                                 list[j] = temp;  
                         }  
                           
                 }  
         }  
           

    }
    public boolean update(int id, Student student){
        Student s = select(id);
        if(s == null) return false;
        s.setName(student.getName());
        s.setCourse(student.getCourse());
        s.setSemester(student.getSemester());
        return true;
    }
    public boolean delete(int id)
    {
        Student s = select(id);
        if (s == null) return false;
        context.getStudents().remove(s);
        return true;
    } 

}
