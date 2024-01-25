package ast;
import java.io.PrintStream;

import interpreter.Interpreter;

public class AssignStmt extends Stmt {
    public final String ident;
    public final Expr expr;
    private String identifier;
    public AssignStmt(String i, Expr e, Location loc) {    
	super(loc);
	ident = i;
	expr = e;
    this.identifier = ident;
    typeCheck();
    }

    public void print(PrintStream ps) { 
	ps.print(ident + " = ");
	expr.print(ps);
	ps.print(";");
    }

    public void typeCheck() {
        Table table = Table.getInstance();
        if (table.isDeclared(identifier)) {
            Interpreter.fatalError("Error - Variable must be declared before assignment: " + identifier, 2);
        } else {
            
        }
    }
}
