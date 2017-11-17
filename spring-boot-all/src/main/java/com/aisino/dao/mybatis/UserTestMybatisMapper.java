package com.aisino.dao.mybatis;

import com.aisino.domain.mybatis.UserTestMybatis;
import com.aisino.domain.mybatis.UserTestMybatisExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserTestMybatisMapper {
    long countByExample(UserTestMybatisExample example);

    int deleteByExample(UserTestMybatisExample example);

    int insert(UserTestMybatis record);

    int insertSelective(UserTestMybatis record);

    List<UserTestMybatis> selectByExample(UserTestMybatisExample example);

    int updateByExampleSelective(@Param("record") UserTestMybatis record, @Param("example") UserTestMybatisExample example);

    int updateByExample(@Param("record") UserTestMybatis record, @Param("example") UserTestMybatisExample example);
}