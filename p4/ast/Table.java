package ast;
import java.util.*;
import java.util.function.BinaryOperator;

public class Table {
    private static Table instance = null;
    private HashMap<String, AbstractValue> originalState;
    private HashMap<String, AbstractValue> tempState; 

    private Table() {
        originalState = new HashMap<>();
    }

    public static Table getInstance() {
        if (instance == null) {
            instance = new Table();
        }
        return instance;
    }

    public void add(String identifier, AbstractValue type) {
        if (tempState != null) {
            tempState.put(identifier, type);
        } else {
            originalState.put(identifier, type);
        }
    }

    public AbstractValue get(String name) {
        if (tempState != null && tempState.containsKey(name)) {
            return tempState.get(name);
        }
        return originalState.get(name);
    }

    public boolean isDeclared(String name) {
        if (tempState != null) {
            return tempState.containsKey(name);
        }
        return originalState.containsKey(name);
    }

    public void getEntries() {
        HashMap<String, AbstractValue> targetTable = (tempState != null) ? tempState : originalState;
        int index = 1;
        for (Map.Entry<String, AbstractValue> entry : targetTable.entrySet()) {
            System.out.println(index + ". " + entry.getKey() + " | " + entry.getValue().toString());
            index++;
        }
        System.out.println("------------------");
    }


    public void newState() {
        tempState = new HashMap<>(originalState);
    }

    public void mergeState(HashMap<String, AbstractValue> s1, HashMap<String, AbstractValue> s2) {
        HashMap<String, AbstractValue> buffer = new HashMap<String, AbstractValue>();
            // consult merging rules
            s2.forEach((key, value) -> {
                if (s1.containsKey(key)) {
                    buffer.put(
                        key, //the identifier 
                        OperationMappings.getResult(s2.get(key), s1.get(key), BinaryOperation.MERGE) //the merged states
                        );
                };
            });
            originalState = buffer;
            abortTempState();
    }

    // Simply discard the changes
    public void abortTempState() {
        tempState = null; 
    }

    public HashMap<String, AbstractValue> getTempState() {
        if (tempState != null) {
            return tempState;
        } else {
            throw new RuntimeException("No temporary state exists");
        }
    }


}
