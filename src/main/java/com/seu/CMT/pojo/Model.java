package com.seu.CMT.pojo;

import java.util.List;

public class Model {
    private long id;
    private String name;
    private List<Model> resultModels;
    private String type;

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

    public List<Model> getModels() {
        return resultModels;
    }

    public void setModels(List<Model> models) {
        this.resultModels = models;
    }
}
