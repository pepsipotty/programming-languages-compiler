package ast;
import java.util.*;
public class Table {
    private static Table instance = null;
    private static int counter;
    private HashMap<String, Wrapper> table;


    private Table() {
        table = new HashMap<>();
        counter = 0;
    }

    public static Table getInstance() {
        if (instance == null) {
            instance = new Table();
        }
        return instance;
    }

    public void add(String identifier, Wrapper type) {
        table.put(identifier, type);
    }
    

    public Wrapper get(String name) {
        return table.get(name);
    }

    public boolean isDeclared(String name) {
        return table.containsKey(name);
    }

    public void incrementCounter() {
        counter = counter + 1;
    }

    public int getCounter() {
        return counter;
    }
}