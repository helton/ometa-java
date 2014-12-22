package ometa.streams;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public abstract class OMetaStreamTest<T> {

    protected List<T> list;
    protected T item1, item2, item3;
    protected OMetaStream<T> stream;

    @Test
    public void whenCallGetAtFirstTimeShouldReturnFirstItem() throws Exception {
        Assert.assertEquals(item1, stream.get());
    }

    @Test
    public void whenCallUngetThenGetThenUngetShouldReadTheSameItemTwice() throws Exception {
        T firstItem = stream.get();
        stream.unget();
        T secondItem = stream.get();
        Assert.assertEquals(item1, firstItem);
        Assert.assertEquals(firstItem, secondItem);
    }

    @Test
    public void whenCallIsEmptyWithANonEmptyStreamShouldReturnFalse() throws Exception {
        Assert.assertFalse(stream.isEmpty());
    }

    @Test
    public void whenCallIsEmptyWithAnEmptyStreamShouldReturnTrue() throws Exception {
        stream = new BaseStream<>();
        Assert.assertTrue(stream.isEmpty());
    }

    @Test
    public void whenReadAllContentItShouldBeEmpty() throws Exception {
        stream.get();
        stream.get();
        stream.get();
        Assert.assertTrue(stream.isEmpty());
    }

    @Test
    public void shouldReturnSizeCorrectly() throws Exception {
        Assert.assertEquals(3, stream.size());
        stream = new BaseStream<>();
        Assert.assertEquals(0, stream.size());
    }

    @Test
    public void whenCallPeekShouldNotRemoveElementFromStream() throws Exception {
        stream.get();
        stream.get();
        T first = stream.peek();
        T second = stream.peek();
        T third = stream.peek();
        Assert.assertEquals(item3, first);
        Assert.assertEquals(first, second);
        Assert.assertEquals(second, third);
    }

}