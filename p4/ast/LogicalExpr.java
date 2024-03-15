package ast;
import java.io.PrintStream;

public class LogicalExpr extends CondExpr {
    public static final int AND = 1;
    public static final int OR = 2;
    public static final int NOT = 3;
    public final CondExpr expr1, expr2;
    public final int op;
    public LogicalExpr(CondExpr e1, int oper, CondExpr e2, Location loc) {
	super(loc);
	expr1 = e1; 
	expr2 = e2;
	op = oper;
    }
    public LogicalExpr(CondExpr e1, int oper, Location loc) {
	this(e1,oper,null,loc); // used for NOT
    }
    public void print(PrintStream ps) {
	if (op == NOT) {
	    ps.print("!(");
	    expr1.print(ps);
	    ps.print(")");
	    return;
	}
	ps.print("(");
	expr1.print(ps);
	switch (op) { 
	case AND: ps.print("&&"); break;
	case OR: ps.print("||"); break;
	}
	expr2.print(ps);
	ps.print(")");
    }

	public boolean evaluate() {
		boolean value = false;
		switch (op) {
			case AND:
				value = expr1.evaluate(); // Evaluate the first expression
				if (value) { // If true, then check the second expression
					value = expr2.evaluate();
				}
				// If the first expression is false, value remains false (short-circuit)
				break;
			case OR:
				value = expr1.evaluate(); // Evaluate the first expression
				if (!value) { // If false, then only evaluate the second expression
					value = expr2.evaluate();
				}
				// If the first expression is true, value remains true (short-circuit)
				break;
			case NOT:
				value = !expr1.evaluate();
				break;
		}
		return value;
	}
	
}
