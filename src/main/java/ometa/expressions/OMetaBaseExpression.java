package ometa.expressions;

import ometa.exceptions.OMetaException;
import ometa.streams.OMetaStream;

public abstract class OMetaBaseExpression<T> implements OMetaExpression<T> {
    private OMetaStream<T> stream;

    public OMetaBaseExpression(OMetaStream<T> stream) {
        this.stream = stream;
    }

    @Override
    public void match() {
        if (isMatch())
            apply();
        else {
            String lookaheadAsString = getStream().isEmpty() ? "EOF" : getStream().peek().toString();
            throw new OMetaException(getClass().getSimpleName() + " doesn't match <" + lookaheadAsString + ">");
        }
    }

    @Override
    public OMetaStream<T> getStream() {
        return stream;
    }

    public void apply() {
        readStream();
    }

    public T readStream() {
        return getStream().get();
    }

}

