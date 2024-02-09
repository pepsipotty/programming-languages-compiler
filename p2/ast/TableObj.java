package ast;
import java.util.*;

public class TableObj {
    private HashMap<String, String> tableObj;
    public TableObj parent;

    public TableObj() {
        tableObj = new HashMap<>();
    }

    public void add(String identifier, String type) {
        tableObj.put(identifier, type);
    }

    public void getEntries() {
        //for debugging purposes
        int index = 1;
        for (Map.Entry<String, String> entry : tableObj.entrySet()) {
            System.out.println(index + ". " + entry.getKey() + " | " + entry.getValue());
            index++;
        }
        System.out.println("------------------");
    }

    public void getAllEntries() {
        //for debugging purposes
        int index = 1;
        for (Map.Entry<String, String> entry : tableObj.entrySet()) {
            System.out.println(index + ". " + entry.getKey() + " | " + entry.getValue());
            index++;
        }
        if (parent != null) {
            parent.getAllEntries();
        }
    }

    public String get(String name) {
        return tableObj.get(name);
    }

    public boolean isDeclared(String name) {
        return tableObj.containsKey(name);
    }

    public TableObj getParent() {
        return parent;
    }

}