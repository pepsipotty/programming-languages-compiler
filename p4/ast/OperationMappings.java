package ast;
import ast.AbstractValue;
import ast.OperationKey;
import ast.BinaryOperation;
import java.util.Map;
import java.util.HashMap;

public class OperationMappings {
    private static final Map<OperationKey, AbstractValue> operationResults = new HashMap<>();

    static {
        // Mapping for PLUS operation
        //INT
        operationResults.put(new OperationKey(AbstractValue.NegInt, AbstractValue.NegInt, BinaryOperation.PLUS), AbstractValue.NegInt);
        operationResults.put(new OperationKey(AbstractValue.NegInt, AbstractValue.ZeroInt, BinaryOperation.PLUS), AbstractValue.NegInt);
        operationResults.put(new OperationKey(AbstractValue.NegInt, AbstractValue.PosInt, BinaryOperation.PLUS), AbstractValue.AnyInt);
        operationResults.put(new OperationKey(AbstractValue.NegInt, AbstractValue.AnyInt, BinaryOperation.PLUS), AbstractValue.AnyInt);

        operationResults.put(new OperationKey(AbstractValue.ZeroInt, AbstractValue.NegInt, BinaryOperation.PLUS), AbstractValue.NegInt);
        operationResults.put(new OperationKey(AbstractValue.ZeroInt, AbstractValue.ZeroInt, BinaryOperation.PLUS), AbstractValue.ZeroInt);
        operationResults.put(new OperationKey(AbstractValue.ZeroInt, AbstractValue.PosInt, BinaryOperation.PLUS), AbstractValue.PosInt);
        operationResults.put(new OperationKey(AbstractValue.ZeroInt, AbstractValue.AnyInt, BinaryOperation.PLUS), AbstractValue.AnyInt);

        operationResults.put(new OperationKey(AbstractValue.PosInt, AbstractValue.NegInt, BinaryOperation.PLUS), AbstractValue.AnyInt);
        operationResults.put(new OperationKey(AbstractValue.PosInt, AbstractValue.ZeroInt, BinaryOperation.PLUS), AbstractValue.PosInt);
        operationResults.put(new OperationKey(AbstractValue.PosInt, AbstractValue.PosInt, BinaryOperation.PLUS), AbstractValue.PosInt);
        operationResults.put(new OperationKey(AbstractValue.PosInt, AbstractValue.AnyInt, BinaryOperation.PLUS), AbstractValue.AnyInt);

        operationResults.put(new OperationKey(AbstractValue.AnyInt, AbstractValue.NegInt, BinaryOperation.PLUS), AbstractValue.AnyInt);
        operationResults.put(new OperationKey(AbstractValue.AnyInt, AbstractValue.ZeroInt, BinaryOperation.PLUS), AbstractValue.AnyInt);
        operationResults.put(new OperationKey(AbstractValue.AnyInt, AbstractValue.PosInt, BinaryOperation.PLUS), AbstractValue.AnyInt);
        operationResults.put(new OperationKey(AbstractValue.AnyInt, AbstractValue.AnyInt, BinaryOperation.PLUS), AbstractValue.AnyInt);
        //FLOAT
        operationResults.put(new OperationKey(AbstractValue.NegFloat, AbstractValue.NegFloat, BinaryOperation.PLUS), AbstractValue.NegFloat);
        operationResults.put(new OperationKey(AbstractValue.NegFloat, AbstractValue.ZeroFloat, BinaryOperation.PLUS), AbstractValue.NegFloat);
        operationResults.put(new OperationKey(AbstractValue.NegFloat, AbstractValue.PosFloat, BinaryOperation.PLUS), AbstractValue.AnyFloat);
        operationResults.put(new OperationKey(AbstractValue.NegFloat, AbstractValue.AnyFloat, BinaryOperation.PLUS), AbstractValue.AnyFloat);

        operationResults.put(new OperationKey(AbstractValue.ZeroFloat, AbstractValue.NegFloat, BinaryOperation.PLUS), AbstractValue.NegFloat);
        operationResults.put(new OperationKey(AbstractValue.ZeroFloat, AbstractValue.ZeroFloat, BinaryOperation.PLUS), AbstractValue.ZeroFloat);
        operationResults.put(new OperationKey(AbstractValue.ZeroFloat, AbstractValue.PosFloat, BinaryOperation.PLUS), AbstractValue.PosFloat);
        operationResults.put(new OperationKey(AbstractValue.ZeroFloat, AbstractValue.AnyFloat, BinaryOperation.PLUS), AbstractValue.AnyFloat);

        operationResults.put(new OperationKey(AbstractValue.PosFloat, AbstractValue.NegFloat, BinaryOperation.PLUS), AbstractValue.AnyFloat);
        operationResults.put(new OperationKey(AbstractValue.PosFloat, AbstractValue.ZeroFloat, BinaryOperation.PLUS), AbstractValue.PosFloat);
        operationResults.put(new OperationKey(AbstractValue.PosFloat, AbstractValue.PosFloat, BinaryOperation.PLUS), AbstractValue.PosFloat);
        operationResults.put(new OperationKey(AbstractValue.PosFloat, AbstractValue.AnyFloat, BinaryOperation.PLUS), AbstractValue.AnyFloat);

        operationResults.put(new OperationKey(AbstractValue.AnyFloat, AbstractValue.NegFloat, BinaryOperation.PLUS), AbstractValue.AnyFloat);
        operationResults.put(new OperationKey(AbstractValue.AnyFloat, AbstractValue.ZeroFloat, BinaryOperation.PLUS), AbstractValue.AnyFloat);
        operationResults.put(new OperationKey(AbstractValue.AnyFloat, AbstractValue.PosFloat, BinaryOperation.PLUS), AbstractValue.AnyFloat);
        operationResults.put(new OperationKey(AbstractValue.AnyFloat, AbstractValue.AnyFloat, BinaryOperation.PLUS), AbstractValue.AnyFloat);

        // Mapping for MINUS operation
        //INT
        operationResults.put(new OperationKey(AbstractValue.NegInt, AbstractValue.NegInt, BinaryOperation.MINUS), AbstractValue.AnyInt);
        operationResults.put(new OperationKey(AbstractValue.NegInt, AbstractValue.ZeroInt, BinaryOperation.MINUS), AbstractValue.NegInt);
        operationResults.put(new OperationKey(AbstractValue.NegInt, AbstractValue.PosInt, BinaryOperation.MINUS), AbstractValue.NegInt);
        operationResults.put(new OperationKey(AbstractValue.NegInt, AbstractValue.AnyInt, BinaryOperation.MINUS), AbstractValue.AnyInt);

        operationResults.put(new OperationKey(AbstractValue.ZeroInt, AbstractValue.NegInt, BinaryOperation.MINUS), AbstractValue.PosInt);
        operationResults.put(new OperationKey(AbstractValue.ZeroInt, AbstractValue.ZeroInt, BinaryOperation.MINUS), AbstractValue.ZeroInt);
        operationResults.put(new OperationKey(AbstractValue.ZeroInt, AbstractValue.PosInt, BinaryOperation.MINUS), AbstractValue.NegInt);
        operationResults.put(new OperationKey(AbstractValue.ZeroInt, AbstractValue.AnyInt, BinaryOperation.MINUS), AbstractValue.AnyInt);

        operationResults.put(new OperationKey(AbstractValue.PosInt, AbstractValue.NegInt, BinaryOperation.MINUS), AbstractValue.PosInt);
        operationResults.put(new OperationKey(AbstractValue.PosInt, AbstractValue.ZeroInt, BinaryOperation.MINUS), AbstractValue.PosInt);
        operationResults.put(new OperationKey(AbstractValue.PosInt, AbstractValue.PosInt, BinaryOperation.MINUS), AbstractValue.AnyInt);
        operationResults.put(new OperationKey(AbstractValue.PosInt, AbstractValue.AnyInt, BinaryOperation.MINUS), AbstractValue.AnyInt);

        operationResults.put(new OperationKey(AbstractValue.AnyInt, AbstractValue.NegInt, BinaryOperation.MINUS), AbstractValue.AnyInt);
        operationResults.put(new OperationKey(AbstractValue.AnyInt, AbstractValue.ZeroInt, BinaryOperation.MINUS), AbstractValue.AnyInt);
        operationResults.put(new OperationKey(AbstractValue.AnyInt, AbstractValue.PosInt, BinaryOperation.MINUS), AbstractValue.AnyInt);
        operationResults.put(new OperationKey(AbstractValue.AnyInt, AbstractValue.AnyInt, BinaryOperation.MINUS), AbstractValue.AnyInt);
        //FLOAT
        operationResults.put(new OperationKey(AbstractValue.NegFloat, AbstractValue.NegFloat, BinaryOperation.MINUS), AbstractValue.AnyFloat);
        operationResults.put(new OperationKey(AbstractValue.NegFloat, AbstractValue.ZeroFloat, BinaryOperation.MINUS), AbstractValue.NegFloat);
        operationResults.put(new OperationKey(AbstractValue.NegFloat, AbstractValue.PosFloat, BinaryOperation.MINUS), AbstractValue.NegFloat);
        operationResults.put(new OperationKey(AbstractValue.NegFloat, AbstractValue.AnyFloat, BinaryOperation.MINUS), AbstractValue.AnyFloat);

        operationResults.put(new OperationKey(AbstractValue.ZeroFloat, AbstractValue.NegFloat, BinaryOperation.MINUS), AbstractValue.PosFloat);
        operationResults.put(new OperationKey(AbstractValue.ZeroFloat, AbstractValue.ZeroFloat, BinaryOperation.MINUS), AbstractValue.ZeroFloat);
        operationResults.put(new OperationKey(AbstractValue.ZeroFloat, AbstractValue.PosFloat, BinaryOperation.MINUS), AbstractValue.NegFloat);
        operationResults.put(new OperationKey(AbstractValue.ZeroFloat, AbstractValue.AnyFloat, BinaryOperation.MINUS), AbstractValue.AnyFloat);

        operationResults.put(new OperationKey(AbstractValue.PosFloat, AbstractValue.NegFloat, BinaryOperation.MINUS), AbstractValue.PosFloat);
        operationResults.put(new OperationKey(AbstractValue.PosFloat, AbstractValue.ZeroFloat, BinaryOperation.MINUS), AbstractValue.PosFloat);
        operationResults.put(new OperationKey(AbstractValue.PosFloat, AbstractValue.PosFloat, BinaryOperation.MINUS), AbstractValue.AnyFloat);
        operationResults.put(new OperationKey(AbstractValue.PosFloat, AbstractValue.AnyFloat, BinaryOperation.MINUS), AbstractValue.AnyFloat);

        operationResults.put(new OperationKey(AbstractValue.AnyFloat, AbstractValue.NegFloat, BinaryOperation.MINUS), AbstractValue.AnyFloat);
        operationResults.put(new OperationKey(AbstractValue.AnyFloat, AbstractValue.ZeroFloat, BinaryOperation.MINUS), AbstractValue.AnyFloat);
        operationResults.put(new OperationKey(AbstractValue.AnyFloat, AbstractValue.PosFloat, BinaryOperation.MINUS), AbstractValue.AnyFloat);
        operationResults.put(new OperationKey(AbstractValue.AnyFloat, AbstractValue.AnyFloat, BinaryOperation.MINUS), AbstractValue.AnyFloat);

        // Mapping for TIMES operation
        //INT
        operationResults.put(new OperationKey(AbstractValue.NegInt, AbstractValue.NegInt, BinaryOperation.TIMES), AbstractValue.PosInt);
        operationResults.put(new OperationKey(AbstractValue.NegInt, AbstractValue.ZeroInt, BinaryOperation.TIMES), AbstractValue.ZeroInt);
        operationResults.put(new OperationKey(AbstractValue.NegInt, AbstractValue.PosInt, BinaryOperation.TIMES), AbstractValue.NegInt);
        operationResults.put(new OperationKey(AbstractValue.NegInt, AbstractValue.AnyInt, BinaryOperation.TIMES), AbstractValue.AnyInt);
        
        operationResults.put(new OperationKey(AbstractValue.ZeroInt, AbstractValue.NegInt, BinaryOperation.TIMES), AbstractValue.ZeroInt);
        operationResults.put(new OperationKey(AbstractValue.ZeroInt, AbstractValue.ZeroInt, BinaryOperation.TIMES), AbstractValue.ZeroInt);
        operationResults.put(new OperationKey(AbstractValue.ZeroInt, AbstractValue.PosInt, BinaryOperation.TIMES), AbstractValue.ZeroInt);
        operationResults.put(new OperationKey(AbstractValue.ZeroInt, AbstractValue.AnyInt, BinaryOperation.TIMES), AbstractValue.ZeroInt);
        
        operationResults.put(new OperationKey(AbstractValue.PosInt, AbstractValue.NegInt, BinaryOperation.TIMES), AbstractValue.NegInt);
        operationResults.put(new OperationKey(AbstractValue.PosInt, AbstractValue.ZeroInt, BinaryOperation.TIMES), AbstractValue.ZeroInt);
        operationResults.put(new OperationKey(AbstractValue.PosInt, AbstractValue.PosInt, BinaryOperation.TIMES), AbstractValue.PosInt);
        operationResults.put(new OperationKey(AbstractValue.PosInt, AbstractValue.AnyInt, BinaryOperation.TIMES), AbstractValue.AnyInt);
        
        operationResults.put(new OperationKey(AbstractValue.AnyInt, AbstractValue.NegInt, BinaryOperation.TIMES), AbstractValue.AnyInt);
        operationResults.put(new OperationKey(AbstractValue.AnyInt, AbstractValue.ZeroInt, BinaryOperation.TIMES), AbstractValue.ZeroInt);
        operationResults.put(new OperationKey(AbstractValue.AnyInt, AbstractValue.PosInt, BinaryOperation.TIMES), AbstractValue.AnyInt);
        operationResults.put(new OperationKey(AbstractValue.AnyInt, AbstractValue.AnyInt, BinaryOperation.TIMES), AbstractValue.AnyInt);
        //FLOAT
        operationResults.put(new OperationKey(AbstractValue.NegFloat, AbstractValue.NegFloat, BinaryOperation.TIMES), AbstractValue.PosFloat);
        operationResults.put(new OperationKey(AbstractValue.NegFloat, AbstractValue.ZeroFloat, BinaryOperation.TIMES), AbstractValue.ZeroFloat);
        operationResults.put(new OperationKey(AbstractValue.NegFloat, AbstractValue.PosFloat, BinaryOperation.TIMES), AbstractValue.NegFloat);
        operationResults.put(new OperationKey(AbstractValue.NegFloat, AbstractValue.AnyFloat, BinaryOperation.TIMES), AbstractValue.AnyFloat);
        
        operationResults.put(new OperationKey(AbstractValue.ZeroFloat, AbstractValue.NegFloat, BinaryOperation.TIMES), AbstractValue.ZeroFloat);
        operationResults.put(new OperationKey(AbstractValue.ZeroFloat, AbstractValue.ZeroFloat, BinaryOperation.TIMES), AbstractValue.ZeroFloat);
        operationResults.put(new OperationKey(AbstractValue.ZeroFloat, AbstractValue.PosFloat, BinaryOperation.TIMES), AbstractValue.ZeroFloat);
        operationResults.put(new OperationKey(AbstractValue.ZeroFloat, AbstractValue.AnyFloat, BinaryOperation.TIMES), AbstractValue.ZeroFloat);
        
        operationResults.put(new OperationKey(AbstractValue.PosFloat, AbstractValue.NegFloat, BinaryOperation.TIMES), AbstractValue.NegFloat);
        operationResults.put(new OperationKey(AbstractValue.PosFloat, AbstractValue.ZeroFloat, BinaryOperation.TIMES), AbstractValue.ZeroFloat);
        operationResults.put(new OperationKey(AbstractValue.PosFloat, AbstractValue.PosFloat, BinaryOperation.TIMES), AbstractValue.PosFloat);
        operationResults.put(new OperationKey(AbstractValue.PosFloat, AbstractValue.AnyFloat, BinaryOperation.TIMES), AbstractValue.AnyFloat);
        
        operationResults.put(new OperationKey(AbstractValue.AnyFloat, AbstractValue.NegFloat, BinaryOperation.TIMES), AbstractValue.AnyFloat);
        operationResults.put(new OperationKey(AbstractValue.AnyFloat, AbstractValue.ZeroFloat, BinaryOperation.TIMES), AbstractValue.ZeroFloat);
        operationResults.put(new OperationKey(AbstractValue.AnyFloat, AbstractValue.PosFloat, BinaryOperation.TIMES), AbstractValue.AnyFloat);
        operationResults.put(new OperationKey(AbstractValue.AnyFloat, AbstractValue.AnyFloat, BinaryOperation.TIMES), AbstractValue.AnyFloat);

        // Mapping for DIVIDE operation
        //INT
        operationResults.put(new OperationKey(AbstractValue.NegInt, AbstractValue.NegInt, BinaryOperation.DIV), AbstractValue.AnyInt);
        operationResults.put(new OperationKey(AbstractValue.NegInt, AbstractValue.ZeroInt, BinaryOperation.DIV), AbstractValue.NegInt); //PROBLEM
        operationResults.put(new OperationKey(AbstractValue.NegInt, AbstractValue.PosInt, BinaryOperation.DIV), AbstractValue.AnyInt);
        operationResults.put(new OperationKey(AbstractValue.NegInt, AbstractValue.AnyInt, BinaryOperation.DIV), AbstractValue.AnyInt); //PROBLEM

        operationResults.put(new OperationKey(AbstractValue.ZeroInt, AbstractValue.NegInt, BinaryOperation.DIV), AbstractValue.ZeroInt);
        operationResults.put(new OperationKey(AbstractValue.ZeroInt, AbstractValue.ZeroInt, BinaryOperation.DIV), AbstractValue.ZeroInt); //PROBLEM
        operationResults.put(new OperationKey(AbstractValue.ZeroInt, AbstractValue.PosInt, BinaryOperation.DIV), AbstractValue.ZeroInt);
        operationResults.put(new OperationKey(AbstractValue.ZeroInt, AbstractValue.AnyInt, BinaryOperation.DIV), AbstractValue.AnyInt); //PROBLEM

        operationResults.put(new OperationKey(AbstractValue.PosInt, AbstractValue.NegInt, BinaryOperation.DIV), AbstractValue.AnyInt);
        operationResults.put(new OperationKey(AbstractValue.PosInt, AbstractValue.ZeroInt, BinaryOperation.DIV), AbstractValue.PosInt); //PROBLEM
        operationResults.put(new OperationKey(AbstractValue.PosInt, AbstractValue.PosInt, BinaryOperation.DIV), AbstractValue.AnyInt);
        operationResults.put(new OperationKey(AbstractValue.PosInt, AbstractValue.AnyInt, BinaryOperation.DIV), AbstractValue.AnyInt); //PROBLEM

        operationResults.put(new OperationKey(AbstractValue.AnyInt, AbstractValue.NegInt, BinaryOperation.DIV), AbstractValue.AnyInt);
        operationResults.put(new OperationKey(AbstractValue.AnyInt, AbstractValue.ZeroInt, BinaryOperation.DIV), AbstractValue.AnyInt); //PROBLEM
        operationResults.put(new OperationKey(AbstractValue.AnyInt, AbstractValue.PosInt, BinaryOperation.DIV), AbstractValue.AnyInt); 
        operationResults.put(new OperationKey(AbstractValue.AnyInt, AbstractValue.AnyInt, BinaryOperation.DIV), AbstractValue.AnyInt); //PROBLEM
        //FLOAT
        operationResults.put(new OperationKey(AbstractValue.NegFloat, AbstractValue.NegFloat, BinaryOperation.DIV), AbstractValue.PosFloat);
        operationResults.put(new OperationKey(AbstractValue.NegFloat, AbstractValue.ZeroFloat, BinaryOperation.DIV), AbstractValue.NegFloat); //PROBLEM
        operationResults.put(new OperationKey(AbstractValue.NegFloat, AbstractValue.PosFloat, BinaryOperation.DIV), AbstractValue.NegFloat);
        operationResults.put(new OperationKey(AbstractValue.NegFloat, AbstractValue.AnyFloat, BinaryOperation.DIV), AbstractValue.AnyFloat); //PROBLEM

        operationResults.put(new OperationKey(AbstractValue.ZeroFloat, AbstractValue.NegFloat, BinaryOperation.DIV), AbstractValue.ZeroFloat);
        operationResults.put(new OperationKey(AbstractValue.ZeroFloat, AbstractValue.ZeroFloat, BinaryOperation.DIV), AbstractValue.ZeroFloat); //PROBLEM
        operationResults.put(new OperationKey(AbstractValue.ZeroFloat, AbstractValue.PosFloat, BinaryOperation.DIV), AbstractValue.ZeroFloat);
        operationResults.put(new OperationKey(AbstractValue.ZeroFloat, AbstractValue.AnyFloat, BinaryOperation.DIV), AbstractValue.AnyFloat); //PROBLEM

        operationResults.put(new OperationKey(AbstractValue.PosFloat, AbstractValue.NegFloat, BinaryOperation.DIV), AbstractValue.NegFloat);
        operationResults.put(new OperationKey(AbstractValue.PosFloat, AbstractValue.ZeroFloat, BinaryOperation.DIV), AbstractValue.PosFloat); //PROBLEM
        operationResults.put(new OperationKey(AbstractValue.PosFloat, AbstractValue.PosFloat, BinaryOperation.DIV), AbstractValue.PosFloat);
        operationResults.put(new OperationKey(AbstractValue.PosFloat, AbstractValue.AnyFloat, BinaryOperation.DIV), AbstractValue.AnyFloat); //PROBLEM

        operationResults.put(new OperationKey(AbstractValue.AnyFloat, AbstractValue.NegFloat, BinaryOperation.DIV), AbstractValue.AnyFloat);
        operationResults.put(new OperationKey(AbstractValue.AnyFloat, AbstractValue.ZeroFloat, BinaryOperation.DIV), AbstractValue.AnyFloat); //PROBLEM
        operationResults.put(new OperationKey(AbstractValue.AnyFloat, AbstractValue.PosFloat, BinaryOperation.DIV), AbstractValue.AnyFloat); 
        operationResults.put(new OperationKey(AbstractValue.AnyFloat, AbstractValue.AnyFloat, BinaryOperation.DIV), AbstractValue.AnyFloat); //PROBLEM

        // Mapping for MERGE operation
        //Int
        operationResults.put(new OperationKey(AbstractValue.NegInt, AbstractValue.NegInt, BinaryOperation.MERGE), AbstractValue.NegInt);
        operationResults.put(new OperationKey(AbstractValue.NegInt, AbstractValue.ZeroInt, BinaryOperation.MERGE), AbstractValue.AnyInt);
        operationResults.put(new OperationKey(AbstractValue.NegInt, AbstractValue.PosInt, BinaryOperation.MERGE), AbstractValue.AnyInt);
        operationResults.put(new OperationKey(AbstractValue.NegInt, AbstractValue.AnyInt, BinaryOperation.MERGE), AbstractValue.AnyInt);

        operationResults.put(new OperationKey(AbstractValue.ZeroInt, AbstractValue.NegInt, BinaryOperation.MERGE), AbstractValue.AnyInt);
        operationResults.put(new OperationKey(AbstractValue.ZeroInt, AbstractValue.ZeroInt, BinaryOperation.MERGE), AbstractValue.ZeroInt);
        operationResults.put(new OperationKey(AbstractValue.ZeroInt, AbstractValue.PosInt, BinaryOperation.MERGE), AbstractValue.AnyInt);
        operationResults.put(new OperationKey(AbstractValue.ZeroInt, AbstractValue.AnyInt, BinaryOperation.MERGE), AbstractValue.AnyInt);

        operationResults.put(new OperationKey(AbstractValue.PosInt, AbstractValue.NegInt, BinaryOperation.MERGE), AbstractValue.AnyInt);
        operationResults.put(new OperationKey(AbstractValue.PosInt, AbstractValue.ZeroInt, BinaryOperation.MERGE), AbstractValue.AnyInt);
        operationResults.put(new OperationKey(AbstractValue.PosInt, AbstractValue.PosInt, BinaryOperation.MERGE), AbstractValue.PosInt);
        operationResults.put(new OperationKey(AbstractValue.PosInt, AbstractValue.AnyInt, BinaryOperation.MERGE), AbstractValue.AnyInt);

        operationResults.put(new OperationKey(AbstractValue.AnyInt, AbstractValue.NegInt, BinaryOperation.MERGE), AbstractValue.AnyInt);
        operationResults.put(new OperationKey(AbstractValue.AnyInt, AbstractValue.ZeroInt, BinaryOperation.MERGE), AbstractValue.AnyInt);
        operationResults.put(new OperationKey(AbstractValue.AnyInt, AbstractValue.PosInt, BinaryOperation.MERGE), AbstractValue.AnyInt);
        operationResults.put(new OperationKey(AbstractValue.AnyInt, AbstractValue.AnyInt, BinaryOperation.MERGE), AbstractValue.AnyInt);

        // FLT
        operationResults.put(new OperationKey(AbstractValue.NegFloat, AbstractValue.NegFloat, BinaryOperation.MERGE), AbstractValue.NegFloat);
        operationResults.put(new OperationKey(AbstractValue.NegFloat, AbstractValue.ZeroFloat, BinaryOperation.MERGE), AbstractValue.AnyFloat);
        operationResults.put(new OperationKey(AbstractValue.NegFloat, AbstractValue.PosFloat, BinaryOperation.MERGE), AbstractValue.AnyFloat);
        operationResults.put(new OperationKey(AbstractValue.NegFloat, AbstractValue.AnyFloat, BinaryOperation.MERGE), AbstractValue.AnyFloat);

        operationResults.put(new OperationKey(AbstractValue.ZeroFloat, AbstractValue.NegFloat, BinaryOperation.MERGE), AbstractValue.AnyFloat);
        operationResults.put(new OperationKey(AbstractValue.ZeroFloat, AbstractValue.ZeroFloat, BinaryOperation.MERGE), AbstractValue.ZeroFloat);
        operationResults.put(new OperationKey(AbstractValue.ZeroFloat, AbstractValue.PosFloat, BinaryOperation.MERGE), AbstractValue.AnyFloat);
        operationResults.put(new OperationKey(AbstractValue.ZeroFloat, AbstractValue.AnyFloat, BinaryOperation.MERGE), AbstractValue.AnyFloat);

        operationResults.put(new OperationKey(AbstractValue.PosFloat, AbstractValue.NegFloat, BinaryOperation.MERGE), AbstractValue.AnyFloat);
        operationResults.put(new OperationKey(AbstractValue.PosFloat, AbstractValue.ZeroFloat, BinaryOperation.MERGE), AbstractValue.AnyFloat);
        operationResults.put(new OperationKey(AbstractValue.PosFloat, AbstractValue.PosFloat, BinaryOperation.MERGE), AbstractValue.PosFloat);
        operationResults.put(new OperationKey(AbstractValue.PosFloat, AbstractValue.AnyFloat, BinaryOperation.MERGE), AbstractValue.AnyFloat);

        operationResults.put(new OperationKey(AbstractValue.AnyFloat, AbstractValue.NegFloat, BinaryOperation.MERGE), AbstractValue.AnyFloat);
        operationResults.put(new OperationKey(AbstractValue.AnyFloat, AbstractValue.ZeroFloat, BinaryOperation.MERGE), AbstractValue.AnyFloat);
        operationResults.put(new OperationKey(AbstractValue.AnyFloat, AbstractValue.PosFloat, BinaryOperation.MERGE), AbstractValue.AnyFloat);
        operationResults.put(new OperationKey(AbstractValue.AnyFloat, AbstractValue.AnyFloat, BinaryOperation.MERGE), AbstractValue.AnyFloat);

    }

    public static AbstractValue getResult(AbstractValue left, AbstractValue right, BinaryOperation operation) {
        return operationResults.getOrDefault(new OperationKey(left, right, operation), AbstractValue.AnyInt);
    }
}
