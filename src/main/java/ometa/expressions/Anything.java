package ometa.expressions;

import ometa.streams.OMetaStream;

public class Anything<T> extends OMetaBaseExpression<T> {

    public Anything(OMetaStream<T> stream) {
        super(stream);
    }

    @Override
    public boolean isMatch() {
        return !getStream().isEmpty();
    }

}
