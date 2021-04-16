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
    public List<Model> getAllEffect(){
        List<Model> models = modifyService.getAllEffect();
        return models;
    }

    @GetMapping("/getAllPrescription")
    public List<Model> getAllPrescription(){
        List<Model> models = modifyService.getAllPrescription();
        return models;
    }

    @RequestMapping("/add")
    public int addEffect(@RequestBody Model model) {
        int i = modifyService.add(model);
        return i;
    }

    @RequestMapping("/addExcel")
    @ResponseBody
    public ResultDTO<ExcelData> addExcel(@RequestParam("fileName")MultipartFile file) throws Exception{
        ResultDTO<ExcelData> resultDTO= modifyService.addExcel(file);
        return resultDTO;
    }

    @RequestMapping("/addRelation")
    public int hasEffect(@RequestBody Relation relation){
        System.out.println(relation);
        int i = modifyService.addRelation(relation);
        return i;
    }
}
