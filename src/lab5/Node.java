package lab5;

import java.util.LinkedList;

public class Node {
    private char nonTerminal;
    private int nonTerminalPlace;
    private LinkedList<Rule> rules;
    private boolean isAvailable = true;
    private String input;
    private String stack;
    private Node rollBackNode;

    public Node(String input, String stack, Node rollBackNode){
        this.input = input;
        this.stack = stack;
        findFirstNonTerminal(stack);

        this.rules = new Language().getRulesByNonTerminal(nonTerminal);
        this.rollBackNode = rollBackNode;
    }

    public Node(String input, String stack){
        this.input = input;
        this.stack = stack;
        findFirstNonTerminal(stack);

        this.rules = new Language().getRulesByNonTerminal(nonTerminal);
    }

    private void findFirstNonTerminal(String input){
        int count = -1;
        for (char ch: input.toCharArray()){
            count++;
            if (new Letter(String.valueOf(ch)).getType() == LetterType.NON_TERMINAL){
                nonTerminal = ch;
                nonTerminalPlace = count;
                break;
            }
        }
    }

    public void setAvailabilityOnFalse() {
        isAvailable = false;
    }
    public void toSOUT(){
        System.out.println("input: " + input);
        System.out.println("stack: " + stack);
        System.out.println("rollback node" + rollBackNode);
    }

    public String getInput() {
        return input;
    }

    public String getStack() {
        return stack;
    }

    public Node createNextNode() {
        String newInput = input;
        String newStack;

        if (nonTerminalPlace == 0){
            newStack = rules.getFirst().getRight() + stack.substring(1);
        }
        else {
            newStack = stack.substring(0,nonTerminalPlace) + rules.getFirst().getRight() + stack.substring(nonTerminalPlace+1);
        }

        char[] inp = newInput.toCharArray();
        char[] stc = newStack.toCharArray();
        int count = 0;
        for (int i = 0; i < (Math.min(inp.length, stc.length)); i++){
            if (inp[i] == stc[i]){
                count++;
            }
            else break;
        }
        newInput = newInput.substring(count);
        newStack = newStack.substring(count);

        rules.remove(0);
        if (rules.size() == 0){
            setAvailabilityOnFalse();
        }
        if (newInput.isEmpty()) newInput+= "ε";
        if (newStack.isEmpty()) newStack+= "ε";

        if (isAvailable() && !getInput().equals("ε") && isStackContainsNonTerminals())
            return new Node(newInput, newStack, this);

        return new Node(newInput, newStack, getRollBackNode());
    }

    public boolean isAvailable(){
        return isAvailable;
    }

    public boolean isStackContainsNonTerminals(){
        int nonTerminalsCount = 0;
        for (char ch: getStack().toCharArray()){
            if (new Letter(String.valueOf(ch)).getType() == LetterType.NON_TERMINAL) nonTerminalsCount++;
        }
        return nonTerminalsCount != 0;
    }

    public Node getRollBackNode(){
        return rollBackNode;
    }
}
