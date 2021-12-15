public enum LanguageType {


    ZERO("0 типа"),
    CONTEXT_SENSITIVE("Контекстно-зависимая"),
    CONTEXT_FREE("Контекстно-свободная"),
    REGULAR("Регулярная");

    private final String definition;

    LanguageType(String definition) {
        this.definition = definition;
    }

    public String getDefinition() {
        return definition;
    }
}
