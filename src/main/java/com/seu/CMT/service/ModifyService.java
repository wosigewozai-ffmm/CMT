package com.seu.CMT.service;

import com.seu.CMT.pojo.EffectModel;
import com.seu.CMT.pojo.ExcelData;
import com.seu.CMT.pojo.PrescriptionModel;
import com.seu.CMT.pojo.ResultDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ModifyService {
    ResultDTO<ExcelData> addExcel(MultipartFile file) throws IOException;
    List<EffectModel> getAllEffect();
    List<PrescriptionModel> getAllPrescription();
    int addEffect(EffectModel effectModel);
    int addPrescription(PrescriptionModel prescriptionModel);
}
