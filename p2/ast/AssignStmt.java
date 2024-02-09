package ast;
import java.io.PrintStream;
import interpreter.Interpreter;

public class AssignStmt extends Stmt {
    public final String ident;
    public final Expr expr;
    public AssignStmt(String i, Expr e, Location loc) {
	super(loc);
	ident = i;
	expr = e;
    }
    public void print(PrintStream ps, String indent) { 
	ps.print(indent + ident + " = ");
	expr.print(ps);
	ps.print(";");
    }
    public void print(PrintStream ps) {     
	print(ps,"");
    }

    public void check(TableObj table) {
        expr.check(table);
        TableObj current = table;

        while (current != null && !current.isDeclared(ident)) {
            current = current.getParent();
        }

        if (current == null) {
            Interpreter.fatalError("Error - Variable must be declared before use: " + ident, 2);
        } else {

            if (current.get(ident) != expr.type) {
                Interpreter.fatalError("Error - Type mismatch: " + ident, 2);
            }
        }
    }

}
