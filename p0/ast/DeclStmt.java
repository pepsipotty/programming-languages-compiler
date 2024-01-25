package ast;
import java.io.PrintStream;

public class DeclStmt extends Stmt {
    public final VarDecl varDecl;
    public final Expr expr;
    public DeclStmt(VarDecl d, Expr e, Location loc) {
	super(loc);
	varDecl = d;
	expr = e;
    }
    public void print(PrintStream ps) { 
	varDecl.print(ps); 
	ps.print(" = ");
	expr.print(ps);
    }
}
