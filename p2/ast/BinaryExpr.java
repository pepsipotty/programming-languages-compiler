package ast;
import java.io.PrintStream;

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

	public void check(TableObj table) {
		expr1.check(table);
		expr2.check(table);

		if (!expr1.type.equals(expr2.type)) {
			Interpreter.fatalError("Error - Binary expression type mismatch: " + 
			expr1.value + "(" + expr1.type + ")"+
			" and " + 
			expr2.value + "(" + expr2.type + ")",
			2);
		} else {
			type = expr1.type;
		}
	}
}
