package ast;
import java.io.PrintStream;
import interpreter.Interpreter;

public class IdentExpr extends Expr {
    public int counter = 0;
    public final String ident; 
    public IdentExpr(String i, Location loc) {
	super(loc);
    // System.out.println("Enter IdentExpr");
	ident = i;
    value = ident;
    }
    public void print(PrintStream ps) {
	ps.print(ident);
    }

    public void check(TableObj table) {
        TableObj current = table;
        while (current != null && !current.isDeclared(ident)) {
            current = current.getParent();
        }
    
        if (current == null) {
            Interpreter.fatalError("Error - Variable must be declared before use: " + ident, 2);
        } else {
            type = current.get(ident);
        }
    }


}
