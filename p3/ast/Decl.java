package ast;
import java.io.PrintStream;

public class Decl extends Unit {
    public final VarDecl varDecl;
    public final Expr expr;
    public Decl(VarDecl d, Location loc) {
	super(loc);
	varDecl = d;
	expr = null;
	execute();
    }
    public Decl(VarDecl d, Expr e, Location loc) {
	super(loc);
	varDecl = d;
	expr = e;
	execute();
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

	public void execute() {
		if (expr != null){
			table.add(varDecl.ident, expr.evaluate());
		} 
		table.getEntries();
	}
}
