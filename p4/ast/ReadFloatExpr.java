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

    public AbstractValue evaluate() {
        // AbstractValue value;
        // if (table.s.hasNextFloat()) {
        //     value = AbstractValue.AnyFloat;
        // } else {
        //     Interpreter.fatalError("EXIT_FAILED_STDIN_READ_FLOAT", 5);
        //     value = 0;
        // }
        return AbstractValue.AnyFloat;
    }
}

//factorial function - recursive readint loops computes N factorial
//unintialized variables not necessarily need input files
