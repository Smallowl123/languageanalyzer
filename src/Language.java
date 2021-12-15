import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Language {
    LinkedList<Rule> rules = new LinkedList<>();
    LanguageType type;

    public Language(String fileName) throws FileNotFoundException {
        setRules(fileName);
        setType(rules);

        System.out.println("Грамматика в файле '" + fileName + "' - " + type.getDefinition());

        }
    private void setRules(String fileName) throws FileNotFoundException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            while (line != null) {
                rules.add(new Rule(line));
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setType(LinkedList<Rule> rules){
        int type = 3;
        for (Rule rule: rules){
            if (rule.getType() < type){
                type = rule.getType();
            }
        }
        this.type = LanguageType.values()[type];
    }
}