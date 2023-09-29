package Controller;
import DataService.StudentRepository;
import DataService.SimpleDataAccess;
import FrameWork.ControllerBase;
import FrameWork.Router;
import FrameWork.ViewHelp;
import Models.Student;
import Views.BookViews.*;

public class StudentController extends ControllerBase{
    protected StudentRepository studentRepository;
    
    public StudentController(SimpleDataAccess context){
        studentRepository = new StudentRepository(context);
    }


    public void single(){
        int id = ViewHelp.inputInt("Enter book id", ViewHelp.TEXT_PURPLE);
        Student model = studentRepository.select(id);
        render(new SingleStudentView(model));
    }

    public void list(){
        Student[] students = studentRepository.select();
        render(new ListStudentView(students));
    }

    public void create(Student b){
        if(b == null){
            render(new CreateStudentView());
        }
        studentRepository.insert(b);

        success("Student added!", null);
        Router.getInstance().forward("0");
    }

    public void findAndSort(){
        String name = ViewHelp.inputString("Name", ViewHelp.TEXT_PURPLE);

        Student[] students = studentRepository.select(name);
        studentRepository.sort(students);
        render(new ListStudentView(students));
        
    }

    public void update(int id, Student b){

        if(b == null){
            id = ViewHelp.inputInt("Enter book id", ViewHelp.TEXT_PURPLE);
            Student model = studentRepository.select(id);
            if(model == null){
                ViewHelp.WriteLine("No book found, please choose another book", ViewHelp.TEXT_YELLOW);
                return;
            }

            render(new UpdateStudentView(model));
            return;
        }

        studentRepository.update(id, b);
        success("Book updated!", null);


    }

    public void delete(int id, boolean process){

        //đầu tiên md process sẽ là false để tìm sách và đưa ra thông báo có muốn xóa hay không.
        //có thì sẽ gọi hàm này một lần nữa và process sẽ là true, 
        if (!process)
        {
            id = ViewHelp.inputInt("Enter student id", ViewHelp.TEXT_PURPLE);
            Student b = studentRepository.select(id);
            if(b != null)  {
                confirm("Do you want to delete this student " +b.getName() +"?", "do delete student ? id = "+ b.getId(), null); 
                return;       
            }
            else
            {

                inform("No book found, please choose another student!", null);
                return;
            }

        }
        else
        {
            studentRepository.delete(id);
            success("Book deleted!", null);

        }
    }
}
