package ast;
import java.io.PrintStream;

public class Program extends ASTNode {
    public final StmtList stmtList;
    public Program(StmtList sl, Location loc) {
        super(loc);
        stmtList = sl;
    }
    public void print(PrintStream ps) {
	stmtList.print(ps);
	ps.println();
    }
}
