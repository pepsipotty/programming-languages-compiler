package ast;
import java.io.PrintStream;

public class FloatConstExpr extends Expr {
    public final Double fval; 
    public FloatConstExpr(Double f, Location loc) {
	super(loc);
	fval = f;
    type = Type.FLOAT.getValue();
    value = fval.toString();
    }
    public void print(PrintStream ps) {
	ps.print(fval);
    }
}
