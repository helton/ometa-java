package ometa.expressions;

import ometa.streams.OMetaStream;

public abstract class OMetaExpressionContainer<S, T extends OMetaBaseExpression<S>> extends OMetaBaseExpression<S> {
    private T innerExpression;

    public OMetaExpressionContainer(OMetaStream<S> stream, T innerExpression) {
        super(stream);
        this.innerExpression = innerExpression;
    }

    public OMetaExpressionContainer(T innerExpression) {
        this(innerExpression.getStream(), innerExpression);
    }

    public T getInnerExpression () {
        return innerExpression;
    }

}
