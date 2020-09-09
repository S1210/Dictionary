package ru.alex.dictionary.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Pronunciation {
    @SerializedName("audioFile")
    @Expose
    private String audioFile;
    @SerializedName("dialects")
    @Expose
    private List<String> dialects = new ArrayList<>();
    @SerializedName("phoneticNotation")
    @Expose
    private String phoneticNotation;
    @SerializedName("phoneticSpelling")
    @Expose
    private String phoneticSpelling;
    @SerializedName("regions")
    @Expose
    private List<Region> regions = new ArrayList<>();
    @SerializedName("registers")
    @Expose
    private List<Register> registers = new ArrayList<>();

    public String getAudioFile() {
        return audioFile;
    }

    public void setAudioFile(String audioFile) {
        this.audioFile = audioFile;
    }

    public List<String> getDialects() {
        return dialects;
    }

    public void setDialects(List<String> dialects) {
        this.dialects = dialects;
    }

    public String getPhoneticNotation() {
        return phoneticNotation;
    }

    public void setPhoneticNotation(String phoneticNotation) {
        this.phoneticNotation = phoneticNotation;
    }

    public String getPhoneticSpelling() {
        return phoneticSpelling;
    }

    public void setPhoneticSpelling(String phoneticSpelling) {
        this.phoneticSpelling = phoneticSpelling;
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
}
