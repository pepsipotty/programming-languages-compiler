package ast;
import java.io.PrintStream;

public class UnaryMinusExpr extends Expr {
    public final Expr expr;
    
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
        Number exprValue = expr.evaluate();
        if (exprValue instanceof Long) {
            return -((Long)exprValue);
        } else if (exprValue instanceof Double) {
            return -((Double)exprValue);
        } else {
            return null;
        }
    }
}
