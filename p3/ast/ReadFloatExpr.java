package ast;
import java.io.PrintStream;
import interpreter.Interpreter;
public class ReadFloatExpr extends Expr {
    public ReadFloatExpr(Location loc) {
	super(loc);
    }
    public void print(PrintStream ps) {
	ps.print("readfloat");
    }

    public Number evaluate() {
        double value;
        if (table.s.hasNextFloat()) {
            value = table.s.nextFloat();
        } else {
            Interpreter.fatalError("EXIT_FAILED_STDIN_READ_FLOAT", 5);
            value = 0;
        }
        return value;
    }
}

//factorial function - recursive readint loops computes N factorial
//unintialized variables not necessarily need input files
