package com.cmpay.xgf.service;

import com.cmpay.xgf.entity.RoleDO;
import com.cmpay.xgf.entity.UserDO;

public interface RoleService {

    /**
     * 创造角色
     * @param roleDO
     * @return
     * 描述
     */
    void createRole(RoleDO roleDO);

    /**
     * 删除角色
     * @param roleDO
     * @return
     * 描述
     */
    void delete(RoleDO roleDO);
}
