package ast;
import java.io.PrintStream;
import java.util.*;

public class Program extends ASTNode {
    public final UnitList unitList;
    public Program(UnitList ul, Location loc) {
        super(loc);
        unitList = ul;
        check();
    }
    public void print(PrintStream ps) {
	unitList.print(ps,"");
    }

    private void check() {
        unitList.check();
    }
}
