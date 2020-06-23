/*
 * @ClassName IUserRoleDao
 * @Description 
 * @version 1.0
 * @Date 2020-06-23 18:00:19
 */
package com.cmpay.xgf.dao;

import com.cmpay.lemon.framework.dao.BaseDao;
import com.cmpay.xgf.entity.UserRoleDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserRoleDao extends BaseDao<UserRoleDO, Integer> {
}