package ast;
import java.io.PrintStream;

import interpreter.Interpreter;

public class FloatVarDecl extends VarDecl {
    public FloatVarDecl(String i, Location loc) {
	super(i,loc);
    typeCheck(i);
    }
    public void print(PrintStream ps) {
	ps.print("float " + ident);
    }

    public void typeCheck(String variable) {
        Table table = Table.getInstance();
        if (!table.isDeclared(variable)) {
            table.add(variable, Type.FLOAT.getValue());
            type = Type.FLOAT.getValue();
            table.getEntries();
        } else {
            Interpreter.fatalError("Error - Variable cannot be declared twice: " + variable, 2);
        }
    }
}
