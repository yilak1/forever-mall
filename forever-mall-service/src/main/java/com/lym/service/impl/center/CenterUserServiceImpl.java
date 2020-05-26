package com.lym.service.impl.center;

import com.lym.mapper.UsersMapper;
import com.lym.mapper.UsersMapperCustom;
import com.lym.pojo.Users;
import com.lym.pojo.bo.center.CenterUserBO;
import com.lym.pojo.vo.center.UserInfoVO;
import com.lym.service.center.CenterUserService;
import com.lym.mapper.UsersMapper;
import org.n3r.idworker.Sid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class CenterUserServiceImpl implements CenterUserService {

    @Autowired
    public UsersMapperCustom usersMapperCustom;

    @Autowired
    public UsersMapper usersMapper;

    @Autowired
    private Sid sid;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public UserInfoVO queryUserInfo(String userId) {
        UserInfoVO userInfoVO = usersMapperCustom.queryUserInfo(userId);

        return userInfoVO;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public UserInfoVO updateUserInfo(String userId, CenterUserBO centerUserBO) {

        Users updateUser = new Users();
        BeanUtils.copyProperties(centerUserBO, updateUser);
        updateUser.setId(userId);
        updateUser.setUpdatedTime(new Date());
        usersMapper.updateByPrimaryKeySelective(updateUser);
        return usersMapperCustom.queryUserInfo(userId);
    }

    //修改用户的头像
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public UserInfoVO updateUserFace(String userId, String imageUrl) {
        Users updateUser = new Users();
        updateUser.setId(userId);
        updateUser.setFace(imageUrl);
        updateUser.setUpdatedTime(new Date());
        //使用下面的方法，只会对不为空的字段进行更新
        usersMapper.updateByPrimaryKeySelective(updateUser);
        return queryUserInfo(userId);
    }

}
