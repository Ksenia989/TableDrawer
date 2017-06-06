package Parts;

import parsii.eval.Expression;
import parsii.eval.Parser;
import parsii.eval.Scope;
import parsii.eval.Variable;
import parsii.tokenizer.ParseException;

public class Part {
    private int leftBoard;
    private int rightBoard;
    private String stringExpression;
    private Variable x;
    Expression expression;

    public Part(String stringExpression, int leftBoard, int rightBoard) {
        this.leftBoard = leftBoard;
        this.rightBoard = rightBoard;
        this.stringExpression = stringExpression;
        this.createScope();
    }

    private void createScope() {
        Scope scope = Scope.create();
        x = scope.getVariable("x");
        try {
            expression = Parser.parse(stringExpression, scope);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    double calculateY(double xValue) {
        x.setValue(xValue);
        return expression.evaluate();
    }

    public int getLeftBoard() {
        return leftBoard;
    }

    public int getRightBoard() {
        return rightBoard;
    }
}
