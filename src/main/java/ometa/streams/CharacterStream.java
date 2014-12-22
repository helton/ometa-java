package ometa.streams;

import java.util.ArrayList;
import java.util.List;

public class CharacterStream extends BaseStream<Character> {

    public CharacterStream() {
        super();
    }

    public CharacterStream(String content) {
        super(stringToCharacterList(content));
    }

    private static List<Character> stringToCharacterList(String content) {
        List<Character> chars = new ArrayList<>();
        for (char ch : content.toCharArray())
            chars.add(ch);
        return chars;
    }

}