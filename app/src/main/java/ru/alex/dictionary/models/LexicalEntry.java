package ru.alex.dictionary.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class LexicalEntry {
    @SerializedName("compounds")
    @Expose
    private List<Compound> compounds = new ArrayList<>();
    @SerializedName("derivativeOf")
    @Expose
    private List<DerivativeOf> derivativeOf = new ArrayList<>();
    @SerializedName("derivatives")
    @Expose
    private List<Derivative> derivatives = new ArrayList<>();
    @SerializedName("entries")
    @Expose
    private List<Entry> entries = new ArrayList<>();
    @SerializedName("grammaticalFeatures")
    @Expose
    private List<GrammaticalFeature> grammaticalFeatures = new ArrayList<>();
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("lexicalCategory")
    @Expose
    private LexicalCategory lexicalCategory;
    @SerializedName("notes")
    @Expose
    private List<Note> notes = new ArrayList<>();
    @SerializedName("phrasalVerbs")
    @Expose
    private List<PhrasalVerb> phrasalVerbs = new ArrayList<>();
    @SerializedName("phrases")
    @Expose
    private List<Phrase> phrases = new ArrayList<>();
    @SerializedName("pronunciations")
    @Expose
    private List<Pronunciation> pronunciations = new ArrayList<>();
    @SerializedName("root")
    @Expose
    private String root;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("variantForms")
    @Expose
    private List<VariantForm> variantForms = new ArrayList<>();

    public List<Compound> getCompounds() {
        return compounds;
    }

    public void setCompounds(List<Compound> compounds) {
        this.compounds = compounds;
    }

    public List<DerivativeOf> getDerivativeOf() {
        return derivativeOf;
    }

    public void setDerivativeOf(List<DerivativeOf> derivativeOf) {
        this.derivativeOf = derivativeOf;
    }

    public List<Derivative> getDerivatives() {
        return derivatives;
    }

    public void setDerivatives(List<Derivative> derivatives) {
        this.derivatives = derivatives;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    public List<GrammaticalFeature> getGrammaticalFeatures() {
        return grammaticalFeatures;
    }

    public void setGrammaticalFeatures(List<GrammaticalFeature> grammaticalFeatures) {
        this.grammaticalFeatures = grammaticalFeatures;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public LexicalCategory getLexicalCategory() {
        return lexicalCategory;
    }

    public void setLexicalCategory(LexicalCategory lexicalCategory) {
        this.lexicalCategory = lexicalCategory;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public List<PhrasalVerb> getPhrasalVerbs() {
        return phrasalVerbs;
    }

    public void setPhrasalVerbs(List<PhrasalVerb> phrasalVerbs) {
        this.phrasalVerbs = phrasalVerbs;
    }

    public List<Phrase> getPhrases() {
        return phrases;
    }

    public void setPhrases(List<Phrase> phrases) {
        this.phrases = phrases;
    }

    public List<Pronunciation> getPronunciations() {
        return pronunciations;
    }

    public void setPronunciations(List<Pronunciation> pronunciations) {
        this.pronunciations = pronunciations;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<VariantForm> getVariantForms() {
        return variantForms;
    }

    public void setVariantForms(List<VariantForm> variantForms) {
        this.variantForms = variantForms;
    }
}
