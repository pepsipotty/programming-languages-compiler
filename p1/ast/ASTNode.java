package ast;
import java.io.PrintStream;

import java.util.List;
abstract class ASTNode {
    public final Location loc;
    Table table = Table.getInstance();
    ASTNode(Location loc) { this.loc = loc; }
    public abstract void print(PrintStream ps);
}
