package ast;
import java.io.PrintStream;

public class IntConstExpr extends Expr {
    public final Long ival; 
    public IntConstExpr(Long i, Location loc) {
	super(loc);
	ival = i;
    }
    public void print(PrintStream ps) {
	ps.print(ival);
    }

    public Number evaluate() {
        return ival;
    }
}

//implement a subset (like + * - /) of the operators. Run bunch of programs that test this
