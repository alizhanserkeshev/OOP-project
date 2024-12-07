package Enums;


public enum Marks {
    A(95), A_MINUS(90),
    B_PLUS(85), B(80), B_MINUS(75),
    C_PLUS(70), C(65), C_MINUS(60),
    D_PLUS(55), D_MINUS(50),
    F(49);

    private final double mark;

    Marks(int mark) {this.mark = mark;}

    public double getMark() {return mark;}

    public double getGPA() {
        return switch(this) {
            case A -> 4.0;
            case A_MINUS -> 3.67;
            case B_PLUS -> 3.33;
            case B -> 3.0;
            case B_MINUS -> 2.67;
            case C_PLUS -> 2.33;
            case C -> 2.0;
            case C_MINUS -> 1.67;
            case D_PLUS -> 1.33;
            case D_MINUS -> 1.0;
            case F -> 0.0;
        };
    }
}
