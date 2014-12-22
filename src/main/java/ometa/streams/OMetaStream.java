package ometa.streams;

public interface OMetaStream<T> {
    T peek();
    T get();
    void unget();
    boolean isEmpty();
    long size();
}
