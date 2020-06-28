package com.cmpay.xgf.service;

import com.cmpay.xgf.entity.RoleDO;
import com.cmpay.xgf.entity.UserDO;
import org.springframework.stereotype.Service;


/**
 *
 * @author xgf
 */
public interface RoleService {

    /**
     * 创造角色
     * @param roleDO
     * @return
     * 描述
     */
    void createRole(RoleDO roleDO);

    /**
     * 用角色名查找角色Id
     * @param roleName
     * @return RoleDO
     */
    RoleDO selectRoleByRoleName(String roleName);

    /**
     * 删除角色
     * @param roleDO
     * @return
     * 描述
     */
    void delete(RoleDO roleDO);
}
