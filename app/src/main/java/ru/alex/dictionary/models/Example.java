package ru.alex.dictionary.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Example {
    @SerializedName("definitions")
    @Expose
    private List<String> definitions = new ArrayList<>();
    @SerializedName("domains")
    @Expose
    private List<Domain> domains = new ArrayList<>();
    @SerializedName("notes")
    @Expose
    private List<Note> notes = new ArrayList<>();
    @SerializedName("regions")
    @Expose
    private List<Region> regions = new ArrayList<>();
    @SerializedName("registers")
    @Expose
    private List<Register> registers = new ArrayList<>();
    @SerializedName("senseIds")
    @Expose
    private List<String> senseIds = new ArrayList<>();
    @SerializedName("text")
    @Expose
    private String text;

    public List<String> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<String> definitions) {
        this.definitions = definitions;
    }

    public List<Domain> getDomains() {
        return domains;
    }

    public void setDomains(List<Domain> domains) {
        this.domains = domains;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    public List<Register> getRegisters() {
        return registers;
    }

    public void setRegisters(List<Register> registers) {
        this.registers = registers;
    }

    public List<String> getSenseIds() {
        return senseIds;
    }

    public void setSenseIds(List<String> senseIds) {
        this.senseIds = senseIds;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
