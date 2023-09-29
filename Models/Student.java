package Models;

public class Student{
    private int id  ;
    private String name = "";
    private String course = "Unknown course";
    private int semester;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        if(id > 0) this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if(!(name == null || name.isEmpty())) this.name = name;
    }
    public String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        if(!(course == null || course.isEmpty())) this.course = course;
    }
    public int getSemester() {
        return semester;
    }
    public void setSemester(int semester) {
        if((semester > 0)) this.semester = semester;
    }
    
    
}