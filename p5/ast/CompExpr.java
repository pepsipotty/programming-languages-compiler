package ast;
import java.io.PrintStream;
import interpreter.Interpreter;
import java.util.HashMap;
import ast.CompOperation;

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

	public AbstractValue evaluate() {
		AbstractValue expr1Value = expr1.evaluate(); // 1
		AbstractValue expr2Value = expr2.evaluate(); // 2
		boolean typeIsLong = (expr1Value == AbstractValue.AnyInt || expr1Value == AbstractValue.PosInt || expr1Value ==  AbstractValue.NegInt) ? true : false; //true is integer, false is float
		boolean typeIsDouble = !typeIsLong;
		// boolean value = false;
		AbstractValue value = AbstractValue.False;
		switch (op) {
			case GE: 
				value = OperationMappings.getResult(expr1Value, expr2Value, CompOperation.GE);
				break;
			case GT:
				value = OperationMappings.getResult(expr1Value, expr2Value, CompOperation.GT);
				break;
			case LE:
				value = OperationMappings.getResult(expr1Value, expr2Value, CompOperation.LE);
				break;
			case LT:
				value = OperationMappings.getResult(expr1Value, expr2Value, CompOperation.LT);
				break;
			case EQ:
				value = OperationMappings.getResult(expr1Value, expr2Value, CompOperation.EQ);
				break;
			case NE:
				value = OperationMappings.getResult(expr1Value, expr2Value, CompOperation.NE);
				break;
		}
		return value;
    }

}
