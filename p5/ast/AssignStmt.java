package ast;
import java.io.PrintStream;

public class AssignStmt extends Stmt {
    public final String ident;
    public final Expr expr;
    public AssignStmt(String i, Expr e, Location loc) {
	super(loc);
	ident = i;
	expr = e;
    // execute();
    }
    public void print(PrintStream ps, String indent) { 
	ps.print(indent + ident + " = ");
	expr.print(ps);
	ps.print(";");
    }
    public void print(PrintStream ps) {     
	print(ps,"");
    }

    public void execute() {
        table.add(ident, expr.evaluate());
    }

    // public void execute(HashMap<String, AbstractValue> table) {
    //     table.add(ident, expr.evaluate(table));
    // }
}
