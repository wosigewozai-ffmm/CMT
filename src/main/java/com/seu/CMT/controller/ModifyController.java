package com.seu.CMT.controller;

import com.seu.CMT.mapper.ModifyMapper;
import com.seu.CMT.pojo.*;
import com.seu.CMT.service.ModifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping({"modify"})

public class ModifyController {
    @Autowired
    ModifyService modifyService;
//    @Autowired
//    private ModifyMapper modifyMapper;

    public ModifyController(){
    }
/*
    @GetMapping("/getAll")
    public List<UserModel> getAll() {
        List<UserModel> models = modifyMapper.getAll();
        return models;
    }
*/
    @GetMapping("/getAllEffect")
    public List<EffectModel> getAllEffect(){
        List<EffectModel> models = modifyService.getAllEffect();
        return models;
    }

    @GetMapping("/getAllPrescription")
    public List<PrescriptionModel> getAllPrescription(){
        List<PrescriptionModel> models = modifyService.getAllPrescription();
        return models;
    }

    @RequestMapping("/addEffect")
    public int addEffect(@RequestBody EffectModel model) {
        System.out.println(model);
        int i = modifyService.addEffect(model);
        return i;
    }

    @RequestMapping("/addPrescription")
    public int addPrescription(@RequestBody PrescriptionModel model) {
        System.out.println(model);
        int i = modifyService.addPrescription(model);
        return i;
    }

    @RequestMapping("/addExcel")
    @ResponseBody
    public ResultDTO<ExcelData> addExcel(@RequestParam("fileName")MultipartFile file) throws Exception{
        ResultDTO<ExcelData> resultDTO= modifyService.addExcel(file);
        return resultDTO;
    }
}
