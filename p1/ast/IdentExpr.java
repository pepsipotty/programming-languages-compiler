package ast;
import java.io.PrintStream;

import interpreter.Interpreter;

public class IdentExpr extends Expr {
    public final String ident; 
    public IdentExpr(String i, Location loc) {
	super(loc);
	ident = i;
    typeCheck(); // <-- EXPERIMENTAL ADDITION HERE
    }
    public void print(PrintStream ps) {
	ps.print(ident);
    }

    private void typeCheck() {
        Table table = Table.getInstance();
        if (!table.isDeclared(ident)) {
            Interpreter.fatalError("Error - Variable must be declared before use: " + ident, 2);
        } else if ((table.getCounter() == table.get(ident).counter)){
            Interpreter.fatalError("tableCounter:" + table.getCounter() + "identCounter:" + table.get(ident).counter , 2);
        } else {
            
        }
	}


}
