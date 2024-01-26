package ast;
import java.io.PrintStream;
import java.util.Map;

import interpreter.Interpreter;

public class IntVarDecl extends VarDecl {
    private String variable;
    public IntVarDecl(String i, Location loc) {
	super(i,loc);
    System.out.println("Enter IntVarDecl");
    value = i;
    typeCheck();
    variable = i;
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
