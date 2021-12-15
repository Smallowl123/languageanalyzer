package lab5;

import java.util.LinkedList;

public class Logic {
    private final LinkedList<Node> nodes = new LinkedList<>();


    public void define(String input, String stack){
        Node nodeInWork = new Node(input, stack);
        nodeInWork.toSOUT();
        int count = 0;
        while (!(nodeInWork.getInput().equals("ε") && nodeInWork.getStack().equals("ε") )){
            System.out.println("Step " + count + "................................");
            if (nodeInWork.getStack().equals("ε") || !nodeInWork.isStackContainsNonTerminals() || nodeInWork.getStack().length() > nodeInWork.getInput().length()){
                System.out.println("Rollin' to:******************************");
                nodeInWork.getRollBackNode().toSOUT();
                nodeInWork = nodeInWork.getRollBackNode().createNextNode();
            }
            else nodeInWork = nodeInWork.createNextNode();
            nodeInWork.toSOUT();
            count++;
        }
    }
}
