package ast;
import java.util.*;
public class Table {
    private static Table instance = null;
    public Table parent = null;
    private HashMap<String, String> table;


    public Table() {
        table = new HashMap<>();
    }

    public static Table getInstance() {
        if (instance == null) {
            instance = new Table();
        }
        return instance;
    }

    public void add(String identifier, String type) {
        table.put(identifier, type);
    }
    

    public String get(String name) {
        return table.get(name);
    }

    public boolean isDeclared(String name) {
        return table.containsKey(name);
    }

    public void getEntries() {
        //for debugging purposes
        int index = 1;
        for (Map.Entry<String, String> entry : table.entrySet()) {
            System.out.println(index + ". " + entry.getKey() + " | " + entry.getValue());
            index++;
        }
        System.out.println("------------------");
    }

}