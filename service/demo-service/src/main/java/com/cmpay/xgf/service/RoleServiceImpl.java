package com.cmpay.xgf.service;

import com.cmpay.lemon.common.exception.BusinessException;
import com.cmpay.lemon.framework.security.SecurityUtils;
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
import java.util.ArrayList;
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

            roleMenuDO.setCreateBy(SecurityUtils.getLoginName());
            roleMenuDO.setCreateDate(LocalDateTime.now().toString());
            roleMenuDO.setUpdateBy(SecurityUtils.getLoginName());
            roleMenuDO.setUpdateDate(LocalDateTime.now().toString());
            roleMenuDO.setIsUsed(1);

            roleMenuDOList.add(i,roleMenuDO);
        }


        int res = roleMenuDao.insertMenu(roleMenuDOList);

        if (res != 1) {
            BusinessException.throwBusinessException(MsgEnum.DB_INSERT_FAILED);
        }

    }

    @Override
    public List<RoleMenuDO> getMenusByRoleId(Integer roleId) {

        return roleMenuDao.getMenusByRoleId(roleId);
    }

    @Override
    public void update(RoleDO roleDO) {

        int res = roleDao.update(roleDO);

        if (res != 1) {
            BusinessException.throwBusinessException(MsgEnum.DB_UPDATE_FAILED);
        }
    }

    @Override
    public void updateMenu(int roleId,List<Integer> selectMenuIds,List<Integer> menuIds) {

        menuIds.removeAll(selectMenuIds);

        for(int i = 0;i<menuIds.size();i++) {

            RoleMenuDO tempRoleMenuDO = new RoleMenuDO();
            tempRoleMenuDO.setRoleId(roleId);
            tempRoleMenuDO.setMenuId(menuIds.get(i));
            tempRoleMenuDO.setId(roleMenuDao.find(tempRoleMenuDO).get(0).getId());
            tempRoleMenuDO.setUpdateBy(SecurityUtils.getLoginName());
            tempRoleMenuDO.setUpdateDate(LocalDateTime.now().toString());
            tempRoleMenuDO.setIsUsed(0);

            int res = roleMenuDao.update(tempRoleMenuDO);

            if (res != 1) {
                BusinessException.throwBusinessException(MsgEnum.DB_UPDATE_FAILED);
            }
        }

        for(int i = 0;i<selectMenuIds.size();i++) {

            RoleMenuDO roleMenuDO = new RoleMenuDO();
            roleMenuDO.setRoleId(roleId);
            roleMenuDO.setMenuId(selectMenuIds.get(i));
            roleMenuDO.setId(roleMenuDao.find(roleMenuDO).get(0).getId());
            roleMenuDO.setUpdateBy(SecurityUtils.getLoginName());
            roleMenuDO.setUpdateDate(LocalDateTime.now().toString());
            roleMenuDO.setIsUsed(1);

            int res = roleMenuDao.update(roleMenuDO);

            if (res != 1) {
                BusinessException.throwBusinessException(MsgEnum.DB_UPDATE_FAILED);
            }
        }
    }

    @Override
    public List<RoleMenuDO> findRoleMenu(RoleMenuDO roleMenuDO) {

        return roleMenuDao.find(roleMenuDO);
    }


}
