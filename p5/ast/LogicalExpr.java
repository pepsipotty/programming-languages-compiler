package ast;
import java.io.PrintStream;
import ast.AbstractValue;

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

	public AbstractValue evaluate() {
		AbstractValue value = AbstractValue.False;
		switch (op) {
			case AND:
			// If true, then check the second expression 
				if (expr1.evaluate() == AbstractValue.True) {  // case 1

					value = expr2.evaluate();

				} else if (expr1.evaluate() == AbstractValue.False) { // case 2

					value = AbstractValue.False;

				} else if (expr1.evaluate() == AbstractValue.AnyBool) { // case 3

					value = OperationMappings.getResult(AbstractValue.AnyBool, expr2.evaluate(), LogicalOperation.AND);

				}

				break;
			case OR:
				 // Evaluate the first expression
				if (expr1.evaluate() == AbstractValue.False) { // If false, then only evaluate the second expression 

					value = expr2.evaluate();

				} else if (expr1.evaluate() == AbstractValue.True) { // If true, then value is true

					value = AbstractValue.True;

				} else if (expr1.evaluate() == AbstractValue.AnyBool) { // If the first expression is AnyBool, then the value is AnyBool

					value = OperationMappings.getResult(AbstractValue.AnyBool, expr2.evaluate(), LogicalOperation.OR);

				}
				
				break;
			case NOT:

				if (expr1.evaluate() == AbstractValue.True) { // If the expression is true, then the value is false

					value = AbstractValue.False;

				} else if (expr1.evaluate() == AbstractValue.False) { // If the expression is false, then the value is true

					value = AbstractValue.True;

				} else if (expr1.evaluate() == AbstractValue.AnyBool) { // If the expression is AnyBool, then the value is AnyBool

					value = AbstractValue.AnyBool;

				}

				break;
		}
		return value;
	}
	
}
