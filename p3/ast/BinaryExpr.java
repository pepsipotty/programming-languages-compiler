package ast;
import java.io.PrintStream;
import java.util.function.BiFunction;
import interpreter.Interpreter;

public class BinaryExpr extends Expr {
    public static final int PLUS = 1;
    public static final int MINUS = 2;
    public static final int TIMES = 3;
    public static final int DIV = 4;
    public final Expr expr1, expr2;
    public final int op;
	public enum NumberType {
		INTEGER,
		FLOAT,
		OTHER
	}

    public BinaryExpr(Expr e1, int oper, Expr e2, Location loc) {
	super(loc);
	expr1 = e1; 
	expr2 = e2;
	op = oper;
    }
    public void print(PrintStream ps) {
	ps.print("(");
	expr1.print(ps);
	switch (op) {
	case PLUS: ps.print("+"); break;
	case MINUS: ps.print("-"); break;
	case TIMES: ps.print("*"); break;
	case DIV: ps.print("/"); break;
	}
	expr2.print(ps);
	ps.print(")");
    }

	public Number evaluate() {
		// NumberType type = numberType(expr1);
		BiFunction<Number, Number, Number> operation = null;

		Number expr1Value = expr1.evaluate(); // 1
		Number expr2Value = expr2.evaluate(); // 2

		switch (op) {
			case PLUS:
				operation = (expr1Value instanceof Long) ?
					(a, b) -> a.longValue() + b.longValue() :
					(a, b) -> a.doubleValue() + b.doubleValue();
				break;
			case MINUS:
				operation = (expr1Value instanceof Long) ?
					(a, b) -> a.longValue() - b.longValue() :
					(a, b) -> a.doubleValue() - b.doubleValue();
				break;
			case TIMES:
				operation = (expr1Value instanceof Long) ?
					(a, b) -> a.longValue() * b.longValue() :
					(a, b) -> a.doubleValue() * b.doubleValue();
				break;
			case DIV:
				if (expr2Value.doubleValue() != 0) {
					operation = (expr1Value instanceof Long) ?
					(a, b) -> a.longValue() / b.longValue() :
					(a, b) -> a.doubleValue() / b.doubleValue();
				break;
				} else {
					Interpreter.fatalError("EXIT_DIV_BY_ZERO", Interpreter.EXIT_DIV_BY_ZERO_ERROR);
				}

		}

		return operation.apply(expr1Value, expr2Value);
	}
		
	
}
