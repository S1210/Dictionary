package ru.alex.dictionary.models;

public class DataWord {

    private String word;
    private String dialect;
    private String example;
    private String definitions;
    private String otherForms;
    private String link;

    public DataWord() {
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDialect() {
        return dialect;
    }

    public void setDialect(String dialect) {
        this.dialect = dialect;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getDefinitions() {
        return definitions;
    }

    public void setDefinitions(String definitions) {
        this.definitions = definitions;
    }

    public String getOtherForms() {
        return otherForms;
    }

    public void setOtherForms(String otherForms) {
        this.otherForms = otherForms;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
