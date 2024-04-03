package ast;
import java.io.PrintStream;
import interpreter.Interpreter;
import java.util.HashMap;

public class WhileStmt extends Stmt {
    public final CondExpr expr;
    public final Stmt body;
    public WhileStmt(CondExpr e, Stmt s, Location loc) {
	super(loc);
	expr = e;
	body = s;
    // execute();
    }
    public void print(PrintStream ps, String indent) { 
	ps.print(indent + "while (");
	expr.print(ps);
	ps.print(")\n");
	body.print(ps, indent + "  ");
    }
    public void print(PrintStream ps) {     
	print(ps,"");
    }

    public void execute() {


        boolean needToMerge = false;
        AbstractValue cond = expr.evaluate();

        // case 1: statically guaranteed to be false; loop body is dead code
        if (cond == AbstractValue.False) {
            Interpreter.fatalError("EXIT_DEAD_CODE: while cond evaluated to: " + expr.evaluate(), Interpreter.EXIT_DEAD_CODE);
        }

        // case 2: statically guaranteed to be true; at least one iteration;
        // modify the state for one iteration and continue with general case
        if (cond == AbstractValue.True) {

            if (needToMerge) {

                HashMap<String, AbstractValue> s0 = new HashMap<>(table.getOriginalState()); // create copy of original state
                
                body.execute();

                HashMap<String, AbstractValue> s1 = new HashMap<>(table.getOriginalState());

                HashMap<String, AbstractValue> mergedState = table.mergeStateWhile(s0, s1);

                table.setOriginalState(mergedState);

            } else {

                body.execute();

            }
        }


        HashMap<String, AbstractValue> previousMerge = new HashMap<>(table.getOriginalState()); 
        HashMap<String, AbstractValue> currentMerge;

        while (true) {
            
            body.execute();
            currentMerge = new HashMap<>(table.mergeStateWhile(previousMerge, table.getOriginalState()));

            if (currentMerge.equals(previousMerge)) {

                table.setOriginalState(currentMerge);

                break;

            } else {

                previousMerge = currentMerge;

                table.setOriginalState(currentMerge);

            }

        }

    }
}
