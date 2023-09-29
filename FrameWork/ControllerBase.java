package FrameWork;

import Views.MessageView;

public class ControllerBase{
    public void render(ViewBase view) { view.render(); }
    
    public void render(Message message) {render(new MessageView(message));}
    public void success(String text, String label) { render(new Message ( Message.MessageType.Success, text, label)); }
    public void inform(String text, String label) { render(new Message ( Message.MessageType.Information, text, label)); }
    public void error(String text, String label) { render(new Message ( Message.MessageType.Error, text, label)); }
    public void confirm(String text, String route, String label) { render(new Message ( Message.MessageType.Confirmation, text, label,route));}
}