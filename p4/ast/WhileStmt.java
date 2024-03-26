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
        while (true) {
            body.execute();
            currentMerge = new HashMap<>(table.mergeStateWhile(previousMerge, table.getOriginalState()));

            if (currentMerge.equals(previousMerge)) {
                table.setOriginalState(currentMerge);
                break;
            } else {
                previousMerge = currentMerge;
            }
        }

    }
}
