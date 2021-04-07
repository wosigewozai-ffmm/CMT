package com.seu.CMT.mapper;

import com.seu.CMT.pojo.Film;
import com.seu.CMT.pojo.UserFilm;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FilmMapper {
    //查找所有电影
    @Select("SELECT * FROM film")
    List<Film> findAllFilm();

    //按照ID查找电影
    @Select("SELECT * FROM film WHERE id = #{value} ")
    Film findFilmByID(int id);

    //按类型查找电影
    @Select("SELECT * From film WHERE type LIKE '%${value}%'")
    List<Film> findType(String type);

    //关键词查询电影
    @Select("SELECT * FROM film WHERE name LIKE '%${value}%'")
    List<Film> findFilmByKeyword(String keyword);

    //根据Info查询信息
    List<Film> findFilmByInfo(Film film);

    //高分电影
    @Select("SELECT * FROM film WHERE score >= ${value} ORDER BY score DESC")
    List<Film> findFilmWithHighScore(double score);

    //查找观影记录
    @Select("SELECT * FROM userfilm WHERE name = #{value} ORDER BY time DESC" )
    List<UserFilm> findRecord(String name);

    //新增观影记录
    int addRecord(UserFilm userFilm);
    //更新观影记录
    int updateRecord(UserFilm userFilm);

    int addInfo(Film film);
}
