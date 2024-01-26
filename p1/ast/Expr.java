package ast;
import java.io.PrintStream;

//Type to store expression
public abstract class Expr extends ASTNode {
    public String type;
    public String value;
    public String identType;
    public Expr(Location loc) {
	super(loc);
    }
    public abstract void print(PrintStream ps);
}
