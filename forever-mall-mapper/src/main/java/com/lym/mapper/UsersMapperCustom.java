package com.lym.mapper;

import com.lym.my.mapper.MyMapper;
import com.lym.pojo.Users;
import com.lym.pojo.vo.center.UserInfoVO;

import java.util.List;

/**
 * 用户中心相关  增删改用户信息的mapper类
 */
public interface UsersMapperCustom extends MyMapper<Users> {

    public UserInfoVO queryUserInfo(String userId);
}