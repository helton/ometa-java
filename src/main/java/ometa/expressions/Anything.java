package ometa.expressions;

import ometa.exceptions.OMetaException;
import ometa.streams.OMetaStream;

public class Anything<T> extends BaseOMetaExpression<T> {

    public Anything(OMetaStream<T> stream) {
        super(stream);
    }

    @Override
    public boolean isMatch() {
        return !getStream().isEmpty();
    }

    @Override
    public void match() {
        if (isMatch())
            getStream().get();
        else
            throw new OMetaException("Anything doesn't match");
    }

}
