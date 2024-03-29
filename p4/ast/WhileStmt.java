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
        HashMap<String, AbstractValue> previousMerge = new HashMap<>(table.getOriginalState()); 
        HashMap<String, AbstractValue> currentMerge;
        // System.out.println("Initial State(sigmaPrimeZero): " + table.getOriginalState());
        // table.getEntries();
        int x = 1;
        while (true) {
            // System.out.println("Iteration " + x);
            body.execute();
            // System.out.println("State after iteration " + x + ": " + table.getOriginalState());
            currentMerge = new HashMap<>(table.mergeStateWhile(previousMerge, table.getOriginalState()));

            // System.out.println("currentMerge for iteration " + x + ": " + currentMerge);
            if (currentMerge.equals(previousMerge)) {
                // System.out.println("Convergence at: " + x);
                // System.out.println("Final State: " + currentMerge);
                table.setOriginalState(currentMerge);
                break;
            } else {
                previousMerge = currentMerge;
                table.setOriginalState(currentMerge);
            }
            x++;
        }
        // System.out.println("Final State: " + table.getOriginalState());
        

    }
}
