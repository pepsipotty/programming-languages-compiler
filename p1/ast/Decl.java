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
    }
    public Decl(VarDecl d, Expr e, Location loc) {
	super(loc);
	varDecl = d;
	expr = e;
    }
    public void print(PrintStream ps) { 
	varDecl.print(ps); 
	if (expr != null) {
	    ps.print(" = ");
	    expr.print(ps);
	}
	ps.print(";");
    
    Table table = Table.getInstance();
    table.incrementCounter();
    }

	// public void typeCheck() {
    //     Table table = Table.getInstance();
    //     if (!table.isDeclared(varDecl.toString())) {
    //         table.add(varDecl.toString(), expr);
    //     } else {
    //         Interpreter.fatalError("Error - Variable cannot be declared twice: " + varDecl.toString(), 2);
    //     }
    // }
}
