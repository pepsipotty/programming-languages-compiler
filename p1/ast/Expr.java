package ast;
import java.io.PrintStream;

//Type to store expression
public abstract class Expr extends ASTNode {
    protected String type;
    protected String value;
    public Expr(Location loc) {
	super(loc);
    }
    public abstract void print(PrintStream ps);
}
