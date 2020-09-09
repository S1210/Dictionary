package ru.alex.dictionary.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Sense {
    @SerializedName("antonyms")
    @Expose
    private List<Antonym> antonyms = new ArrayList<>();
    @SerializedName("constructions")
    @Expose
    private List<Construction> constructions = new ArrayList<>();
    @SerializedName("crossReferenceMarkers")
    @Expose
    private List<String> crossReferenceMarkers = new ArrayList<>();
    @SerializedName("crossReferences")
    @Expose
    private List<CrossReference> crossReferences = new ArrayList<>();
    @SerializedName("definitions")
    @Expose
    private List<String> definitions = new ArrayList<>();
    @SerializedName("domainClasses")
    @Expose
    private List<DomainClass> domainClasses = new ArrayList<>();
    @SerializedName("domains")
    @Expose
    private List<Domain> domains = new ArrayList<>();
    @SerializedName("etymologies")
    @Expose
    private List<String> etymologies = new ArrayList<>();
    @SerializedName("examples")
    @Expose
    private List<Example> examples = new ArrayList<>();
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("inflections")
    @Expose
    private List<Inflection> inflections = new ArrayList<>();
    @SerializedName("notes")
    @Expose
    private List<Note> notes = new ArrayList<>();
    @SerializedName("pronunciations")
    @Expose
    private List<Pronunciation> pronunciations = new ArrayList<>();
    @SerializedName("regions")
    @Expose
    private List<Region> regions = new ArrayList<>();
    @SerializedName("registers")
    @Expose
    private List<Register> registers = new ArrayList<>();
    @SerializedName("semanticClasses")
    @Expose
    private List<SemanticClass> semanticClasses = new ArrayList<>();
    @SerializedName("shortDefinitions")
    @Expose
    private List<String> shortDefinitions = new ArrayList<>();
    @SerializedName("subsenses")
    @Expose
    private List<Subsense> subsenses = new ArrayList<>();
    @SerializedName("synonyms")
    @Expose
    private List<Synonym> synonyms = new ArrayList<>();
    @SerializedName("thesaurusLinks")
    @Expose
    private List<ThesaurusLink> thesaurusLinks = new ArrayList<>();
    @SerializedName("variantForms")
    @Expose
    private List<VariantForm> variantForms = new ArrayList<>();

    public List<Antonym> getAntonyms() {
        return antonyms;
    }

    public void setAntonyms(List<Antonym> antonyms) {
        this.antonyms = antonyms;
    }

    public List<Construction> getConstructions() {
        return constructions;
    }

    public void setConstructions(List<Construction> constructions) {
        this.constructions = constructions;
    }

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

    public List<String> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<String> definitions) {
        this.definitions = definitions;
    }

    public List<DomainClass> getDomainClasses() {
        return domainClasses;
    }

    public void setDomainClasses(List<DomainClass> domainClasses) {
        this.domainClasses = domainClasses;
    }

    public List<Domain> getDomains() {
        return domains;
    }

    public void setDomains(List<Domain> domains) {
        this.domains = domains;
    }

    public List<String> getEtymologies() {
        return etymologies;
    }

    public void setEtymologies(List<String> etymologies) {
        this.etymologies = etymologies;
    }

    public List<Example> getExamples() {
        return examples;
    }

    public void setExamples(List<Example> examples) {
        this.examples = examples;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<SemanticClass> getSemanticClasses() {
        return semanticClasses;
    }

    public void setSemanticClasses(List<SemanticClass> semanticClasses) {
        this.semanticClasses = semanticClasses;
    }

    public List<String> getShortDefinitions() {
        return shortDefinitions;
    }

    public void setShortDefinitions(List<String> shortDefinitions) {
        this.shortDefinitions = shortDefinitions;
    }

    public List<Subsense> getSubsenses() {
        return subsenses;
    }

    public void setSubsenses(List<Subsense> subsenses) {
        this.subsenses = subsenses;
    }

    public List<Synonym> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<Synonym> synonyms) {
        this.synonyms = synonyms;
    }

    public List<ThesaurusLink> getThesaurusLinks() {
        return thesaurusLinks;
    }

    public void setThesaurusLinks(List<ThesaurusLink> thesaurusLinks) {
        this.thesaurusLinks = thesaurusLinks;
    }

    public List<VariantForm> getVariantForms() {
        return variantForms;
    }

    public void setVariantForms(List<VariantForm> variantForms) {
        this.variantForms = variantForms;
    }
}
