package ast;
import java.io.PrintStream;

import interpreter.Interpreter;

public class Decl extends Unit {
    
    public final VarDecl varDecl;
    public final Expr expr;
	// private VarDecl variable;
    public Decl(VarDecl d, Location loc) {
	super(loc);
	varDecl = d;
	expr = null;
	updateTable();
    }

    public Decl(VarDecl d, Expr e, Location loc) {
	super(loc);
	varDecl = d;
	expr = e;
	typeCheck();
	updateTable();
    }

    public void print(PrintStream ps) { 
	varDecl.print(ps); 
	if (expr != null) {
	    ps.print(" = ");
	    expr.print(ps);
	}
	ps.print(";");
    
    }

	private void typeCheck() {
		if (!varDecl.type.equals(expr.type)) {
			Interpreter.fatalError("Error - Declaration of left " + varDecl.ident + "(" + varDecl.type + ")" + " variable must be of the same type as variable on the right " + expr.value + "(" + expr.type + ")", 2);
		}
	}

	private void updateTable() {
		table.add(varDecl.value, varDecl.type);
	}

}
