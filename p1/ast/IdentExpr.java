package ast;
import java.io.PrintStream;

import interpreter.Interpreter;

public class IdentExpr extends Expr {
    public final String ident; 
    public IdentExpr(String i, Location loc) {
	super(loc);
    // System.out.println("Enter IdentExpr");
	ident = i;
    value = ident;
    typeCheck(); // <-- EXPERIMENTAL ADDITION HERE
    }

    public void print(PrintStream ps) {
	ps.print(ident);
    }

    private void typeCheck() {
        // table.getEntries();
        if (table.isDeclared(ident)) {
            setType();
        } else {
            Interpreter.fatalError("Error - Variable must be declared before use: " + ident, 2);
        }
	}

    private void setType() {
        type = table.get(ident);
    }

    public String getIdent() {
        return ident;
    }


}
