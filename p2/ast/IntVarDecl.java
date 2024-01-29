package ast;
import java.io.PrintStream;
import interpreter.Interpreter;

public class IntVarDecl extends VarDecl {
    public IntVarDecl(String i, Location loc) {
	super(i,loc);
    
    value = i;
    type = Type.INT.getValue();
    typeCheck();
    System.out.println("Enter IntVarDecl for " + i);
    }
    public void print(PrintStream ps) {
	ps.print("int " + ident);
    }

    private void typeCheck() {
        if (table.isDeclared(value)) {
            Interpreter.fatalError("Error - Variable cannot be declared twice: " + value, 2);
        }
    }
}
