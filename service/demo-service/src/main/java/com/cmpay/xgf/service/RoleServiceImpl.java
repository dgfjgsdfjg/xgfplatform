package com.cmpay.xgf.service;

import com.cmpay.lemon.common.exception.BusinessException;
import com.cmpay.xgf.dao.IRoleDao;
import com.cmpay.xgf.dao.IRoleMenuDao;
import com.cmpay.xgf.entity.RoleDO;
import com.cmpay.xgf.entity.RoleMenuDO;
import com.cmpay.xgf.entity.UserDO;
import com.cmpay.xgf.entity.UserRoleDO;
import com.cmpay.xgf.enums.MsgEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xgf
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    IRoleDao roleDao;

    @Autowired
    IRoleMenuDao roleMenuDao;

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

    @Override
    public List<RoleDO> find(RoleDO roleDO) {

        return roleDao.find(roleDO);
    }

    @Override
    public RoleDO get(int roleId) {

        return roleDao.get(roleId);
    }

    @Override
    public void insertMenu(int roleId, List<Integer> roleMenuIds,List<Integer> menuIds) {

        List<RoleMenuDO> roleMenuDOList = new LinkedList<RoleMenuDO>();

        for(int i = 0;i<menuIds.size();i++) {
            RoleMenuDO roleMenuDO = new RoleMenuDO();

            roleMenuDO.setId(roleMenuIds.get(i));

            roleMenuDO.setRoleId(roleId);

            roleMenuDO.setMenuId(menuIds.get(i));

            roleMenuDO.setCreateBy("xgf");
            roleMenuDO.setCreateDate(LocalDateTime.now().toString());
            roleMenuDO.setUpdateBy("xgf");
            roleMenuDO.setUpdateDate(LocalDateTime.now().toString());
            roleMenuDO.setIsUsed(1);

            roleMenuDOList.add(i,roleMenuDO);
        }


        int res = roleMenuDao.insertMenu(roleMenuDOList);

        if (res != 1) {
            BusinessException.throwBusinessException(MsgEnum.DB_INSERT_FAILED);
        }

    }


}
