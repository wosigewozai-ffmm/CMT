package com.seu.CMT.service;

import com.seu.CMT.pojo.Film;
import com.seu.CMT.pojo.ResultDTO;
import com.seu.CMT.pojo.UserFilm;

public interface FilmService {
    //List<Film> findAllFilm();
    //所有电影
    ResultDTO<Film> findAllFilm();

    //按ID查询
    ResultDTO<Film> findFilmID(int id);

    //关键词查询
    ResultDTO<Film> findFilmByKeyword(String keyword);

    //类型查询
    ResultDTO<Film> findType(String keyword);

    //多选项查询
    ResultDTO<Film> findFilmByInfo(Film film);

    //高分电影查询
    ResultDTO<Film> findFilmWithHighScore(double score);

    //添加电影
    ResultDTO<Film> addInfo(Film film);

    //添加观看记录
    ResultDTO<UserFilm> addRecord(UserFilm userFilm);

    //查找观影记录
    ResultDTO<Film> findRecord(String name);


}
