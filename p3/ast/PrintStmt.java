package ast;
import java.io.PrintStream;

public class PrintStmt extends Stmt {
    public final Expr expr;
    public PrintStmt(Expr e, Location loc) {
	super(loc);
	expr = e;
    execute();  
    }
    public void print(PrintStream ps, String indent) { 
	ps.print(indent + "print ");
	expr.print(ps);
	ps.print(";");
    }
    public void print(PrintStream ps) { 
	print(ps,"");
    }

    public void execute() {
        System.out.println(expr.evaluate());
    }
}
