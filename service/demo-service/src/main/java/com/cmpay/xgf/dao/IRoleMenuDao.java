/*
 * @ClassName IRoleMenuDao
 * @Description 
 * @version 1.0
 * @Date 2020-06-28 00:02:47
 */
package com.cmpay.xgf.dao;

import com.cmpay.lemon.framework.dao.BaseDao;
import com.cmpay.xgf.entity.RoleMenuDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IRoleMenuDao extends BaseDao<RoleMenuDO, Integer> {
}