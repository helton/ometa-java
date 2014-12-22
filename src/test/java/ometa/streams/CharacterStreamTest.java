package ometa.streams;

import org.junit.Before;

import java.util.ArrayList;

public class CharacterStreamTest extends OMetaStreamTest<Character> {

    @Before
    public void setUp() {
        item1 = 'a';
        item2 = 'b';
        item3 = 'c';
        list = new ArrayList<Character>() {{
            add(item1);
            add(item2);
            add(item3);
        }};
        stream = new CharacterStream("abc");
    }

}
