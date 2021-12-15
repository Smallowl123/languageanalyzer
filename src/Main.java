import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Language zero = new Language("rules/rules.txt");
        Language cs = new Language("rules/rules1.txt");
        Language cf = new Language("rules/rules2.txt");
        Language regular = new Language("rules/rules3.txt");
        Language lab5 = new Language("rules/rules5.txt");
    }
}