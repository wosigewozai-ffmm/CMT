package com.seu.CMT.controller;

import com.seu.CMT.mapper.ModifyMapper;
import com.seu.CMT.model.UserModel;
import com.seu.CMT.pojo.Film;
import com.seu.CMT.pojo.ExcelData;
import com.seu.CMT.pojo.ResultDTO;
import com.seu.CMT.service.ModifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.management.openmbean.CompositeDataSupport;
import java.util.List;

@RestController
@RequestMapping({"modify"})

public class ModifyController {
    @Autowired
    ModifyService modifyService;
    @Autowired
    private ModifyMapper modifyMapper;

    public ModifyController(){
    }

    @GetMapping("/getAll")
    public List<UserModel> getAll() {
        List<UserModel> models = modifyMapper.getAll();
        return models;
    }

    @RequestMapping("/addExcel")
    @ResponseBody
    public ResultDTO<Film> addExcel(@RequestParam("fileName")MultipartFile file) throws Exception{
        ResultDTO<Film> resultDTO= modifyService.addExcel(file);
        return resultDTO;
    }
}
