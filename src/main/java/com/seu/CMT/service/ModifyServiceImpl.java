package com.seu.CMT.service;

import com.seu.CMT.mapper.ModifyMapper;
import com.seu.CMT.pojo.Film;
import com.seu.CMT.pojo.ResultDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("modifyService")
@Transactional

public class ModifyServiceImpl implements ModifyService {
    @Resource
    ModifyMapper modifyMapper;

    @Override
    public ResultDTO<Film> addExcel() {
        ResultDTO<Film> resultDTO = new ResultDTO<>();
        System.out.println("addExcel");
        return resultDTO;
    }
}
