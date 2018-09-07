package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.entity.SicmedStandardprescriptionBranch;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SicmedStandardprescriptionBranchReadMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedStandardprescriptionBranch record);

    int insertSelective(SicmedStandardprescriptionBranch record);

    SicmedStandardprescriptionBranch selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedStandardprescriptionBranch record);

    int updateByPrimaryKey(SicmedStandardprescriptionBranch record);

    List<SicmedStandardprescriptionBranch> findStandardPrescriptionBranch(@Param("branchCode") String branchCode, @Param("askedCode") String askedCode);
}