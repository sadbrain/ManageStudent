import java.time.LocalDate;
import java.util.Hashtable;

import Controller.*;
import DataService.SimpleDataAccess;
import FrameWork.Parameter;
import FrameWork.Router;
import FrameWork.ViewHelp;
import Models.*;

public class ProgramHelp {
    public static void configue(){
        SimpleDataAccess context = new SimpleDataAccess();
        context.load();

        StudentController studentController = new StudentController(context);

        Router r = Router.getInstance();
        r.register("0", (p) -> Program.main(new String[]{"call main"}), "call main");
        r.register("4", (p) -> studentController.findAndSort(), "find and sort by name");
        // r.register("1.3", (p) -> studentController.single(), "display a book");        
        r.register("1", (p) -> studentController.create(null), "create a book");
        r.register("do create student", (p) -> studentController.create(toStudent(p)), "do create a student");
        r.register("2", (p) -> studentController.single(), "single a student");
        r.register("3", (p) -> studentController.list(), "list a student");

        r.register("5", (p) -> studentController.update(0, null), "update a studen");
        r.register("do update student", (p) -> studentController.update(Integer.valueOf(p.getPairs().get("id")), toStudent(p)), "do update a student");
        r.register("6", (p) -> studentController.delete(0, false), "delete a book");
        r.register("do delete student", (p) -> studentController.delete(Integer.valueOf(p.getPairs().get("id")), true), "do delete a sudent");


        r.register("8", (p) -> about(), "");
        r.register("9", (p) -> help(p), "");
    }

    private static void about()
    {
        ViewHelp.WriteLine("BOOK MANAGER version 2  .0", ViewHelp.TEXT_GREEN);
        ViewHelp.WriteLine("by dhnynit@TuHocIct.com", ViewHelp.TEXT_YELLOW);
    }

    private static void help(Parameter p)
    {
        if (p == null)
        {
            ViewHelp.WriteLine("SUPPORTED COMMANDS:", ViewHelp.TEXT_GREEN);
            ViewHelp.WriteLine("type: 9 ? cmd = <number> to get command details", ViewHelp.TEXT_CYAN);
            return;
        }
        String command = p.getPairs().get("cmd").toLowerCase();
        ViewHelp.WriteLine(Router.getInstance().GetHelp(command), ViewHelp.TEXT_BLACK);
    }
    
    private static Student toStudent(Parameter parameter)
    {
        Hashtable<String, String> p = parameter.getPairs();
        Student b = new Student();
        if(p.containsKey("id")) b.setId(Integer.valueOf(p.get("id")));
        if (p.containsKey("name")) b.setName(p.get("name"));
        if (p.containsKey("course")) b.setCourse(p.get("course"));
        if (p.containsKey("semester")) b.setSemester(Integer.valueOf(p.get("semester")));
        return b;
    }

}
