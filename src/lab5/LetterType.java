package lab5;

import java.util.Arrays;
import java.util.regex.Pattern;

public enum LetterType implements Regulars {
    TERMINAL(LOWERCASE_AND_DIGITS),
    NON_TERMINAL(UPPERCASE),
    UNKNOWN(NO_SPACE);

    private final String regex;

    LetterType(String regex){
        this.regex = regex;
    }

    public static LetterType from(String letter){
        return Arrays.stream(values())
                .filter(t -> Pattern.compile(t.regex)
                .matcher(letter)
                .find())
                .findFirst()
                .orElse(UNKNOWN);
    }
}
