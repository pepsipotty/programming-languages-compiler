package ast;
import java.io.PrintStream;

public class CompExpr extends CondExpr {
    public static final int GE = 1;
    public static final int GT = 2;
    public static final int LE = 3;
    public static final int LT = 4;
    public static final int EQ = 5;
    public static final int NE = 6;
    public final Expr expr1, expr2;
    public final int op;
	public enum NumberType {
		INTEGER,
		FLOAT,
		OTHER
	}

    public CompExpr(Expr e1, int oper, Expr e2, Location loc) {
	super(loc);
	expr1 = e1; 
	expr2 = e2;
	op = oper;
    }
    public void print(PrintStream ps) {
	ps.print("(");
	expr1.print(ps);
	switch (op) { 
	case GE: ps.print(">="); break;
	case GT: ps.print(">"); break;
	case LE: ps.print("<="); break;
	case LT: ps.print("<"); break;
	case EQ: ps.print("=="); break;
	case NE: ps.print("!="); break;
	}
	expr2.print(ps);
	ps.print(")");
    }

	public boolean evaluate() {
        NumberType type = numberType(expr1);
		boolean value = false;
		switch (op) {
			case GE: 
			if (type == NumberType.INTEGER) {
				value = expr1.evaluate().longValue() >= expr2.evaluate().longValue();
				break;
			} else if (type == NumberType.FLOAT) {
				value = expr1.evaluate().doubleValue() >= expr2.evaluate().doubleValue();
				break;
			}
			case GT:
			if (type == NumberType.INTEGER) {
				value = expr1.evaluate().longValue() > expr2.evaluate().longValue();
				break;
			} else if (type == NumberType.FLOAT) {
				value = expr1.evaluate().doubleValue() > expr2.evaluate().doubleValue();
				break;
			}
			case LE:
			if (type == NumberType.INTEGER) {
				value = expr1.evaluate().longValue() <= expr2.evaluate().longValue();
				break;
			} else if (type == NumberType.FLOAT) {
				value = expr1.evaluate().doubleValue() <= expr2.evaluate().doubleValue();
				break;
			}
			case LT:
			if (type == NumberType.INTEGER) {
				value = expr1.evaluate().longValue() < expr2.evaluate().longValue();
				break;
			} else if (type == NumberType.FLOAT) {
				value = expr1.evaluate().doubleValue() < expr2.evaluate().doubleValue();
				break;
			}
			case EQ:
			if (type == NumberType.INTEGER) {
				value = expr1.evaluate().longValue() == expr2.evaluate().longValue();
				break;
			} else if (type == NumberType.FLOAT) {
				value = expr1.evaluate().doubleValue() == expr2.evaluate().doubleValue();
				break;
			}
			case NE:
			if (type == NumberType.INTEGER) {
				value = expr1.evaluate().longValue() != expr2.evaluate().longValue();
				break;
			} else if (type == NumberType.FLOAT) {
				value = expr1.evaluate().doubleValue() != expr2.evaluate().doubleValue();
				break;
			}
		}
		return value;
    }
	
	public NumberType numberType(Expr expr) {
		Number result = expr.evaluate();
		if (result instanceof Double) {
			return NumberType.FLOAT;
		} else if (result instanceof Long) {
			return NumberType.INTEGER;
		} else {
			return NumberType.OTHER;
		}
	}
}
