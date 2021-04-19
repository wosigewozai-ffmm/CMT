package com.seu.CMT.pojo;

import com.seu.CMT.schema.Schema;

import java.util.List;
import java.util.Map;

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
    private Map<String,String> map;

    public String getEntity(String type){
        switch (type){
            case "功效":
                return this.type;
            case "方剂":
                return this.prescription;
            case "药材":
                return this.herb;
            case "症状":
                return this.symptom;
            case "功用大类":
                return this.function_large;
            case "功用小类":
                return this.function_small;
        }
        return null;
    }

    public Model() {

    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

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
