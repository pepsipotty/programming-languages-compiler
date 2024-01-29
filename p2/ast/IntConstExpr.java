package ast;
import java.io.PrintStream;

public class IntConstExpr extends Expr {
    public final Long ival; 
    public IntConstExpr(Long i, Location loc) {
	super(loc);
	ival = i;
    System.out.println("Enter IntConstExpr for " + i);

    type = Type.INT.getValue();
    value = ival.toString();
    }
    public void print(PrintStream ps) {
	ps.print(ival);
    }
}
