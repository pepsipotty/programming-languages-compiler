package ast;
import java.io.PrintStream;

import interpreter.Interpreter;

public class AssignStmt extends Stmt {
    public final String ident;
    public final Expr expr;
    public AssignStmt(String i, Expr e, Location loc) {    
	super(loc);
    ident = i;
    expr = e;
    typeCheck();
    }

    public void print(PrintStream ps) { 
	ps.print(ident + " = ");
	expr.print(ps);
	ps.print(";");
    }

    private void typeCheck() {
        // check if is declared before
        if (table.isDeclared(ident)) {
        // if declared, go ahead and check if both sides of the expression are of the same type
            if (!table.get(ident).equals(expr.type)) {
                Interpreter.fatalError("Error - Assignment of left " + ident + "(" + table.get(ident) + ")" + " variable must be of the same type as variable on the right " + expr.value + "(" + expr.type + ")", 2);
            }

        } else {
                Interpreter.fatalError("Error - Variable " + ident + " must be declared before assignment", 2);
        }
    }
}
