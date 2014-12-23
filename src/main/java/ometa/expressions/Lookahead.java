package ometa.expressions;

public class Lookahead<S, T extends OMetaBaseExpression<S>> extends OMetaExpressionContainer<S, T> {

    public Lookahead(T innerExpression) {
        super(innerExpression);
    }

    @Override
    public boolean isMatch() {
        return getInnerExpression().isMatch();
    }

    @Override
    public void apply() {
    }
}
