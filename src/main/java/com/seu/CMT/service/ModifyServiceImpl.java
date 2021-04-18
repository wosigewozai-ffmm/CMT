package com.seu.CMT.service;

import com.seu.CMT.mapper.ModifyMapper;
import com.seu.CMT.pojo.*;
import com.seu.CMT.schema.Schema;
import org.apache.ibatis.jdbc.Null;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service("modifyService")
@Transactional

public class ModifyServiceImpl implements ModifyService {
    @Resource
    ModifyMapper modifyMapper;

    Schema schema = new Schema();

    @Override
    public ResultDTO<ExcelData> addExcel(MultipartFile file) throws IOException {
        ResultDTO<ExcelData> resultDTO = new ResultDTO<>();
        System.out.println("addExcel");
        String fileName = file.getOriginalFilename();
        ClassPathResource resource = new ClassPathResource("");
        String projectPath = resource.getFile().getAbsolutePath()+"\\static\\excel";
        String path = projectPath + "\\" + fileName;
        System.out.println(path);
        File dest = new File(path);
        try{
            file.transferTo(dest);
            resultDTO.setMsg("success");
            resultDTO.setCode(200);
        }catch (IllegalStateException | IOException e){
            e.printStackTrace();
            resultDTO.setMsg("unsuccessful");
            resultDTO.setCode(0);
        }
        return resultDTO;
    }

    @Override
    public List<Model> getAllEffect() {
        List<Model> models = modifyMapper.getAll("effect");
        return models;
    }

    @Override
    public List<Model> getAllPrescription() {
        List<Model> models = modifyMapper.getAll("prescription");
        return models;
    }

    @Override
    public ResultDTO<Model> add(Model model) {
        ResultDTO<Model> resultDTO = new ResultDTO<>();
        List<Model> models = modifyMapper.find(model.getName());
        if (models.size()>0){
            resultDTO.setMsg("relation duplicate");
            resultDTO.setCode(0);
        }else{
            int i = modifyMapper.add(model);
            String[][] schemaMap = schema.getRelation();
            if (schemaMap[schema.relationMap(model.getType()
            )][schema.relationMap("功效")]!= null){
                Relation relation = new Relation(model.getName(),schemaMap[schema.relationMap(model.getType()
                )][schema.relationMap("功效")],model.getEffect());
                if (relation.getNameB()!=null)
                    i = modifyMapper.addRelation(relation);
            }
            if (schemaMap[schema.relationMap(model.getType()
            )][schema.relationMap("方剂")]!= null){
                Relation relation = new Relation(model.getName(),schemaMap[schema.relationMap(model.getType()
                )][schema.relationMap("方剂")],model.getPrescription());
                if (relation.getNameB()!=null)
                    i = modifyMapper.addRelation(relation);
            }
            if (schemaMap[schema.relationMap(model.getType()
            )][schema.relationMap("药材")]!= null){
                Relation relation = new Relation(model.getName(),schemaMap[schema.relationMap(model.getType()
                )][schema.relationMap("药材")],model.getHerb());
                if (relation.getNameB()!=null)
                    i = modifyMapper.addRelation(relation);
            }
            if (schemaMap[schema.relationMap(model.getType()
            )][schema.relationMap("症状")]!= null){
                Relation relation = new Relation(model.getName(),schemaMap[schema.relationMap(model.getType()
                )][schema.relationMap("症状")],model.getSymptom());
                if (relation.getNameB()!=null)
                    i = modifyMapper.addRelation(relation);
            }
            if (schemaMap[schema.relationMap(model.getType()
            )][schema.relationMap("功用大类")]!= null){
                Relation relation = new Relation(model.getName(),schemaMap[schema.relationMap(model.getType()
                )][schema.relationMap("功用大类")],model.getFunction_large());
                if (relation.getNameB()!=null)
                    i = modifyMapper.addRelation(relation);
            }
            if (schemaMap[schema.relationMap(model.getType()
            )][schema.relationMap("功用小类")]!= null){
                Relation relation = new Relation(model.getName(),schemaMap[schema.relationMap(model.getType()
                )][schema.relationMap("功用小类")],model.getFunction_small());
                if (relation.getNameB()!=null)
                    i = modifyMapper.addRelation(relation);
            }
            resultDTO.setCode(i);
            resultDTO.setMsg("success");
        }
        return resultDTO;
    }

    @Override
    public ResultDTO<Relation> addRelation(Relation relation) {
        ResultDTO<Relation> relationResultDTO = new ResultDTO<>();
        List<Model> relationModels = modifyMapper.findRelation(relation);
        if (relationModels.size()>0){
            relationResultDTO.setMsg("entity duplicate");
            relationResultDTO.setCode(0);
        }else{
            int i = modifyMapper.addRelation(relation);
            relationResultDTO.setCode(i);
            relationResultDTO.setMsg("success");
        }
        return relationResultDTO;
    }
}
