package com.seu.CMT.mapper;

import com.seu.CMT.pojo.EffectModel;
import com.seu.CMT.pojo.PrescriptionModel;
import com.seu.CMT.pojo.UserModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ModifyMapper {
    List<UserModel> getPage(@Param("pageStart") int pageStart, @Param("pageSize") int pageSize, @Param("sort") String sort, @Param("name") String name, @Param("sex") String sex);

    int getPageTotal(@Param("name") String name, @Param("sex") String sex);

    List<UserModel> getAll();

    List<EffectModel> getAllEffect();

    List<PrescriptionModel> getAllPrescription();

    UserModel getById(@Param("id") Long id);

    int addEffect(@Param("model") EffectModel model);

    int addPrescription(@Param("model") PrescriptionModel model);

    int update(@Param("model") UserModel model);

    int deleteById(@Param("id") Long id);

}
