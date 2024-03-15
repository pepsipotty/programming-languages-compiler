package ast;
import java.util.Objects;
public class OperationKey {
    private final AbstractValue left;
    private final AbstractValue right;
    private final BinaryOperation operation;

    public OperationKey(AbstractValue left, AbstractValue right, BinaryOperation operation) {
        this.left = left;
        this.right = right;
        this.operation = operation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationKey that = (OperationKey) o;
        return left == that.left && right == that.right && operation == that.operation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right, operation);
    }
}