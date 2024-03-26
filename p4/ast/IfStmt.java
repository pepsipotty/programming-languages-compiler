package ast;
import java.io.PrintStream;
import java.util.HashMap;

public class IfStmt extends Stmt {
    public final CondExpr expr; 
    public final Stmt thenstmt, elsestmt;
    public IfStmt(CondExpr e, Stmt s, Location loc) {
	super(loc);
	expr = e;
	thenstmt = s;
	elsestmt = null;
    }
    public IfStmt(CondExpr e, Stmt s1, Stmt s2, Location loc) {
	super(loc);
	expr = e;
	thenstmt = s1;
	elsestmt = s2;
    }
    public void print(PrintStream ps, String indent) { 
	ps.print(indent + "if (");
	expr.print(ps);
	ps.print(")\n");
	thenstmt.print(ps, indent+"  ");
	if (elsestmt != null) {
	    ps.print("\n" + indent + "else\n");	    
	    elsestmt.print(ps, indent + "  ");
	}
    }
    public void print(PrintStream ps) {     
	print(ps,"");
    }

	public void execute() {

		table.newState(); // create s1
		thenstmt.execute(); //execute the then block on state s. We don't need to create a temporary state. We modify the OG state directly
		HashMap<String, AbstractValue> s1 = table.getTempState(); //get the state s1
		table.abortTempState(); //abort the temporary state s1, we've made a copy of it and don't need it anymore

		table.newState(); //create a new state, s2 for the else statement to operate on
		elsestmt.execute(); // everything here is operating on the new state, s2, and not the original state s1. 
		HashMap<String, AbstractValue> s2 = table.getTempState(); //get the state s2
		table.abortTempState();

		table.mergeState(s1, s2); //merge the two states together, s2 and s to get the final state. After merge, s2 is deleted and we revert back to the OG state s




    }
}
