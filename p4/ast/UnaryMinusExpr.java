package ast;
import java.io.PrintStream;

public class UnaryMinusExpr extends Expr {
    public final Expr expr;
    
    public UnaryMinusExpr(Expr e, Location loc) {
	super(loc);
	expr = e; 
    }
    public void print(PrintStream ps) {
	ps.print("-(");
	expr.print(ps);
	ps.print(")");
    }

    public AbstractValue evaluate() {
        AbstractValue exprValue = expr.evaluate();
        
        switch (exprValue) {
            case PosInt:
                return AbstractValue.NegInt;
            case NegInt:
                return AbstractValue.PosInt;
            case ZeroInt:
                return AbstractValue.ZeroInt;
            case PosFloat:
                return AbstractValue.NegFloat;
            case NegFloat:
                return AbstractValue.PosFloat;
            case ZeroFloat:
                return AbstractValue.ZeroFloat;
            case AnyInt:
                return AbstractValue.AnyInt;
            case AnyFloat:
                return AbstractValue.AnyFloat;
            default:
                return exprValue;
        }
    }
}
