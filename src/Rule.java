public class Rule {
    private int type;

    public Rule(String rule){
        String[] strings = rule.split("->");
        setType(strings);
    }

    public int getType() {
        return type;
    }

    public void setType(String[] rules) {
        String left = rules[0];
        String right = rules[1];
//Только 0 тип допускает наличие ε
        if (lookForEps(right)){
            type = 0;
        }
        else {
            //В типах 2 и 3 в левой части правила 1 символ
            if (left.length() == 1) {
                //И этот символ - нетерминал
                if (new Letter(left).getType() == LetterType.NON_TERMINAL){
                    //В типе 3 в правой части не более 2 символов
                    if (right.length() <= 2){
                        char[] rightChar = right.toCharArray();
                        int count = 0;
                        //Проверяем чтобы не было двух терминалов или двух нетерминалов
                        for (char c : rightChar) {
                            Letter letter = new Letter(String.valueOf(c));
                            if (letter.getType() == LetterType.NON_TERMINAL) {
                                count++;
                            } else count--;
                        }
                        type = (Math.abs(count) != 2) ? 3 : 2;
                        }
                    else type = 2;
                    }
                else type = 0;
                }
            //Проверка есть ли в левой части нетерминалы
            else {
                char[] leftChar = left.toCharArray();
                int count = 0;
                for (char c: leftChar){
                    Letter letter = new Letter(String.valueOf(c));
                    if (letter.getType() == LetterType.NON_TERMINAL){
                        count++;
                    }
                }
                type = (count > 0) ? 1 : 0;
            }
            }
        }
    public boolean lookForEps(String rightRule){
        return rightRule.contains("ε");
    }
}
