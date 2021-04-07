package com.seu.CMT.controller;

import com.seu.CMT.pojo.Film;
import com.seu.CMT.pojo.ExcelData;
import com.seu.CMT.pojo.ResultDTO;
import com.seu.CMT.service.ModifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"modify"})

public class ModifyController {
    @Autowired
    ModifyService modifyService;
    public ModifyController(){
    }

    @RequestMapping("/addExcel")
    @ResponseBody
    public ResultDTO<Film> findAll() throws Exception{
        ResultDTO<Film> resultDTO= modifyService.addExcel();
        return resultDTO;
    }
}
