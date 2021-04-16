package com.seu.CMT.pojo;

import java.util.List;

public class Model {
    private long id;
    private String name;
    private List<Model> resultModels;
    private String type;
    private String effect;
    private String herb;
    private String prescription;
    private String symptom;
    private String function_large;
    private String function_small;

    public List<Model> getResultModels() {
        return resultModels;
    }

    public void setResultModels(List<Model> resultModels) {
        this.resultModels = resultModels;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getHerb() {
        return herb;
    }

    public void setHerb(String herb) {
        this.herb = herb;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getFunction_large() {
        return function_large;
    }

    public void setFunction_large(String function_large) {
        this.function_large = function_large;
    }

    public String getFunction_small() {
        return function_small;
    }

    public void setFunction_small(String function_small) {
        this.function_small = function_small;
    }

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
