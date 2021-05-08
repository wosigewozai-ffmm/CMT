package com.seu.CMT.pojo;

import java.util.List;

public class InitialData {
    List<String> relationList;
    List<String> entityList;
    List<List<String>> schemaList;

    public List<List<String>> getSchemaList() {
        return schemaList;
    }

    public void setSchemaList(List<List<String>> schemaList) {
        this.schemaList = schemaList;
    }

    public List<String> getRelationList() {
        return relationList;
    }

    public void setRelationList(List<String> relationList) {
        this.relationList = relationList;
    }

    public List<String> getEntityList() {
        return entityList;
    }

    public void setEntityList(List<String> entityList) {
        this.entityList = entityList;
    }
}
