package ast;
import java.io.PrintStream;

public abstract class Expr extends ASTNode {
    protected String type;
    protected String value;
    public Expr(Location loc) {
	super(loc);
    }
    public abstract void check(TableObj t);
}
