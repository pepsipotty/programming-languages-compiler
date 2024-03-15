package ast;
import java.io.PrintStream;
import interpreter.Interpreter;

public class CompExpr extends CondExpr {
    public static final int GE = 1;
    public static final int GT = 2;
    public static final int LE = 3;
    public static final int LT = 4;
    public static final int EQ = 5;
    public static final int NE = 6;
    public final Expr expr1, expr2;
    public final int op;

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
		// AbstractValue expr1Value = expr1.evaluate(); // 1
		// AbstractValue expr2Value = expr2.evaluate(); // 2
		// boolean typeIsLong = expr1Value instanceof Long ? true : false; //true is integer, false is float
		// boolean typeIsDouble = !typeIsLong;
		// boolean value = false;
		// switch (op) {
		// 	case GE: 
		// 	if (typeIsLong) {
		// 		value = expr1Value.longValue() >= expr2Value.longValue();
		// 		break;
		// 	} else if (typeIsDouble) {
		// 		value = expr1Value.doubleValue() >= expr2Value.doubleValue();
		// 		break;
		// 	}
		// 	case GT:
		// 	if (typeIsLong) {
		// 		value = expr1Value.longValue() > expr2Value.longValue();
		// 		break;
		// 	} else if (typeIsDouble) {
		// 		value = expr1Value.doubleValue() > expr2Value.doubleValue();
		// 		break;
		// 	}
		// 	case LE:
		// 	if (typeIsLong) {
		// 		value = expr1Value.longValue() <= expr2Value.longValue();
		// 		break;
		// 	} else if (typeIsDouble) {
		// 		value = expr1Value.doubleValue() <= expr2Value.doubleValue();
		// 		break;
		// 	}
		// 	case LT:
		// 	if (typeIsLong) {
		// 		value = expr1Value.longValue() < expr2Value.longValue();
		// 		break;
		// 	} else if (typeIsDouble) {
		// 		value = expr1Value.doubleValue() < expr2Value.doubleValue();
		// 		break;
		// 	}
		// 	case EQ:
		// 	if (typeIsLong) {
		// 		value = expr1Value.longValue() == expr2Value.longValue();
		// 		break;
		// 	} else if (typeIsDouble) {
		// 		value = expr1Value.doubleValue() == expr2Value.doubleValue();
		// 		break;
		// 	}
		// 	case NE:
		// 	if (typeIsLong) {
		// 		value = expr1Value.longValue() != expr2Value.longValue();
		// 		break;
		// 	} else if (typeIsDouble) {
		// 		value = expr1Value.doubleValue() != expr2Value.doubleValue();
		// 		break;
		// 	}
		// }
		return true;
    }

}
