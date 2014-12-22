package ometa.expressions;

import ometa.exceptions.OMetaException;
import ometa.streams.OMetaStream;

public class Anything<T> extends OMetaExpression<T> {

    public Anything(OMetaStream<T> stream) {
        super(stream);
    }

    @Override
    boolean isMatch() {
        return !getStream().isEmpty();
    }

    @Override
    void match() {
        if (isMatch())
            getStream().get();
        else
            throw new OMetaException("Anything doesn't match");
    }

}
