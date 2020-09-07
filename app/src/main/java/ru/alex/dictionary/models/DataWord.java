package ru.alex.dictionary.models;

import ru.alex.dictionary.contractors.MainContractor;
import ru.alex.dictionary.presenters.MainPresenter;
import ru.alex.dictionary.services.CallbackTask;

public class DataWord implements MainContractor.Repository {

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

    @Override
    public void getWords(MainPresenter mainPresenter, String apiID, String apiKey, String word) {
        new CallbackTask(mainPresenter, apiID, apiKey).execute(dictionaryEntries(word));
    }

    private String dictionaryEntries(String word) {
        final String language = "en-gb";
        final String strictMatch = "false";
        final String word_id = word.toLowerCase();
        return "https://od-api.oxforddictionaries.com:443/api/v2/entries/" + language + "/" + word_id + "?" + "&strictMatch=" + strictMatch;
    }
}
