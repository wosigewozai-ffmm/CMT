package com.seu.CMT.pojo;

import java.util.List;

public class PrescriptionModel {
    private int id;
    private String name;
    private List<PrescriptionModel> prescriptionModels;

    public List<PrescriptionModel> getPrescriptionModels() {
        return prescriptionModels;
    }

    public void setPrescriptionModels(List<PrescriptionModel> prescriptionModels) {
        this.prescriptionModels = prescriptionModels;
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
