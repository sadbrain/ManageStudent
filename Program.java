import FrameWork.Router;
import FrameWork.ViewHelp;

public class Program {

    public static void main(String[] args) {

        ProgramHelp.configue();
        while(true){
            rootMenu();;

        }
    
    }
    private static void rootMenu(){
        ViewHelp.WriteLine("---------------------------------LibreryMan----------------------------------", ViewHelp.TEXT_YELLOW);            
        ViewHelp.WriteLine(String.format("| %-73s |","1. Create"), ViewHelp.TEXT_BLUE); 
        ViewHelp.WriteLine(String.format("| %-73s |","2. sing student"), ViewHelp.TEXT_BLUE); 
        ViewHelp.WriteLine(String.format("| %-73s |","3. list student"), ViewHelp.TEXT_BLUE); 
        ViewHelp.WriteLine(String.format("| %-73s |","4. Find and sort"), ViewHelp.TEXT_BLUE); 
        ViewHelp.WriteLine(String.format("| %-73s |","5. Update"), ViewHelp.TEXT_BLUE); 
        ViewHelp.WriteLine(String.format("| %-73s |","6. Delete"), ViewHelp.TEXT_BLUE); 

        ViewHelp.WriteLine(String.format("| %-73s |","7. Report"), ViewHelp.TEXT_BLUE); 
        ViewHelp.WriteLine(String.format("| %-73s |","8. About"), ViewHelp.TEXT_BLUE); 
        ViewHelp.WriteLine(String.format("| %-73s |","9. Help"), ViewHelp.TEXT_BLUE); 

        ViewHelp.WriteLine("---------------------------------LibreryMan----------------------------------", ViewHelp.TEXT_YELLOW);       
        ViewHelp.Write("Request >> ", ViewHelp.TEXT_PURPLE);
        String request = ViewHelp.SC.nextLine();
        Router.getInstance().forward(request);
    }

}






