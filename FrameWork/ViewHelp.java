package FrameWork;

import java.util.Scanner;
import java.time.LocalDate;

public class ViewHelp {
    //những biến lưu màu chữ
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_BLACK = "\u001B[30m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_PURPLE = "\u001B[35m";
    public static final String TEXT_CYAN = "\u001B[36m";
    public static final String TEXT_YELLOW = "\u001B[33m";
    public static final String TEXT_WHITE = "\u001B[37m";
    public static final Scanner SC = new Scanner(System.in);


    //hiên thị ra màn hình dòng message với màu mình truyền vào
    public static void Write(String message, String color) 
    {
        //cú pháp để hiện thị ra chữ với màu
        System.out.print(color + message);
        //reset lại màu về text_reset
        System.out.print(TEXT_RESET);
    
    }

    //hiên thị ra màn hình dòng message với màu mình truyền vào 
    public static void WriteLine(String message, String color)
    {
        System.out.println(color + message);
        System.out.print(TEXT_RESET);
    }


    //hàm đây xịn hơn sc.nextBoolean ở chổ mình có thể hiện thị dòng message với màu rồi mới gán giá trị cho biến
    public static boolean inputBool(String label, String labelColor)
    {
        //xem lại hàm write ở trên, đây chỉ là cách trình bày thôi
        Write(label + " [y/n]: ", labelColor);
        //tối lấy kí tự đầu của người dùng nhập
        String value = SC.nextLine();
        if(value.equals("")) return false;
        
        //kiểm tra xem nó = y or Y lớn ko, đúng thì trả về true không thì false
        return (value.charAt(0) == 'y' || value.charAt(0) == 'Y') ? true : false;
    }

    public static boolean inputBool(String label, boolean oldValue, String labelColor)
    {
        Write(label + ": ", labelColor);
        
        WriteLine(String.valueOf(oldValue), TEXT_YELLOW);
        Write("New value >> ", TEXT_GREEN);
        String newValue = SC.nextLine();
        if(newValue.equals("")) return oldValue;
        return newValue.charAt(0) == 'y' || newValue.charAt(0) == 'Y' ? true : false;
    } 

    //hàm đây xịn hơn sc.nextInt ở chổ mình có thể hiện thị dòng message với màu rồi mới gán giá trị cho biến, nhưng giá trị phải là số
    public static int inputInt(String label, String labelColor)
    {
        //mục đích khi có lỗi nó sẽ ko chạy return, mà nó xuống thẳng catch rồi quay lên đầu vòng while nhập tiếp
        while(true){
            try
            {
                //xuống coi hàm inputString
                String value = inputString(label, labelColor);
                //ép chuổi sang số int
                int num = Integer.valueOf(value);
                return num;
            }
            catch(Exception NumberFormatException){
                //dòng hiển thị tại sao nó sai và thêm màu cho đẹp
                WriteLine("Enter a number please", TEXT_RED);
            }
        }
 
    }

    

    //hàm dưới đây phục vụ cho việc update với biến thuộc kiểu int
    // hiển thị giá trị cũ rỗi nhập giá trị mới
    public static int inputInt(String label, int oldValue, String labelColor)
    {
        //2 lệnh dưới hiển thị giá trị củ
        Write(label + ": ", labelColor);
        //cần phải dùng String.valueOf(oldValue) để ép nó sang string cho phù hợp với hàm vừa WriteLine
        WriteLine(String.valueOf(oldValue), TEXT_YELLOW);
        //gọi hàm nhập số int ở trên
        int newValue = inputInt("New value >>", TEXT_GREEN);
        
        return newValue <= 0 ? oldValue : newValue;
 
    }



    //thằng này tương tự hàm inputInt chỉ khác mỗi kiểu dữ liệu
    public static double inputDouble(String label, String labelColor)
    {
        while(true){
            try
            {
                String value = inputString(label, labelColor);
                double num = Double.parseDouble(value);
                return num;
            }
            catch(Exception NumberFormatException){
                WriteLine("Enter a number please", TEXT_RED);
            }
        }
 
    }

    //hàm dưới đây phục vụ cho việc update với biến thuộc kiểu double
    // hiển thị giá trị cũ rỗi nhập giá trị mới

    public static double inputDouble(String label, double oldValue, String labelColor)
    {
        //2 lệnh dưới hiển thị giá trị củ
        Write(label + ": ", labelColor);
        WriteLine(String.valueOf(oldValue), TEXT_YELLOW);

        double newValue = inputDouble("New value >>", TEXT_GREEN);
        return newValue <= 0 ? oldValue : newValue;
 
    }
    


    //hàm nhập chuỗi có thêm màu và trả về chuỗi thế thôi :))
    public static String inputString(String label, String labelColor)
    {
        //muốn không rối ở đây thì khi gọi hàm nên ở ý tham số của hàm mà truyền cho đúng nhá :))
        Write(label + ": ", labelColor);
        String value = SC.nextLine();
        return value; 
    }

    //hàm dưới đây phục vụ cho việc update với biến thuộc kiểu string
    // hiển thị giá trị cũ rỗi nhập giá trị mới
    public static String inputString(String label, String oldValue, String labelColor)
    {
        Write(label + ": ", labelColor);
        WriteLine(oldValue, TEXT_YELLOW);

        String newValue = inputString("New value >>", TEXT_GREEN);
        return newValue == "" || newValue == null ? oldValue : newValue;
 
    }

    public static LocalDate inputDate(String labelColor){
        while (true) {
            int year = inputInt("Year", labelColor);
            int month = inputInt("Month", labelColor);
            int day = inputInt("Day", labelColor); 
            

            
            if(day <= 0 || day > 31) WriteLine("Day should in range(1,31)", TEXT_RED);
            else if(day == 31 && (month == 2 || month ==4 || month == 6 || month == 9 || month == 11))
            WriteLine("Day in " + month + " shouldn't 31" , TEXT_RED);
            else  if(month <= 12 && month >= 1 && year >= 0 ) return LocalDate.of(year, month,day);
            

            if(year <= 0) WriteLine("Year should greater 0", TEXT_RED);
            if(month <= 0 || month > 12) WriteLine("Month should in range(1,12)", TEXT_RED); 

            
        }
        
        
    }

    public static LocalDate inputDate(String label, LocalDate oldvalue, String labelColor){
        Write(label + ": ", labelColor);
        System.out.println( TEXT_YELLOW + oldvalue);
        return inputDate(labelColor);
        
    }



}
