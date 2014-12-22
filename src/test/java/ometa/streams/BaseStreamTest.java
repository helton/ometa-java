package ometa.streams;

import org.junit.Before;

import java.util.ArrayList;

public class BaseStreamTest extends OMetaStreamTest<Object> {

    @Before
    public void setUp() {
        item1 = new Object();
        item2 = new Object();
        item3 = new Object();
        list = new ArrayList<Object>() {{
            add(item1);
            add(item2);
            add(item3);
        }};
        stream = new BaseStream<>(list);
    }

}