package com.csii.demo.usr.dao.mapper;

import com.csii.demo.usr.bean.User;
import org.apache.ibatis.annotations.Param;

/**
 * @program: PEX
 * @Date: 2019/7/9 10:27
 * @Author: Li Tangjian
 * @Description:
 */
public interface UserMapper {

    User selectUserById(@Param("UserId") Long userId);

    User selectUserByUsername(@Param("Username")String userName);
    
    
}
