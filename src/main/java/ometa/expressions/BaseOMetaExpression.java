package ometa.expressions;

import ometa.streams.OMetaStream;

public abstract class BaseOMetaExpression<T> implements OMetaExpression<T> {
    private OMetaStream<T> stream;

    public BaseOMetaExpression(OMetaStream<T> stream) {
        this.stream = stream;
    }

    @Override
    public OMetaStream<T> getStream() {
        return stream;
    }
}
