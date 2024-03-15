package ast;
import java.util.*;
public class Table {
    private static Table instance = null;
    private HashMap<String, Number> table;
    public Scanner s = new Scanner(System.in);

 //complexity - number to float or number to long etc - Sum of 2 numbers, would have to get this Number obj, and get from it the primitive value type. 

    private Table() {
        table = new HashMap<>();
    }

    public static Table getInstance() {
        if (instance == null) {
            instance = new Table();
        }
        return instance;
    }

    public void add(String identifier, Number type) {
        table.put(identifier, type);
    }
    

    public Number get(String name) {
        return table.get(name);
    }

    public boolean isDeclared(String name) {
        return table.containsKey(name);
    }

    public void getEntries() {
        int index = 1;
        for (Map.Entry<String, Number> entry : table.entrySet()) {
            System.out.println(index + ". " + entry.getKey() + " | " + entry.getValue().toString());
            index++;
        }
        System.out.println("------------------");
    }

}