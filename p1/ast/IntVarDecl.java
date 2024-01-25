package ast;
import java.io.PrintStream;

import interpreter.Interpreter;

public class IntVarDecl extends VarDecl {
    private String variable;
    public IntVarDecl(String i, Location loc) {
	super(i,loc);
    this.variable = i;
    typeCheck();
    }
    public void print(PrintStream ps) {
	ps.print("int " + ident);
    }

    public void typeCheck() {
        Table table = Table.getInstance();
        Wrapper w = new Wrapper();

        w.type = "int";
        w.counter = table.getCounter();

        if (!table.isDeclared(variable)) {
            table.add(variable, w);
        } else {
            Interpreter.fatalError("Error - Variable cannot be declared twice: " + variable, 2);
        }
    }
}
