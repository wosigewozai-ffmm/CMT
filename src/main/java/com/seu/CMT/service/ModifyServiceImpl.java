package com.seu.CMT.service;

import com.seu.CMT.mapper.ModifyMapper;
import com.seu.CMT.pojo.*;
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
            resultDTO.setMsg("entity duplicate");
            resultDTO.setCode(0);
        }else{
            int i = modifyMapper.add(model);
            resultDTO.setCode(i);
            resultDTO.setMsg("success");
        }
        return resultDTO;
    }

    @Override
    public int addRelation(Relation relation) {
        int i = modifyMapper.addRelation(relation);
        return i;
    }
}
