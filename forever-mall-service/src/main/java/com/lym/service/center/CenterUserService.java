package com.lym.service.center;

import com.lym.pojo.Users;
import com.lym.pojo.bo.center.CenterUserBO;
import com.lym.pojo.vo.center.UserInfoVO;

public interface CenterUserService {

    /**
     * 根据用户id查询用户信息
     * @param userId
     * @return
     */
    public UserInfoVO queryUserInfo(String userId);

    /**
     * 修改用户信息
     * @param userId
     * @param centerUserBO
     */
    public UserInfoVO updateUserInfo(String userId, CenterUserBO centerUserBO);

    /**
     * 修改用户的头像
     * @param userId
     * @param imageUrl
     * @return
     */
    public UserInfoVO updateUserFace(String userId, String imageUrl);
}
