package ometa.expressions;

import ometa.exceptions.OMetaException;
import ometa.streams.OMetaStream;

public class Exact<T> extends BaseOMetaExpression<T> {
    private T expectedObject;

    public Exact(OMetaStream<T> stream, T expectedObject) {
        super(stream);
        this.expectedObject = expectedObject;
    }

    @Override
    public boolean isMatch() {
        return !getStream().isEmpty() && getStream().peek().equals(expectedObject);
    }

    @Override
    public void match() {
        if (isMatch())
            getStream().get();
        else
            throw new OMetaException("Exact doesn't match");
    }
}
