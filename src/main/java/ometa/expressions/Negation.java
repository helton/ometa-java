package ometa.expressions;

public class Negation<T extends OMetaExpression<?>> implements OMetaExpression<T> {
    private T innerExpression;

    public Negation(T innerExpression) {
        this.innerExpression = innerExpression;
    }

    @Override
    public boolean isMatch() {
        return !innerExpression.getStream().isEmpty() && !innerExpression.isMatch();
    }

    @Override
    public void match() {
        innerExpression.getStream().get();
    }

}
