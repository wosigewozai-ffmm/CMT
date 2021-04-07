package com.seu.CMT.service;

import com.seu.CMT.mapper.FilmMapper;
import com.seu.CMT.pojo.Film;
import com.seu.CMT.pojo.ResultDTO;
import com.seu.CMT.pojo.UserFilm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("filmService")
@Transactional
public class FilmServiceImpl implements FilmService {
    @Resource
    FilmMapper filmMapper;

    /*@Override
    public List<Film> findAllFilm() {
        //查之前如果有其他业务 可以自行编写
        return this.filmMapper.findAllFilm();
    }*/

    @Override
    public ResultDTO<Film> findRecord(String name) {
        ResultDTO<Film> resultDTO = new ResultDTO<>();
        List<UserFilm> data= new ArrayList<>();
        data = filmMapper.findRecord(name);
        List<Film> filmdata=new ArrayList<>();
        System.out.println(data);
        for (int i=0;i<data.size();i++){
            Film temp=new Film();
            temp=filmMapper.findFilmByID(data.get(i).getFilmid());
            temp.setTime(data.get(i).getTime());
            filmdata.add(temp);
        }
        resultDTO.setData(filmdata);
        resultDTO.setCode(0);
        resultDTO.setMsg("历史记录查询");
        return resultDTO;
    }

    @Override
    public ResultDTO<Film> findFilmByInfo(Film film) {
        ResultDTO<Film> resultDTO = new ResultDTO<>();
        List<Film> data= new ArrayList<>();
        if (film.getType().equals("所有类型")){
            film.setType("");
        }
        if (film.getLocation().equals("所有地区")){
            film.setLocation("");
        }
        data = filmMapper.findFilmByInfo(film);
        resultDTO.setData(data);
        resultDTO.setCode(0);
        resultDTO.setMsg("多条件查询");
        return resultDTO;
    }

    @Override
    public ResultDTO<Film> findFilmID(int id) {
        ResultDTO<Film> resultDTO = new ResultDTO<>();
        List<Film> data= new ArrayList<>();
        Film film = new Film();
        film = filmMapper.findFilmByID(id);
        data.add(film);
        resultDTO.setData(data);
        resultDTO.setCode(0);
        resultDTO.setMsg("ID查询");
        return resultDTO;
    }

    @Override
    public ResultDTO<UserFilm> addRecord(UserFilm userFilm) {
        ResultDTO<UserFilm> resultDTO= new ResultDTO<>();
        Date date=new Date();
        userFilm.setTime(date.getTime());
        System.out.println(userFilm);
        try{
            int i=filmMapper.addRecord(userFilm);
            if (i>0){
                resultDTO.setMsg("加入成功");
            }else{
                resultDTO.setMsg("加入失败");
                System.out.println('a');
            }
        }catch (Exception e){
            try{
                int p=filmMapper.updateRecord(userFilm);
                if (p>0){
                    resultDTO.setMsg("更新成功");
                }else{
                    resultDTO.setMsg("更新失败");
                }
            }catch (Exception ex){

            }
            System.out.println('b');
            resultDTO.setCode(0);
        }
        return resultDTO;
    }

    @Override
    public ResultDTO<Film> findFilmWithHighScore(double score) {
        ResultDTO<Film> resultDTO = new ResultDTO<>();
        List<Film> data= new ArrayList<>();
        data = filmMapper.findFilmWithHighScore(score);
        resultDTO.setData(data);
        resultDTO.setCode(0);
        resultDTO.setMsg("高分查询");
        return resultDTO;
    }

    @Override
    public ResultDTO<Film> findType(String keyword) {
        ResultDTO<Film> resultDTO = new ResultDTO<>();
        List<Film> data= new ArrayList<>();
        data = filmMapper.findType(keyword);
        resultDTO.setData(data);
        resultDTO.setCode(0);
        resultDTO.setMsg("类型查询");
        return resultDTO;
    }

    @Override
    public ResultDTO<Film> addInfo(Film film) {
        ResultDTO<Film> resultDTO= new ResultDTO<>();
        try{
            int i=filmMapper.addInfo(film);
            if (i>0){
                resultDTO.setMsg("加入成功");
            }else{
                resultDTO.setMsg("加入失败");
            }
        }catch (Exception e){
            resultDTO.setMsg("加入失败");
            System.out.println(e);
        }
        return resultDTO;
    }

    @Override
    public ResultDTO<Film> findFilmByKeyword(String keyword) {
        ResultDTO<Film> resultDTO = new ResultDTO<>();
        List<Film> data= new ArrayList<>();
        data = filmMapper.findFilmByKeyword(keyword);
        resultDTO.setData(data);
        resultDTO.setCode(0);
        resultDTO.setMsg("关键词查询");
        return resultDTO;
    }

    @Override
    public ResultDTO<Film> findAllFilm() {
        ResultDTO<Film> resultDTO = new ResultDTO<>();
        List<Film> data= new ArrayList<>();
        data = filmMapper.findAllFilm();
        resultDTO.setData(data);
        resultDTO.setCode(0);
        resultDTO.setMsg("success");
        return resultDTO;
    }

}
