package lab5;

public class Rule {
    private char nonTerminal;
    private String right;

    public Rule(String rule){
        String[] rules = rule.split("->");
        nonTerminal = rules[0].toCharArray()[0];
        right = rules[1];
    }

    public char getNonTerminal() {
        return nonTerminal;
    }

    public String getRight() {
        return right;
    }
}
