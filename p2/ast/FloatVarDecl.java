package ast;
import java.io.PrintStream;

import interpreter.Interpreter;

public class FloatVarDecl extends VarDecl {
    public FloatVarDecl(String i, Location loc) {
	super(i,loc);

    value = i;
    type = Type.FLOAT.getValue();
    // System.out.println("Enter FloatVarDecl for " + i);
    }
    public void print(PrintStream ps) {
	ps.print("float " + ident);
    }

    public void check(TableObj table) {
        // table.getEntries();
        if (table.isDeclared(value)) {
            Interpreter.fatalError("Error - Variable cannot be declared twice: " + value, 2);
        }
    }
}
