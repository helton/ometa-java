package ometa.expressions;

import ometa.streams.CharacterStream;
import org.junit.Assert;
import org.junit.Test;

public class NegationTest {

    @Test
    public void shouldMatchWhenInnerExpressionNotMatches() throws Exception {
        Exactly<Character> exactly = new Exactly<>(new CharacterStream("a"), 'a');
        Negation<Character, Exactly<Character>> negation = new Negation<>(exactly);
        Assert.assertFalse(negation.isMatch());
    }

    @Test
    public void shouldNotMatchWhenInnerExpressionMatches() throws Exception {
        Exactly<Character> exactly = new Exactly<>(new CharacterStream("b"), 'a');
        Negation<Character, Exactly<Character>> negation = new Negation<>(exactly);
        Assert.assertTrue(negation.isMatch());
    }

    @Test
    public void shouldConsumeTextWhenInnerExpressionDoesntMatch() throws Exception {
        Exactly<Character> exactly = new Exactly<>(new CharacterStream("bc"), 'a');
        Negation<Character, Exactly<Character>> negation = new Negation<>(exactly);
        Assert.assertTrue(negation.isMatch());
        negation.match();
        Assert.assertTrue(negation.isMatch());
        negation.match();
        Assert.assertTrue(negation.isMatch()); //EOF matches ~"a"
    }
}
