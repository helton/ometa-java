package ometa.streams;

import java.util.ArrayList;
import java.util.List;

public class BaseStream<T> implements OMetaStream<T> {
    private List<T> stream;
    private int index = 0;

    public BaseStream(List<T> stream) {
        this.stream = stream;
    }

    public BaseStream() {
        this(new ArrayList<>());
    }

    @Override
    public T peek() {
        return stream.get(index);
    }

    @Override
    public T get() {
        return stream.get(index++);
    }

    @Override
    public void unget() {
        index--;
    }

    @Override
    public boolean isEmpty() {
        return stream.size() == index;
    }

    @Override
    public long size() {
        return stream.size();
    }

}
