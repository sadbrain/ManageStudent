package FrameWork;


public abstract class ViewBase{
    protected Router router = Router.getInstance();

    public ViewBase() { }

    public abstract void render();


}



