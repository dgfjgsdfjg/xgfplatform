package com.cmpay.xgf.service;

import com.cmpay.xgf.entity.RoleDO;
import com.cmpay.xgf.entity.RoleMenuDO;
import com.cmpay.xgf.entity.UserDO;
import org.springframework.stereotype.Service;

import java.util.List;


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

    /**
     * 查询所有角色
     * @param roleDO
     * @return List<RoleDO>
     */
    List<RoleDO> find(RoleDO roleDO);

    /**
     * 根据用户Id查询角色
     * @param roleId
     * @return UserDO
     */
    RoleDO get(int roleId);

    /**
     * 插入菜单
     * @param roleId
     * @param roleMenuIds
     * @param menuIds
     */
    void insertMenu(int roleId, List<Integer> roleMenuIds,List<Integer> menuIds);

    /**
     * 通过角色Id查找菜单集合
     * @param roleId
     * @return
     */
    List<RoleMenuDO> getMenusByRoleId(Integer roleId);

    /**
     * 更新角色
     * @param roleDO
     * @return
     */
    void update(RoleDO roleDO);

    /**
     * 为角色更新菜单
     * @param roleId
     * @param selectMenuIds
     * @param menuIds
     */
    void updateMenu(int roleId,List<Integer> selectMenuIds,List<Integer> menuIds);

    /**
     * 查找角色菜单表
     * @param roleMenuDO
     * @return List<RoleMenuDO>
     */
    List<RoleMenuDO> findRoleMenu(RoleMenuDO roleMenuDO);
}
