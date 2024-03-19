package ast;
import java.io.PrintStream;
import interpreter.Interpreter;

public class WhileStmt extends Stmt {
    public final CondExpr expr;
    public final Stmt body;
    public WhileStmt(CondExpr e, Stmt s, Location loc) {
	super(loc);
	expr = e;
	body = s;
    // execute();
    }
    public void print(PrintStream ps, String indent) { 
	ps.print(indent + "while (");
	expr.print(ps);
	ps.print(")\n");
	body.print(ps, indent + "  ");
    }
    public void print(PrintStream ps) {     
	print(ps,"");
    }

    public void execute() {
        while (expr.evaluate() == true) {
            body.execute();
        }
    }

    //jsut check if the new state and the old state are the same. Operative difference
}
