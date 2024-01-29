package ast;
import java.io.PrintStream;

public class ReadIntExpr extends Expr {
    public ReadIntExpr(Location loc) {
	super(loc);
    System.out.println("Enter ReadIntExpr");
    type = Type.INT.getValue();
    }
    public void print(PrintStream ps) {
	ps.print("readint");
    }
}
