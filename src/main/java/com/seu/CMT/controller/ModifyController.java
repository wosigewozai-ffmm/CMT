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
    @ResponseBody
    public ResultDTO<Model> addEntity(@RequestBody Model model) {
        ResultDTO<Model> resultDTO = new ResultDTO<>();
        resultDTO = modifyService.add(model);
        return resultDTO;
    }

    @RequestMapping("/addExcel")
    @ResponseBody
    public ResultDTO<ExcelData> addExcel(@RequestParam("fileName")MultipartFile file) throws Exception{
        ResultDTO<ExcelData> resultDTO= modifyService.addExcel(file);
        return resultDTO;
    }

    @RequestMapping("/addRelation")
    @ResponseBody
    public ResultDTO<Relation> addRelation(@RequestBody Relation relation){
        System.out.println(relation);
        ResultDTO<Relation> resultDTO = new ResultDTO<>();
        resultDTO = modifyService.addRelation(relation);
        return resultDTO;
    }
}
