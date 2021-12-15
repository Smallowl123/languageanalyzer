import java.util.Arrays;
import java.util.regex.Pattern;

public enum LetterType implements Regulars{
    TERMINAL(LOWERCASE_AND_DIGITS, "Терминал"),
    NON_TERMINAL(UPPERCASE_WITHOUT_S, "Нетерминал"),
    UNKNOWN(NO_SPACE, "Неопознанный элемент");

    private final String regex;
    private final String definition;

    LetterType(String regex, String definition){
        this.regex = regex;
        this.definition = definition;
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
