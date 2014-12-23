package ometa.expressions;

import ometa.streams.OMetaStream;

public class Exactly<T> extends OMetaBaseExpression<T> {
    private T expectedObject;

    public Exactly(OMetaStream<T> stream, T expectedObject) {
        super(stream);
        this.expectedObject = expectedObject;
    }

    @Override
    public boolean isMatch() {
        return !getStream().isEmpty() && getStream().peek().equals(expectedObject);
    }

}
