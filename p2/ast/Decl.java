package ast;
import java.io.PrintStream;
import interpreter.Interpreter;

public class Decl extends Unit {
    public final VarDecl varDecl;
    public final Expr expr;
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
    public void print(PrintStream ps, String indent) { 
	ps.print(indent);
	varDecl.print(ps); 
	if (expr != null) {
	    ps.print(" = ");
	    expr.print(ps);
	}
	ps.print(";");
    }
    public void print(PrintStream ps) {
	print(ps,"");
    }

	private void typeCheck() {
		if (expr != null) {
			if (!varDecl.type.equals(expr.type)) {
				Interpreter.fatalError("Error - Declaration of left " + varDecl.ident + "(" + varDecl.type + ")" + " variable must be of the same type as variable on the right " + expr.value + "(" + expr.type + ")", 2);
			}
		}
	}

	private void updateTable(TableObj table) {
		// System.out.println("Updating table for " + varDecl.value);
		table.add(varDecl.value, varDecl.type);
	}

	public void check(TableObj t) {
		varDecl.check(t);
		if (expr != null) {
			expr.check(t);
		};
		typeCheck();
		// System.out.println("Updating table for " + varDecl.value);
		updateTable(t);

	}

	
}
