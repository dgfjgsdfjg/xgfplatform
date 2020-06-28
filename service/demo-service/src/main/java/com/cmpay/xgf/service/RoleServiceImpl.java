package com.cmpay.xgf.service;

import com.cmpay.lemon.common.exception.BusinessException;
import com.cmpay.xgf.dao.IRoleDao;
import com.cmpay.xgf.entity.RoleDO;
import com.cmpay.xgf.entity.UserDO;
import com.cmpay.xgf.enums.MsgEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xgf
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    IRoleDao roleDao;

    @Override
    public void createRole(RoleDO roleDO) {

        int res = roleDao.insert(roleDO);

        if (res != 1) {
            BusinessException.throwBusinessException(MsgEnum.DB_INSERT_FAILED);
        }

    }

    @Override
    public RoleDO selectRoleByRoleName(String roleName) {

        return roleDao.selectRoleByRoleName(roleName);

    }

    @Override
    public void delete(RoleDO roleDO) {

        int res = roleDao.update(roleDO);

        if (res != 1) {
            BusinessException.throwBusinessException(MsgEnum.DB_UPDATE_FAILED);
        }


    }
}
