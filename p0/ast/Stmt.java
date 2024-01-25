package ast;
import java.io.PrintStream;

public abstract class Stmt extends ASTNode {
    public Stmt(Location loc) {
	super(loc);
    }
    public abstract void print(PrintStream ps);
}
