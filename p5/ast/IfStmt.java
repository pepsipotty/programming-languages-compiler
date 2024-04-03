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
		if (elsestmt == null) {
			HashMap<String, AbstractValue> s0 = new HashMap<>(table.getOriginalState());
			thenstmt.execute();
			HashMap<String, AbstractValue> s1 = new HashMap<>(table.getOriginalState());
			HashMap<String, AbstractValue> mergedState =  table.mergeStateWhile(s0, s1);
			table.setOriginalState(mergedState);
		} else {
			HashMap<String, AbstractValue> s0 = new HashMap<>(table.getOriginalState());
			thenstmt.execute();
			HashMap<String, AbstractValue> s1 = new HashMap<>(table.getOriginalState());
			
			table.setOriginalState(s0);
			elsestmt.execute();
			HashMap<String, AbstractValue> s2 = new HashMap<>(table.getOriginalState());
			HashMap<String, AbstractValue> mergedState =  table.mergeStateWhile(s1, s2);
			table.setOriginalState(mergedState);
		}

    }
}
