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
import java.util.Map;

@Service("modifyService")
@Transactional

public class ModifyServiceImpl implements ModifyService {
    @Resource
    ModifyMapper modifyMapper;

    Schema schema = new Schema();

    public ModifyServiceImpl() throws IOException {
    }

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
        List<Model> models = modifyMapper.getAll("方剂");
        return models;
    }

    @Override
    public ResultDTO<Model> add(Model model) {
        ResultDTO<Model> resultDTO = new ResultDTO<>();
        List<Model> models = modifyMapper.find(model.getName());
        if (models.size()>0){
            resultDTO.setMsg("entity duplicate");
            resultDTO.setCode(0);
        }else{
            int i = modifyMapper.add(model);
            String[][] schemaMap = schema.getRelation();
            for (String key : schema.getMap().keySet()){
                if (schemaMap[schema.relationMap(model.getType()
                )][schema.relationMap(key)]!= null){
                    Relation relation = new Relation(model.getName(),schemaMap[schema.relationMap(model.getType()
                    )][schema.relationMap(key)],model.getEntity(key));
                    if (relation.getNameB()!=null)
                        i = modifyMapper.addRelation(relation);
                }
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
            relationResultDTO.setMsg("relation duplicate");
            relationResultDTO.setCode(0);
        }else{
            int i = modifyMapper.addRelation(relation);
            relationResultDTO.setCode(i);
            relationResultDTO.setMsg("success");
        }
        return relationResultDTO;
    }

    @Override
    public ResultDTO<Model> deleteEntity(Model model) {
        ResultDTO<Model> resultDTO = new ResultDTO<>();
        int i = modifyMapper.deleteEntity(model);
        if (i == 1){
            resultDTO.setMsg("success");
        }else{
            resultDTO.setMsg("ERROR");
        }
        return resultDTO;
    }

    @Override
    public ResultDTO<Relation> deleteRelation(Relation relation) {
        ResultDTO<Relation> resultDTO = new ResultDTO<>();
        int i = modifyMapper.deleteRelation(relation);
        if (i == 1){
            resultDTO.setMsg("success");
        }else{
            resultDTO.setMsg("error");
        }
        return resultDTO;
    }

    String searchString =  new String();

    @Override
    public ResultDTO<Model> searchModifyEntity(Model model) {
        ResultDTO<Model> resultDTO =  new ResultDTO<>();
        List<Model> result = modifyMapper.find(model.getName());
        if (result.size() == 0){
            resultDTO.setMsg("No entity found");
        }else {
            searchString = result.get(0).getName();
            resultDTO.setData(result);
        }
        return resultDTO;
    }

    @Override
    public ResultDTO<Model> modifyEntity(Model model) {
        ResultDTO<Model> resultDTO =  new ResultDTO<>();
        List<Model> models = modifyMapper.find(model.getName());
        if ((models.size()>0) && (!model.getName().equals(searchString))){
            resultDTO.setMsg("实体名已经存在");
        }else{
            List<Relation> relations = modifyMapper.findEntityRelation(model);
            boolean flag = true;
            String[][] schemaMap = schema.getRelation();
            for (int i=0;i<relations.size();i++){
                Relation relation = relations.get(i);
                if (relation.getNameA().equals(model.getName())){
                    Model model1 = modifyMapper.find(relation.getNameB()).get(0);
                    if ((schemaMap[schema.relationMap(model.getType())][schema.relationMap(model1.getType())]!=null)&&(!schemaMap[schema.relationMap(model.getType())][schema.relationMap(model1.getType())].equals(relation.getRelation()))){
                        flag = false;
                        resultDTO.setMsg("新类型不合法");
                        break;
                    }
                }else{
                    Model model1 = modifyMapper.find(relation.getNameA()).get(0);
                    if ((schemaMap[schema.relationMap(model1.getType())][schema.relationMap(model.getType())]!=null)&&(!schemaMap[schema.relationMap(model1.getType())][schema.relationMap(model.getType())].equals(relation.getRelation()))){
                        flag = false;
                        resultDTO.setMsg("新类型不合法");
                        break;
                    }
                }
            }
            if (flag){
                int i = modifyMapper.updateEntity(model);
                resultDTO.setMsg("success");
            }
        }
        return resultDTO;
    }

    @Override
    public ResultDTO<Relation> searchByEntity(Model model) {
        ResultDTO<Relation> resultDTO = new ResultDTO<>();
        resultDTO.setData(modifyMapper.findEntityRelation(model));
        return resultDTO;
    }

    @Override
    public ResultDTO<Relation> modifyRelation(Relation relation) {
        ResultDTO<Relation> resultDTO = new ResultDTO<>();
        String[][] schemaMap = schema.getRelation();
        switch (relation.getModifyType()){
            case "1":
                if (modifyMapper.find(relation.getNameA()).size() > 0 ){
                    Model modelA = modifyMapper.find(relation.getNameA()).get(0);
                    int typeA = schema.relationMap(modelA.getType());
                    Model modelB = modifyMapper.find(relation.getNameB_old()).get(0);
                    int typeB = schema.relationMap(modelB.getType());
                    if (schemaMap[typeA][typeB].equals(relation.getRelation_old())){
                        int i = modifyMapper.deleteOldRelation(relation);
                        if (i==0){
                            resultDTO.setMsg("删除关系失败");
                        }
                        i = modifyMapper.addRelation(relation);
                        if (i==0){
                            resultDTO.setMsg("新增关系失败");
                        }else{
                            resultDTO.setMsg("更新成功");
                        }
                    }else{
                        resultDTO.setMsg("新关系不合法");
                    }
                }else{
                    resultDTO.setMsg("新实体不存在");
                }
                break;
            case "2":
                Model modelA = modifyMapper.find(relation.getNameA_old()).get(0);
                int typeA = schema.relationMap(modelA.getType());
                Model modelB = modifyMapper.find(relation.getNameB_old()).get(0);
                int typeB = schema.relationMap(modelB.getType());
                if (schemaMap[typeA][typeB].equals(relation.getRelation())){
                    int i =modifyMapper.updateRelation(relation);
                    if (i == 0){
                        resultDTO.setMsg("修改失败");
                    }else{
                        resultDTO.setMsg("修改成功");
                    }
                }else{
                    resultDTO.setMsg("新关系不合法");
                }
                break;
            case "3":
                if (modifyMapper.find(relation.getNameB()).size() > 0 ){
                    modelA = modifyMapper.find(relation.getNameA_old()).get(0);
                    typeA = schema.relationMap(modelA.getType());
                    modelB = modifyMapper.find(relation.getNameB()).get(0);
                    typeB = schema.relationMap(modelB.getType());
                    if (schemaMap[typeA][typeB].equals(relation.getRelation_old())){
                        int i = modifyMapper.deleteOldRelation(relation);
                        if (i==0){
                            resultDTO.setMsg("删除关系失败");
                        }
                        i = modifyMapper.addRelation(relation);
                        if (i==0){
                            resultDTO.setMsg("新增关系失败");
                        }else{
                            resultDTO.setMsg("更新成功");
                        }
                    }else{
                        resultDTO.setMsg("新关系不合法");
                    }
                }else{
                    resultDTO.setMsg("新实体不存在");
                }
                break;
        }

        return resultDTO;
    }

    @Override
    public ResultDTO<Relation> searchByRelation(Relation relation) {
        ResultDTO<Relation> resultDTO =  new ResultDTO<>();
        resultDTO.setData(modifyMapper.findRelationRelation(relation));
        return resultDTO;
    }

    @Override
    public ResultDTO<ExcelData> addExcelEntity(ExcelData excelData) {
        ResultDTO<ExcelData> resultDTO = new ResultDTO<>();
        String fileName = new String();
        for (int i = excelData.getName().lastIndexOf("\\") + 1; i < excelData.getName().length();i++){
            fileName += excelData.getName().charAt(i);
        }
        int i = modifyMapper.addExcelEntity(fileName);
        if (i==1)
            resultDTO.setMsg("success");
        else{
            resultDTO.setMsg("error");
        }
        return resultDTO;
    }

    @Override
    public ResultDTO<ExcelData> addExcelRelation(ExcelData excelData) {
        ResultDTO<ExcelData> resultDTO = new ResultDTO<>();
        String fileName = new String();
        for (int i = excelData.getName().lastIndexOf("\\") + 1; i < excelData.getName().length();i++){
            fileName += excelData.getName().charAt(i);
        }
        int i = modifyMapper.addExcelRelation(fileName, excelData.getRelation());
        if (i==1)
            resultDTO.setMsg("success");
        else{
            resultDTO.setMsg("error");
        }
        return resultDTO;
    }

    @Override
    public ResultDTO<Relation> entityStrength(Relation relation) {
        ResultDTO<Relation> resultDTO = new ResultDTO<>();
        //查询关系是否存在
        if (modifyMapper.findStrengthRelation(relation).size()>0){
            //如果存在，update+1
            Relation newRelation = modifyMapper.findStrengthRelation(relation).get(0);
            newRelation.setTies(newRelation.getTies() + 1);
            modifyMapper.updateStrengthRelation(newRelation);
        }else{
            //不存在，新增关系
            modifyMapper.addStrengthRelation(relation);
        }
        return resultDTO;
    }
}
