package ometa.expressions;

import ometa.streams.OMetaStream;

public interface OMetaExpression<T> {
    boolean isMatch();
    void match();
    OMetaStream<T> getStream();
}
