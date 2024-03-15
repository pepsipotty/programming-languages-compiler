package ast;
import java.io.PrintStream;
import interpreter.Interpreter;

public class IdentExpr extends Expr {
    public final String ident; 
    public IdentExpr(String i, Location loc) {
	super(loc);
	ident = i;
    }
    public void print(PrintStream ps) {
	ps.print(ident);
    }

    public AbstractValue evaluate() {
        if (table.get(ident) != null) {
            return table.get(ident);
        } else {
            Interpreter.fatalError("Uninitialized Variable: " + ident, Interpreter.EXIT_UNINITIALIZED_VAR_ERROR);
            return AbstractValue.AnyInt;
        }
    }
}
