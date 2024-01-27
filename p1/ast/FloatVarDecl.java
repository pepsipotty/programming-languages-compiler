package ast;
import java.io.PrintStream;

import interpreter.Interpreter;

public class FloatVarDecl extends VarDecl {
    public FloatVarDecl(String i, Location loc) {
	super(i,loc);
    value = i;
    type = Type.FLOAT.getValue();
    typeCheck(i);
    }
    public void print(PrintStream ps) {
	ps.print("float " + ident);
    }

    private void typeCheck(String variable) {
        if (table.isDeclared(value)) {
            // table.getEntries();
            Interpreter.fatalError("Error - Variable cannot be declared twice: " + value, 2);
        }
    }
}
