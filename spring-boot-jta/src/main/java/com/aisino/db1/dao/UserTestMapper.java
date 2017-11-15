package com.aisino.db1.dao;

import com.aisino.db1.domain.UserTest;
import com.aisino.db1.domain.UserTestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserTestMapper {
    long countByExample(UserTestExample example);

    int deleteByExample(UserTestExample example);

    int insert(UserTest record);

    int insertSelective(UserTest record);

    List<UserTest> selectByExample(UserTestExample example);

    int updateByExampleSelective(@Param("record") UserTest record, @Param("example") UserTestExample example);

    int updateByExample(@Param("record") UserTest record, @Param("example") UserTestExample example);
}