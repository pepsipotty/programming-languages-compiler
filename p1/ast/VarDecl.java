package ast;
import java.io.PrintStream;

public abstract class VarDecl extends ASTNode {
    public final String ident;
    protected String type;
    protected String value;
    public VarDecl(String i, Location loc) {
	super(loc);
	ident = i;
    }
    public abstract void print(PrintStream ps);
}
