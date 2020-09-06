package ru.alex.dictionary.models;

import ru.alex.dictionary.contractors.MainContractor;

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
}
