package ast;
import java.io.PrintStream;

public class ReadFloatExpr extends Expr {
    public ReadFloatExpr(Location loc) {
	super(loc);
    type = Type.FLOAT.getValue();
    }
    public void print(PrintStream ps) {
	ps.print("readfloat");
    }

    public void check(TableObj t){
        // Do nothing
    }
}
