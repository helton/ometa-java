package ometa.expressions;

import ometa.streams.OMetaStream;

public abstract class OMetaExpression<T> {
    private OMetaStream<T> stream;

    public OMetaExpression(OMetaStream<T> stream) {
        this.stream = stream;
    }

    public OMetaStream<T> getStream() {
        return stream;
    }

    abstract boolean isMatch();
    abstract void match();
}
