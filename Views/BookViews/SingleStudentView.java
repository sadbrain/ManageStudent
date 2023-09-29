package Views.BookViews;
import FrameWork.ViewBaseG;
import FrameWork.ViewHelp;
import Models.Student;
public class SingleStudentView extends ViewBaseG<Student> {
    
    public SingleStudentView(Student model) {super(model);}

    public void render(){
        if(model == null) {
            ViewHelp.WriteLine("No student found", ViewHelp.TEXT_RED);
            return;
        }
        ViewHelp.WriteLine("Student detail infomation", ViewHelp.TEXT_GREEN);
        System.out.println("Id:  "          + model.getId());
        System.out.println("Name:  "        + model.getName());
        System.out.println("Course: "       + model.getCourse());
        System.out.println("Semester: "        + model.getSemester());
        
    }
}
