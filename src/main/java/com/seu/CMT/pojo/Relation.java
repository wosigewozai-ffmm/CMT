package com.seu.CMT.pojo;

import java.util.List;

public class Relation {
    private String nameA;
    private String nameB;
    private String relation;
    private String nameA_old;
    private String nameB_old;
    private  int ties;

    public int getTies() {
        return ties;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }

    public String getNameA_old() {
        return nameA_old;
    }

    public void setNameA_old(String nameA_old) {
        this.nameA_old = nameA_old;
    }

    public String getNameB_old() {
        return nameB_old;
    }

    public void setNameB_old(String nameB_old) {
        this.nameB_old = nameB_old;
    }

    public String getRelation_old() {
        return relation_old;
    }

    public void setRelation_old(String relation_old) {
        this.relation_old = relation_old;
    }

    private String relation_old;
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
