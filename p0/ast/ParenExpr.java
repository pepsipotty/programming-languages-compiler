package ast;
import java.io.PrintStream;

public class ParenExpr extends Expr {
    public final Expr expr;
    public ParenExpr(Expr e, Location loc) {
	super(loc);
	expr = e; 
    }
    public void print(PrintStream ps) {
	ps.print("(");
	expr.print(ps);
	ps.print(")");
    }
}
