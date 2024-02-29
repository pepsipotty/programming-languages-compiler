package ast;
import java.io.PrintStream;

public abstract class Expr extends ASTNode {
    protected String type;
    protected Number value;
    public Expr(Location loc) {
	super(loc);
    }

    public abstract Number evaluate();
    // public abstract boolean evaluate();
}
