package com.aisino.db2.dao;

import com.aisino.db2.domain.JpTest;
import com.aisino.db2.domain.JpTestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JpTestMapper {
    long countByExample(JpTestExample example);

    int deleteByExample(JpTestExample example);

    int deleteByPrimaryKey(String testId);

    int insert(JpTest record);

    int insertSelective(JpTest record);

    List<JpTest> selectByExample(JpTestExample example);

    JpTest selectByPrimaryKey(String testId);

    int updateByExampleSelective(@Param("record") JpTest record, @Param("example") JpTestExample example);

    int updateByExample(@Param("record") JpTest record, @Param("example") JpTestExample example);

    int updateByPrimaryKeySelective(JpTest record);

    int updateByPrimaryKey(JpTest record);
}