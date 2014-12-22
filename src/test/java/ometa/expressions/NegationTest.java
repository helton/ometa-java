package ometa.expressions;

import ometa.streams.CharacterStream;
import org.junit.Assert;
import org.junit.Test;

public class NegationTest {

    @Test
    public void shouldMatchWhenInnerExpressionNotMatches() throws Exception {
        Exact<Character> exact = new Exact<>(new CharacterStream("a"), 'a');
        Negation<Exact<Character>> negation = new Negation<>(exact);
        Assert.assertFalse(negation.isMatch());
    }

    @Test
    public void shouldNotMatchWhenInnerExpressionMatches() throws Exception {
        Exact<Character> exact = new Exact<>(new CharacterStream("b"), 'a');
        Negation<Exact<Character>> negation = new Negation<>(exact);
        Assert.assertTrue(negation.isMatch());
    }

    @Test
    public void shouldConsumeTextWhenInnerExpressionDoesntMatch() throws Exception {
        Exact<Character> exact = new Exact<>(new CharacterStream("b"), 'a');
        Negation<Exact<Character>> negation = new Negation<>(exact);
        Assert.assertTrue(negation.isMatch());
        negation.match();
        Assert.assertFalse(negation.isMatch());
    }
}
