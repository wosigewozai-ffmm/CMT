package com.seu.CMT.service;

import com.seu.CMT.mapper.ModifyMapper;
import com.seu.CMT.pojo.EffectModel;
import com.seu.CMT.pojo.ExcelData;
import com.seu.CMT.pojo.PrescriptionModel;
import com.seu.CMT.pojo.ResultDTO;
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
    public List<EffectModel> getAllEffect() {
        List<EffectModel> models = modifyMapper.getAllEffect();
        return models;
    }

    @Override
    public List<PrescriptionModel> getAllPrescription() {
        List<PrescriptionModel> models = modifyMapper.getAllPrescription();
        return models;
    }

    @Override
    public int addEffect(EffectModel effectModel) {
        int i = modifyMapper.addEffect(effectModel);
        return i;
    }

    @Override
    public int addPrescription(PrescriptionModel prescriptionModel) {
        int i = modifyMapper.addPrescription(prescriptionModel);
        return i;
    }
}
