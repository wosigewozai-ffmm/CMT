package com.seu.CMT.mapper;

import com.seu.CMT.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ModifyMapper {

    List<Model> getAll(String type);

    int add(@Param("model") Model model);

    int addRelation(@Param("relation") Relation relation);

    List<Model> find(String name);

    List<Model> findRelation(@Param("relation") Relation relation);

    int deleteEntity(@Param("model") Model model);
}
