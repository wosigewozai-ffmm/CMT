package com.seu.CMT.pojo;

import java.util.List;

public class Relation {
    private String nameA;
    private String nameB;
    private String relation;
    private String modifyType;
    private List<Relation> resultRelations;

    public String getModifyType() {
        return modifyType;
    }

    public void setModifyType(String modifyType) {
        this.modifyType = modifyType;
    }

    public Relation() {
    }

    public Relation(String nameA, String relation, String nameB) {
        this.nameA = nameA;
        this.nameB = nameB;
        this.relation = relation;
    }

    public String getNameA() {
        return nameA;
    }

    public void setNameA(String nameA) {
        this.nameA = nameA;
    }

    public String getNameB() {
        return nameB;
    }

    public void setNameB(String nameB) {
        this.nameB = nameB;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public List<Relation> getResultRelations() {
        return resultRelations;
    }

    public void setResultRelations(List<Relation> resultRelations) {
        this.resultRelations = resultRelations;
    }
}
