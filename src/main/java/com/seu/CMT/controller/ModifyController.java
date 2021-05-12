package com.seu.CMT.controller;

import com.seu.CMT.mapper.ModifyMapper;
import com.seu.CMT.pojo.*;
import com.seu.CMT.schema.Schema;
import com.seu.CMT.service.ModifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.transform.Result;
import java.io.IOException;
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

    @RequestMapping("/getAllPrescription")
    @ResponseBody
    public ResultDTO<Model> getAllPrescription(){
        ResultDTO<Model> resultDTO = new ResultDTO<>();
        List<Model> models = modifyService.getAllPrescription();
        resultDTO.setData(models);
        return resultDTO;
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

    @RequestMapping("/addExcelEntity")
    @ResponseBody
    public ResultDTO<ExcelData> addExcelEntity(@RequestBody ExcelData excelData) throws Exception{
        ResultDTO<ExcelData> resultDTO= modifyService.addExcelEntity(excelData);
        return resultDTO;
    }

    @RequestMapping("/addExcelRelation")
    @ResponseBody
    public ResultDTO<ExcelData> addExcelRelation(@RequestBody ExcelData excelData) throws Exception{
        ResultDTO<ExcelData> resultDTO= modifyService.addExcelRelation(excelData);
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

    @RequestMapping("/deleteEntity")
    @ResponseBody
    public ResultDTO<Model> deleteEntity(@RequestBody Model model){
        ResultDTO<Model> resultDTO = new ResultDTO<>();
        resultDTO = modifyService.deleteEntity(model);
        return resultDTO;
    }

    @RequestMapping("/deleteRelation")
    @ResponseBody
    public ResultDTO<Relation> deleteRelation(@RequestBody Relation relation){
        ResultDTO<Relation> resultDTO = new ResultDTO<>();
        resultDTO = modifyService.deleteRelation(relation);
        return  resultDTO;
    }

    @RequestMapping("/searchModifyEntity")
    @ResponseBody
    public ResultDTO<Model> searchModifyEntity(@RequestBody Model model){
        ResultDTO<Model> resultDTO =  new ResultDTO<>();
        resultDTO = modifyService.searchModifyEntity(model);
        return resultDTO;
    }

    @RequestMapping("/modifyEntity")
    @ResponseBody
    public ResultDTO<Model> modifyEntity(@RequestBody Model model){
        ResultDTO<Model> resultDTO = new ResultDTO<>();
        resultDTO = modifyService.modifyEntity(model);
        return resultDTO;
    }

    @RequestMapping("/searchByEntity")
    @ResponseBody
    public  ResultDTO<Relation> searchByEntity(@RequestBody Model model){
        ResultDTO<Relation> resultDTO =  new ResultDTO<>();
        resultDTO = modifyService.searchByEntity(model);
        return  resultDTO;
    }

    @RequestMapping("/modifyRelation")
    @ResponseBody
    public  ResultDTO<Relation> modifyRelation(@RequestBody Relation relation){
        ResultDTO<Relation> resultDTO =  new ResultDTO<>();
        resultDTO = modifyService.modifyRelation(relation);
        return  resultDTO;
    }

    @RequestMapping("/searchByRelation")
    @ResponseBody
    public  ResultDTO<Relation> searchByRelation(@RequestBody Relation relation){
        ResultDTO<Relation> resultDTO =  new ResultDTO<>();
        resultDTO = modifyService.searchByRelation(relation);
        return  resultDTO;
    }

    @RequestMapping("/entityStrength")
    @ResponseBody
    public ResultDTO<Relation> entityStrength(@RequestBody Relation relation){
        ResultDTO<Relation> resultDTO = new ResultDTO<>();
        resultDTO = modifyService.entityStrength(relation);
        return resultDTO;
    }

    @RequestMapping("/initData")
    @ResponseBody
    public ResultDTO<InitialData> initData() throws IOException {
        ResultDTO<InitialData> resultDTO = new ResultDTO<>();
        resultDTO = modifyService.initData();
        return resultDTO;
    }
}
