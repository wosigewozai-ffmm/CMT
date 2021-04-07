package com.seu.CMT.controller;

import com.seu.CMT.pojo.Film;
import com.seu.CMT.pojo.ResultDTO;
import com.seu.CMT.pojo.UserFilm;
import com.seu.CMT.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"film"})

public class FilmController {
    @Autowired
    FilmService filmService;

    public FilmController() {
    }

    /*@RequestMapping("/findAll")
    @ResponseBody
    public List<Film> findAll() throws Exception{
        List<Film> infos;
        return filmService.findAllFilm();
    }*/
    //查找所有电影
    @RequestMapping("/findAll")
    @ResponseBody
    public ResultDTO<Film> findAll() throws Exception{
        ResultDTO<Film> resultDTO= filmService.findAllFilm();
        return resultDTO;
    }

    //按ID查找电影
    @RequestMapping("/findFilmByID/{keyword}")
    @ResponseBody
    public ResultDTO<Film> findFilmID(@PathVariable("keyword") int id) throws Exception{
        ResultDTO<Film> resultDTO=filmService.findFilmID(id);
        return resultDTO;
    }

    //关键词查找电影
    @RequestMapping("findFilmByKeyword/{keyword}")
    @ResponseBody
    public ResultDTO<Film> findFilmByKeyword(@PathVariable("keyword") String keyword) throws Exception{
        System.out.println(keyword);
        return filmService.findFilmByKeyword(keyword);
    }
    //按类型查找电影
    @RequestMapping("findType/{keyword}")
    @ResponseBody
    public ResultDTO<Film> findType(@PathVariable("keyword") String keyword) throws Exception{
        System.out.println(keyword);
        return filmService.findType(keyword);
    }

    //多条件查询电影
    @RequestMapping("/findFilmByInfo")
    @ResponseBody
    public ResultDTO<Film> findFilmByInfo(@RequestBody Film film) throws Exception{
        System.out.println(film.toString());
        return filmService.findFilmByInfo(film);
    }
    /*
    @RequestMapping("/addInfo")
    @ResponseBody
    public ResultDTO<Film> addInfo(@RequestBody Film film) throws Exception{
        System.out.println(film.toString());
        return filmService.addInfo(film);
    }
*/
    //查找高分电影
    @RequestMapping("/HighScore/{score}")
    @ResponseBody
    public ResultDTO<Film>  findFilmWithHighScore(@PathVariable("score") double score) throws Exception{
        return filmService.findFilmWithHighScore(score);
    }
    //增加观影记录
    @RequestMapping("/addRecord")
    @ResponseBody
    public ResultDTO<UserFilm> addRecord(@RequestBody UserFilm userFilm) throws Exception{
        return filmService.addRecord(userFilm);
    }
    //查找观影记录
    @RequestMapping("/findRecord/{name}")
    @ResponseBody
    public ResultDTO<Film> findRecord(@PathVariable("name") String name) throws Exception{
        return filmService.findRecord(name);
    }
}
