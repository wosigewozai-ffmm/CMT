package com.seu.CMT.mapper;

import com.seu.CMT.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ModifyMapper {
    List<UserModel> getPage(@Param("pageStart") int pageStart, @Param("pageSize") int pageSize, @Param("sort") String sort, @Param("name") String name, @Param("sex") String sex);

    int getPageTotal(@Param("name") String name, @Param("sex") String sex);

    List<Model> getAll(String type);

    List<PrescriptionModel> getAllPrescription();

    UserModel getById(@Param("id") Long id);

    int add(@Param("model") Model model);

    int update(@Param("model") UserModel model);

    int deleteById(@Param("id") Long id);

    int addRelation(@Param("relation") Relation relation);
}
