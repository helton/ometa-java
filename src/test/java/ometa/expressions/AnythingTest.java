package ometa.expressions;

import ometa.exceptions.OMetaException;
import ometa.streams.CharacterStream;
import org.junit.Assert;
import org.junit.Test;

public class AnythingTest {
    @Test
    public void whenCallIsMatchWithAnEmptyStreamShouldNotMatch() throws Exception {
        final CharacterStream charStream = new CharacterStream();
        Anything<Character> anything = new Anything<>(charStream);
        Assert.assertFalse(anything.isMatch());
    }

    @Test
    public void whenCallIsMatchWithANonEmptyStreamShouldMatch() throws Exception {
        final CharacterStream charStream = new CharacterStream("my text");
        Anything<Character> anything = new Anything<>(charStream);
        Assert.assertTrue(anything.isMatch());
    }

    @Test
    public void shouldMatchOnlyTwoTimesWithTheStreamHasOnlyTwoItems() throws Exception {
        final CharacterStream charStream = new CharacterStream("ab");
        Anything<Character> anything = new Anything<>(charStream);

        Assert.assertTrue(anything.isMatch());
        anything.match();

        Assert.assertTrue(anything.isMatch());
        anything.match();

        Assert.assertFalse(anything.isMatch());
    }

    @Test(expected=OMetaException.class)
    public void shouldRaiseExceptionWhenForceMatch() throws Exception {
        final CharacterStream charStream = new CharacterStream();
        Anything<Character> anything = new Anything<>(charStream);
        anything.match();
    }

}