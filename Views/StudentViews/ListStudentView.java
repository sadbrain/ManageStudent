package Views.StudentViews;


import FrameWork.ViewBaseG;
import FrameWork.ViewHelp;
import Models.Student;

public class ListStudentView extends ViewBaseG<Student[]>{
    
    public ListStudentView(Student[] models) {super(models);}

    public  void render(){
        if(model.length == 0) {
            ViewHelp.WriteLine("No student found", ViewHelp.TEXT_RED);
            return;
        }
        ViewHelp.WriteLine(String.format("%60s %n", "The Student list"), ViewHelp.TEXT_GREEN);
        ViewHelp.WriteLine("_____________________________________________________________________________________________________________________________________________________________________________",ViewHelp.TEXT_YELLOW);
        ViewHelp.WriteLine(String.format("| %-40s | %-40s | %-40s | %-40s |", "ID", "Name", "Course", "Semester"), ViewHelp.TEXT_YELLOW);
        ViewHelp.WriteLine("|__________________________________________|__________________________________________|__________________________________________|__________________________________________|", ViewHelp.TEXT_YELLOW);

        for (Student m : model) {

                System.out.printf("| %-40d | %-40s | %-40s | %-40d | %n", m.getId(), m.getName(), m.getCourse(), m.getSemester());
                ViewHelp.WriteLine("|__________________________________________|__________________________________________|__________________________________________|__________________________________________|", ViewHelp.TEXT_YELLOW);

                

        }

        ViewHelp.WriteLine( String.format("%n%63s", "list has " +  model.length + " items"), ViewHelp.TEXT_GREEN);
        ViewHelp.WriteLine( String.format("%n%65s","----------End----------"), ViewHelp.TEXT_GREEN);
  
    }
}
