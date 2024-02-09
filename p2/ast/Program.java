package ast;
import java.io.PrintStream;

public class Program extends ASTNode {
    public final UnitList unitList;
    public static TableObj rootTable = new TableObj();
    public Program(UnitList ul, Location loc) {
        super(loc);
        unitList = ul;
        check(rootTable);
    }
    public void print(PrintStream ps) {
	unitList.print(ps,"");
    }

    private void check(TableObj table) {
        unitList.check(table);
    }
}
