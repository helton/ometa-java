package ometa.streams;

public interface OMetaStream<T> {
    T get();
    void unget();
    boolean isEmpty();
}
