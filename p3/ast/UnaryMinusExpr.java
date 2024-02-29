package ast;
import java.io.PrintStream;

public class UnaryMinusExpr extends Expr {
    public final Expr expr;
    // public enum NumberType {
	// 	INTEGER,
	// 	FLOAT,
	// 	OTHER
	// }

    public UnaryMinusExpr(Expr e, Location loc) {
	super(loc);
	expr = e; 
    }
    public void print(PrintStream ps) {
	ps.print("-(");
	expr.print(ps);
	ps.print(")");
    }

    public Number evaluate() {
        if (expr.evaluate() instanceof Integer) {
            return -((Long)expr.evaluate());
        } else if (expr.evaluate() instanceof Double) {
            return -((Double)expr.evaluate());
        } else {
            return null;
        }
    }
}
