public class Letter {
    private final LetterType type;

    public Letter(String letter){
        type = LetterType.from(letter);
    }

    public LetterType getType() {
        return type;
    }
}
