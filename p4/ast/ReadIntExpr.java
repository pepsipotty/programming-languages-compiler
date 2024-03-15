package ast;
import java.io.PrintStream;

import ast.Expr;
import interpreter.Interpreter;
public class ReadIntExpr extends Expr {
    public ReadIntExpr(Location loc) {
	super(loc);
    }
    public void print(PrintStream ps) {
	ps.print("readint");
    }

    public Number evaluate() {
        long value;
        if (table.s.hasNextInt()) {
            value = table.s.nextInt();
        } else {
            Interpreter.fatalError("EXIT_FAILED_STDIN_READ_INT", 5);
            value = 0;
        }
        return value;
    }
}
