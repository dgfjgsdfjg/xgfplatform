/*
 * @ClassName IMenuDao
 * @Description 
 * @version 1.0
 * @Date 2020-06-28 00:02:47
 */
package com.cmpay.xgf.dao;

import com.cmpay.lemon.framework.dao.BaseDao;
import com.cmpay.xgf.entity.MenuDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IMenuDao extends BaseDao<MenuDO, Integer> {
}