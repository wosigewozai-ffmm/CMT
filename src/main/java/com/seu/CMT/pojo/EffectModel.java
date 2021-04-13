package com.seu.CMT.pojo;

import java.util.List;

public class EffectModel {
    private int id;
    private String name;
    private List<EffectModel> effectModels;

    public List<EffectModel> getEffectModels() {
        return effectModels;
    }

    public void setEffectModels(List<EffectModel> effectModels) {
        this.effectModels = effectModels;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
