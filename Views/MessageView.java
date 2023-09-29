package Views;

import FrameWork.Message;
import FrameWork.ViewHelp;
import FrameWork.Router;
import FrameWork.ViewBaseG;

public class MessageView extends ViewBaseG<Message>
{
    public MessageView (Message model){super(model);}
    public void render()
    {
        //check model.type thuộc kiểu nào và in ra label tương ứng, không có label in ra dòng mặt định
        switch (model.getType())
        {
            case Success:
                ViewHelp.WriteLine(model.getLabel() != null ? model.getLabel().toUpperCase() : "SUCCESS", ViewHelp.TEXT_GREEN);
                break;
            case Error:
                ViewHelp.WriteLine(model.getLabel() != null ? model.getLabel().toUpperCase() : "ERROR!", ViewHelp.TEXT_RED);
                break;
            case Information:
                ViewHelp.WriteLine(model.getLabel() != null ? model.getLabel().toUpperCase() : "INFORMATION!", ViewHelp.TEXT_YELLOW);
                break;
            case Confirmation:
                ViewHelp.WriteLine(model.getLabel() != null ? model.getLabel().toUpperCase() : "CONFIRMATION", ViewHelp.TEXT_CYAN);
                break;

        }


        if (!(model.getType() == Message.MessageType.Confirmation)) ViewHelp.WriteLine(model.getText(), ViewHelp.TEXT_PURPLE);
        else 
        {
            //in ra dòng text
            boolean answer = ViewHelp.inputBool(model.getText(), ViewHelp.TEXT_YELLOW);
            if (answer) Router.getInstance().forward(model.getBackRoute());
        }
    }
}   