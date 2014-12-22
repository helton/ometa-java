package ometa.expressions;

import ometa.streams.OMetaStream;

public interface OMetaExpression<T> {
    boolean isMatch();
    void match();

    default OMetaStream<T> getStream() {
        return null;
    }
}
