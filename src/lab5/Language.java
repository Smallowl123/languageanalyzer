package lab5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Language {
    private LinkedList<Rule> rules = new LinkedList<>();

    public Language(){
        setRules();
    }

    private void setRules() {
        try (BufferedReader br = new BufferedReader(new FileReader("rules/rules5.txt"))) {
            String line = br.readLine();
            while (line != null) {
                rules.add(new Rule(line));
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public LinkedList<Rule> getRulesByNonTerminal(char nonTerminal){
        LinkedList<Rule> selectedRules = new LinkedList<>();
        for (Rule rule: rules){
            if (rule.getNonTerminal() == nonTerminal){
                selectedRules.add(rule);
            }
        }
        return selectedRules;
    }
}
