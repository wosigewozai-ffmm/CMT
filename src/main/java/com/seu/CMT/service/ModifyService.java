package com.seu.CMT.service;

import com.seu.CMT.pojo.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ModifyService {
    ResultDTO<ExcelData> addExcel(MultipartFile file) throws IOException;
    List<Model> getAllEffect();
    List<Model> getAllPrescription();
    ResultDTO<Model> add(Model model);
    ResultDTO<Relation> addRelation(Relation relation);

    ResultDTO<Model> deleteEntity(Model model);

    ResultDTO<Relation> deleteRelation(Relation relation);

    ResultDTO<Model> searchModifyEntity(Model model);

    ResultDTO<Model> modifyEntity(Model model);

    ResultDTO<Relation> searchByEntity(Model model);

    ResultDTO<Relation> modifyRelation(Relation relation);
}
