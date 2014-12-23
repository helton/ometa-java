package ometa.expressions;

import ometa.streams.CharacterStream;
import org.junit.Assert;
import org.junit.Test;

public class LookaheadTest {

    @Test
    public void shouldMatchWhenInnerExpressionMatches() throws Exception {
        Exactly<Character> exactly = new Exactly<>(new CharacterStream("a"), 'a');
        Lookahead<Character, Exactly<Character>> lookahead = new Lookahead<>(exactly);
        Assert.assertTrue(lookahead.isMatch());
    }

    @Test
    public void shouldNotMatchWhenInnerExpressionDoesntMatch() throws Exception {
        Exactly<Character> exactly = new Exactly<>(new CharacterStream("b"), 'a');
        Lookahead<Character, Exactly<Character>> lookahead = new Lookahead<>(exactly);
        Assert.assertFalse(lookahead.isMatch());
    }

    @Test
    public void shouldNotConsumeTextWhenInnerExpressionMatches() throws Exception {
        Exactly<Character> exactly = new Exactly<>(new CharacterStream("abc"), 'a');
        Lookahead<Character, Exactly<Character>> lookahead = new Lookahead<>(exactly);
        Assert.assertEquals(3, lookahead.getStream().size());
        lookahead.match();
        Assert.assertEquals(3, lookahead.getStream().size());
    }

}
