package com.cmpay.xgf.service;

import com.cmpay.xgf.entity.UserDO;

import java.util.List;


/**
 *
 * @author xgf
 */

public interface UserService {

    /**
     * 注册
     * @return
     * @param userDO
     */
    void regist(UserDO userDO);


//    /**
//     * 查询用户列表
//     * @param userInfoQueryBO
//     * @return
//     */
//    PageInfo<UserDO> findUsers(UserInfoQueryBO userInfoQueryBO);

    /**
     * 描述
     * @param userDO
     * @return List<UserDO>
     */
    List<UserDO> findUsers(UserDO  userDO);

    /**
     * 描述
     * @param userDO
     * @return
     */
    void delete(UserDO userDO);


    /**
     *描述
     * @param userDO
     * @return List<UserDO>
     */
    List<UserDO> pageFindUsers(UserDO userDO);

    /**
     *描述
     * @param uId
     * @param userRoleId
     * @return List<UserDO>
     */
    void insertRole(int uId,int userRoleId);

}
