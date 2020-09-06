package ru.alex.dictionary.models;

import ru.alex.dictionary.contractors.MainContractor;
import ru.alex.dictionary.presenters.MainPresenter;
import ru.alex.dictionary.services.CallbackTask;

public class DataWord implements MainContractor.Repository {

    private String word;
    private String description;
    private String link;

    public DataWord() {
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        final String fields = "pronunciations";
        final String strictMatch = "false";
        final String word_id = word.toLowerCase();
        return "https://od-api.oxforddictionaries.com:443/api/v2/entries/" + language + "/" + word_id + "?" + "fields=" + fields + "&strictMatch=" + strictMatch;
    }
}
