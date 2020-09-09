package ru.alex.dictionary.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Synonym {
    @SerializedName("domains")
    @Expose
    private List<Domain> domains = new ArrayList<>();
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("regions")
    @Expose
    private List<Region> regions = new ArrayList<>();
    @SerializedName("registers")
    @Expose
    private List<Register> registers = new ArrayList<>();
    @SerializedName("text")
    @Expose
    private String text;

    public List<Domain> getDomains() {
        return domains;
    }

    public void setDomains(List<Domain> domains) {
        this.domains = domains;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
