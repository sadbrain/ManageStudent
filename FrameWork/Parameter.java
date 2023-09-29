package FrameWork;

import java.util.Hashtable;

public class Parameter {
    private Hashtable<String, String> pairs = new Hashtable<>();
    public Hashtable<String, String> getPairs() {
        return pairs;
    }

    public boolean containnsKey(String key){
        return pairs.containsKey(key);
    }

    public Parameter(String parameter){
        String[] pair = parameter.split("&");
        for (String p : pair) {
            String[] p2 = p.split("=");
            pairs.put(p2[0].trim(), p2[1].trim());
        }
    }
}
