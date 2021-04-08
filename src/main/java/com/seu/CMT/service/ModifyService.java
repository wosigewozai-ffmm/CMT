package com.seu.CMT.service;

import com.seu.CMT.pojo.Film;
import com.seu.CMT.pojo.ResultDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ModifyService {
    ResultDTO<Film> addExcel(MultipartFile file) throws IOException;
}
