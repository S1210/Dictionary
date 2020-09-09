package ru.alex.dictionary.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Entry {
    @SerializedName("crossReferenceMarkers")
    @Expose
    private List<String> crossReferenceMarkers = new ArrayList<>();
    @SerializedName("crossReferences")
    @Expose
    private List<CrossReference> crossReferences = new ArrayList<>();
    @SerializedName("etymologies")
    @Expose
    private List<String> etymologies = new ArrayList<>();
    @SerializedName("grammaticalFeatures")
    @Expose
    private List<GrammaticalFeature> grammaticalFeatures = new ArrayList<>();
    @SerializedName("homographNumber")
    @Expose
    private String homographNumber;
    @SerializedName("inflections")
    @Expose
    private List<Inflection> inflections = new ArrayList<>();
    @SerializedName("notes")
    @Expose
    private List<Note> notes = new ArrayList<>();
    @SerializedName("pronunciations")
    @Expose
    private List<Pronunciation> pronunciations = new ArrayList<>();
    @SerializedName("senses")
    @Expose
    private List<Sense> senses = new ArrayList<>();
    @SerializedName("variantForms")
    @Expose
    private List<VariantForm> variantForms = new ArrayList<>();

    public List<String> getCrossReferenceMarkers() {
        return crossReferenceMarkers;
    }

    public void setCrossReferenceMarkers(List<String> crossReferenceMarkers) {
        this.crossReferenceMarkers = crossReferenceMarkers;
    }

    public List<CrossReference> getCrossReferences() {
        return crossReferences;
    }

    public void setCrossReferences(List<CrossReference> crossReferences) {
        this.crossReferences = crossReferences;
    }

    public List<String> getEtymologies() {
        return etymologies;
    }

    public void setEtymologies(List<String> etymologies) {
        this.etymologies = etymologies;
    }

    public List<GrammaticalFeature> getGrammaticalFeatures() {
        return grammaticalFeatures;
    }

    public void setGrammaticalFeatures(List<GrammaticalFeature> grammaticalFeatures) {
        this.grammaticalFeatures = grammaticalFeatures;
    }

    public String getHomographNumber() {
        return homographNumber;
    }

    public void setHomographNumber(String homographNumber) {
        this.homographNumber = homographNumber;
    }

    public List<Inflection> getInflections() {
        return inflections;
    }

    public void setInflections(List<Inflection> inflections) {
        this.inflections = inflections;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public List<Pronunciation> getPronunciations() {
        return pronunciations;
    }

    public void setPronunciations(List<Pronunciation> pronunciations) {
        this.pronunciations = pronunciations;
    }

    public List<Sense> getSenses() {
        return senses;
    }

    public void setSenses(List<Sense> senses) {
        this.senses = senses;
    }

    public List<VariantForm> getVariantForms() {
        return variantForms;
    }

    public void setVariantForms(List<VariantForm> variantForms) {
        this.variantForms = variantForms;
    }
}
