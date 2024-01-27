package ast;
import java.io.PrintStream;

import interpreter.Interpreter;

public class FloatVarDecl extends VarDecl {
    public FloatVarDecl(String i, Location loc) {
	super(i,loc);
    value = i;
    typeCheck(i);
    }
    public void print(PrintStream ps) {
	ps.print("float " + ident);
    }

    public void typeCheck(String variable) {
        if (!table.isDeclared(value)) {
            type = Type.FLOAT.getValue();
            // table.getEntries();
        } else {
            Interpreter.fatalError("Error - Variable cannot be declared twice: " + value, 2);
        }
    }
}
