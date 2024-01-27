package ast;
import java.io.PrintStream;
import interpreter.Interpreter;

//Check the two child expressions and compare types 

public class PlusExpr extends Expr {
    public final Expr expr1, expr2;
    public PlusExpr(Expr e1, Expr e2, Location loc) {
	super(loc);
	expr1 = e1; 
	expr2 = e2;

	type = expr1.type;
	value = "(" + expr1.value + " + " + expr2.value + ")";
	typeCheck();
    }
    public void print(PrintStream ps) {
	ps.print("(");
	expr1.print(ps);
	ps.print("+");
	expr2.print(ps);
	ps.print(")");
    }

	private void typeCheck() {
		if (!expr1.type.equals(expr2.type)) {
			Interpreter.fatalError("Error - Plus operand type mismatch: " + 
			expr1.value + "(" + expr1.type + ")"+
			" and " + 
			expr2.value + "(" + expr2.type + ")",
			2);
		} 
	}
}
