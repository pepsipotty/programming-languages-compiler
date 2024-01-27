package ast;
import java.io.PrintStream;

import interpreter.Interpreter;

public class IntVarDecl extends VarDecl {
    public IntVarDecl(String i, Location loc) {
	super(i,loc);
    value = i;
    typeCheck();
    }
    public void print(PrintStream ps) {
	ps.print("int " + ident);
    }

    public void typeCheck() {
        if (!table.isDeclared(value)) {
            type = Type.INT.getValue();
        } else {
            Interpreter.fatalError("Error - Variable cannot be declared twice: " + value, 2);
        }
    }
}
