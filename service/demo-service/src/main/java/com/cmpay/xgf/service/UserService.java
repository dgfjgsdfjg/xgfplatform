package com.cmpay.xgf.service;

import com.cmpay.xgf.entity.UserDO;

import java.util.List;


/**
 *
 * @author xgf
 */

public interface UserService {

    /**
     * 用户注册
     * @return
     * @param userDO
     */
    void regist(UserDO userDO);


    /**
     * 查询用户列表
     * @param userDO
     * @return List<UserDO>
     */
    List<UserDO> findUsers(UserDO  userDO);

    /**
     * 删除用户(状态为不可用)
     * @param userDO
     * @return
     */
    void delete(UserDO userDO);


    /**
     *分页查询用户
     * @param userDO
     * @return List<UserDO>
     */
    List<UserDO> pageFindUsers(UserDO userDO);

    /**
     *为用户新增角色
     * @param uId
     * @param userRoleId
     * @param roleId
     * @return
     */
    void insertRole(int uId,int userRoleId,int roleId);


    /**
     *为用户新增角色
     * @param uId
     * @param roleId
     * @return
     */
    void updateRole(int uId,int roleId);

    /**
     * 根据用户Id查询用户
     * @param uId
     * @return UserDO
     */
    UserDO get(int uId);

    /**
     * 更新用户
     * @param userDO
     * @return
     */
    void update(UserDO userDO);

}
