package com.seu.CMT.service;

import com.seu.CMT.pojo.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ModifyService {
    ResultDTO<ExcelData> addExcel(MultipartFile file) throws IOException;
    List<Model> getAllEffect();
    List<Model> getAllPrescription();
    int add(Model model);
    int addRelation(Relation relation);
}
