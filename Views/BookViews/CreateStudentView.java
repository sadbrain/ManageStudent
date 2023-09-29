package Views.BookViews;

import FrameWork.ViewBase;
import FrameWork.ViewHelp;

public class CreateStudentView extends ViewBase{
    
    public CreateStudentView(){super();}

    public void render(){
        ViewHelp.WriteLine("Create a new student", ViewHelp.TEXT_GREEN);
        String name = ViewHelp.inputString("Name", ViewHelp.TEXT_PURPLE);
        String course = ViewHelp.inputString("Course", ViewHelp.TEXT_PURPLE);
        int semester = ViewHelp.inputInt("Semester", ViewHelp.TEXT_PURPLE);

        String request = "do create student ?"
                    +" name = " + name
                    +" &course = " + course 
                    +" & semester = " + semester;
        
        router.forward(request);
            
    }
}
