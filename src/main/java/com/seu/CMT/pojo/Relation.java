package com.seu.CMT.pojo;

import java.util.List;

public class Relation {
    private String nameA;
    private String nameB;
    private String relation;
    private List<Relation> relations;

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

    public List<Relation> getRelations() {
        return relations;
    }

    public void setRelations(List<Relation> Relations) {
        this.relations = Relations;
    }
}
