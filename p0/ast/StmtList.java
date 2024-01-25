package ast;
import java.io.PrintStream;

public class StmtList extends ASTNode {
    public final Stmt stmt;
    public final StmtList stmtList; 
    public StmtList(Stmt s, StmtList sl, Location loc) {
        super(loc);
	stmt = s;
	stmtList = sl;
    }
    public StmtList(Stmt s, Location loc) { 
        super(loc);
	stmt = s;
        stmtList = null;
    }
    public void print(PrintStream ps) {
	stmt.print(ps);
	ps.print(";\n");
	if (stmtList != null) stmtList.print(ps);
    }
}
