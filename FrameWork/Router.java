package FrameWork;

import java.util.Hashtable;


public class Router {
    private Hashtable<String, IControllerAction> routingTable;
    private Hashtable<String, String> helpTable;
    public Hashtable<String, String> getHelpTable() {
        return helpTable;
    }
    public Hashtable<String, IControllerAction> getRoutingTable() {
        return routingTable;
    }
    private static Router instance;
    private Router(){
        routingTable = new Hashtable<String, IControllerAction>();
        helpTable  = new Hashtable<String, String>();
    }
    public static Router getInstance() {
        if(instance == null) {
            instance = new Router();
        }
        return instance;

    }

    public String GetHelp(String key)
    {
        //kiểm tra key có trong danh sách _helptable không, có thì trả về giá trị của key đó
        if (helpTable.containsKey(key)) return helpTable.get(key);
        else return "DOCUMENTATION NOT READY YET!";
    }

    public void register(String route, IControllerAction action, String help)
    {
      if(!helpTable.containsKey(route)){
            routingTable.put(route, action);
            helpTable.put(route, help);
      }
    }
    public void forward (String request) {
        Request req = new Request(request);
        //kiểm tra tra thử route người dùng nhập có hợp lệ không
        if (!routingTable.containsKey(req.getRoute()))
        {
            ViewHelp.WriteLine("Command invalid!", ViewHelp.TEXT_RED);;
            return;
        }
        if (req.getParameter() == null)
            routingTable.get(req.getRoute()).controllerAction(req.getParameter());

        else
            routingTable.get(req.getRoute()).controllerAction(req.getParameter());

    }

    private class Request{
        private String route;
        private Parameter parameter;
        public Parameter getParameter() {
            return parameter;
        }
        public String getRoute() {
            return route;
        }

        public Request(String request){
            analyze(request);
        }

        private void analyze(String request){
            int firstIndex = request.indexOf("?");
            if(firstIndex < 0) {
                route = request.toLowerCase().trim();
            }
            else{
                String[] tokens = request.split("\\?");
                route = tokens[0].toLowerCase().trim();
                parameter = new Parameter(tokens[1]);
            }
        }
    }
}
