package Views.StudentViews;

import FrameWork.ViewBaseG;
import FrameWork.ViewHelp;
import Models.Student;

public class UpdateStudentView extends ViewBaseG<Student>{
    public UpdateStudentView(Student model) {super(model);}
    public void render(){
        ViewHelp.WriteLine("Update Student infomation", ViewHelp.TEXT_GREEN);
   
        String name = ViewHelp.inputString("Name", model.getName(), ViewHelp.TEXT_PURPLE);
        String course = ViewHelp.inputString("Course", model.getCourse(), ViewHelp.TEXT_PURPLE);
        int semester = ViewHelp.inputInt("Semester", model.getSemester(), ViewHelp.TEXT_PURPLE);

        String request = "do update student ?"
                    +" id =" + model.getId() 
                    +" & name = " + name 
                    +" & course = " + course
                    +" & semester  = " + semester;
        
        router.forward(request);

    }
}
