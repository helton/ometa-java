package ometa.expressions;

import ometa.exceptions.OMetaException;
import ometa.streams.CharacterStream;
import org.junit.Assert;
import org.junit.Test;

public class ExactlyTest {

    @Test
    public void shouldMatchTheDefinedChar() throws Exception {
        Exactly<Character> exactly = new Exactly<>(new CharacterStream("a"), 'a');
        Assert.assertTrue(exactly.isMatch());
    }

    @Test
    public void shouldNotMatchOtherChars() throws Exception {
        Exactly<Character> exactly = new Exactly<>(new CharacterStream("b"), 'a');
        Assert.assertFalse(exactly.isMatch());
    }

    @Test
    public void shouldMatchTwoTimesWhenThereAreTwoSameChars() throws Exception {
        Exactly<Character> exactly = new Exactly<>(new CharacterStream("aa"), 'a');

        Assert.assertTrue(exactly.isMatch());
        exactly.match();

        Assert.assertTrue(exactly.isMatch());
        exactly.match();

        Assert.assertFalse(exactly.isMatch());
    }

    @Test(expected=OMetaException.class)
    public void shouldRaiseExceptionWhenForceMatch() throws Exception {
        Exactly<Character> exactly = new Exactly<>(new CharacterStream("abcdef"), 'b');
        exactly.match();
    }

    @Test(expected=OMetaException.class)
    public void shouldRaiseExceptionWhenForceMatchEOF() throws Exception {
        Exactly<Character> exactly = new Exactly<>(new CharacterStream(), 'a');
        exactly.match();
    }

}
