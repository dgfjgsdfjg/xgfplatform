/*
 * @ClassName IUserRoleDao
 * @Description 
 * @version 1.0
 * @Date 2020-06-28 00:02:47
 */
package com.cmpay.xgf.dao;

import com.cmpay.lemon.framework.dao.BaseDao;
import com.cmpay.xgf.entity.UserRoleDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IUserRoleDao extends BaseDao<UserRoleDO, Integer> {

    int insertRole(List<UserRoleDO> userRoleDOList);
}