package ast;
import java.io.PrintStream;
import java.util.function.BinaryOperator;
import java.util.function.BiFunction;
import interpreter.Interpreter;

public class BinaryExpr extends Expr {
    public static final int PLUS = 1;
    public static final int MINUS = 2;
    public static final int TIMES = 3;
    public static final int DIV = 4;
    public final Expr expr1, expr2;
    public final int op;

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

	public AbstractValue evaluate() {
		AbstractValue expr1Value = expr1.evaluate(); // 1
		AbstractValue expr2Value = expr2.evaluate(); // 2
		AbstractValue result;

		switch (op) {
			case PLUS:
				result = OperationMappings.getResult(expr1Value, expr2Value, BinaryOperation.PLUS);
				break;
			case MINUS:
				result = OperationMappings.getResult(expr1Value, expr2Value, BinaryOperation.MINUS);
				break;
			case TIMES:
				result = OperationMappings.getResult(expr1Value, expr2Value, BinaryOperation.TIMES);
				break;
			case DIV:
				if (expr2Value == AbstractValue.ZeroInt || expr2Value == AbstractValue.ZeroFloat || expr2Value == AbstractValue.AnyInt || expr2Value == AbstractValue.AnyFloat) {
					Interpreter.fatalError("EXIT_DIV_BY_ZERO", Interpreter.EXIT_DIV_BY_ZERO_ERROR);
					result = AbstractValue.AnyInt;
				} else {
					result = OperationMappings.getResult(expr1Value, expr2Value, BinaryOperation.DIV);
				}
				break;

			default: 
				result = AbstractValue.AnyInt;
				break;
		}

		return result;
	}












	// public AbstractValue abstractAdd(AbstractValue value1, AbstractValue value2) {
	// 	if (abstractValueIsLong(value1) && abstractValueIsLong(value2)) {
	// 		//long
	// 		if ((value1 === AbstractValue.AnyInt) || (value2 === AbstractValue.AnyInt))
	// 			return AbstractValue.AnyInt;
	// 		else if ((value1 === AbstractValue.PosInt) && (value2 === AbstractValue.PosInt))
	// 			return AbstractValue.PosInt;
	// 		else if ((value1 === AbstractValue.NegInt) && (value2 === AbstractValue.NegInt))
	// 			return AbstractValue.NegInt;
	// 		else if ((value1 === AbstractValue.ZeroInt) && (value2 === AbstractValue.ZeroInt))
	// 			return AbstractValue.ZeroInt;
	// 		else
	// 			return AbstractValue.AnyInt;
	// 	} else {
	// 		//float
	// 		return AbstractValue.AnyFloat;
	// 	}
	// }

	// public boolean abstractValueIsLong(AbstractValue value) {
	// 	if ((value === AbstractValue.AnyInt) || (value === AbstractValue.PosInt) || (value === AbstractValue.NegInt) || (value === AbstractValue.ZeroInt)) {
	// 		return true;
	// 	} else {
	// 		return false;
	// 	}
	// }
		
	
}
