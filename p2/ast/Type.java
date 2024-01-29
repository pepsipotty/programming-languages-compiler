package ast;
public enum Type {
    INT("INT"),
    FLOAT("FLOAT"),
    IDENTIFIER("IDENT");

    private String value;

    Type(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}