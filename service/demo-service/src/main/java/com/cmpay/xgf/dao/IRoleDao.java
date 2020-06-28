/*
 * @ClassName IRoleDao
 * @Description 
 * @version 1.0
 * @Date 2020-06-28 00:02:47
 */
package com.cmpay.xgf.dao;

import com.cmpay.lemon.framework.dao.BaseDao;
import com.cmpay.xgf.entity.RoleDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface IRoleDao extends BaseDao<RoleDO, Integer> {

    RoleDO selectRoleByRoleName(String roleName);
}