package ast;
import java.io.PrintStream;

import interpreter.Interpreter;

public class IdentExpr extends Expr {
    public final String ident; 
    public IdentExpr(String i, Location loc) {
	super(loc);
    System.out.println("Enter IdentExpr");
	ident = i;

    value = ident;
    type = table.get(ident);
    typeCheck();
    }
    public void print(PrintStream ps) {
	ps.print(ident);
    }

    private void typeCheck() {
        // table.getEntries();
        if (!table.isDeclared(ident)) {
            Interpreter.fatalError("Error - Variable must be declared before use: " + ident, 2);
        }
	}
}
