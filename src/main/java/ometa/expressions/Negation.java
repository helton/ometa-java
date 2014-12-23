package ometa.expressions;

public class Negation<S, T extends OMetaBaseExpression<S>> extends OMetaExpressionContainer<S, T> {

    public Negation(T innerExpression) {
        super(innerExpression);
    }

    @Override
    public boolean isMatch() {
        return !getInnerExpression().isMatch();
    }

}
