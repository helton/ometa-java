package ometa.expressions;

import ometa.exceptions.OMetaException;
import ometa.streams.CharacterStream;
import org.junit.Assert;
import org.junit.Test;

public class ExactTest {

    @Test
    public void shouldMatchTheDefinedChar() throws Exception {
        Exact<Character> exact = new Exact<>(new CharacterStream("a"), 'a');
        Assert.assertTrue(exact.isMatch());
    }

    @Test
    public void shouldNotMatchOtherChars() throws Exception {
        Exact<Character> exact = new Exact<>(new CharacterStream("b"), 'a');
        Assert.assertFalse(exact.isMatch());
    }

    @Test
    public void shouldMatchTwoTimesWhenThereAreTwoSameChars() throws Exception {
        Exact<Character> exact = new Exact<>(new CharacterStream("aa"), 'a');

        Assert.assertTrue(exact.isMatch());
        exact.match();

        Assert.assertTrue(exact.isMatch());
        exact.match();

        Assert.assertFalse(exact.isMatch());
    }

    @Test(expected=OMetaException.class)
    public void shouldRaiseExceptionWhenForceMatch() throws Exception {
        Exact<Character> exact = new Exact<>(new CharacterStream(), 'a');
        exact.match();
    }

}
