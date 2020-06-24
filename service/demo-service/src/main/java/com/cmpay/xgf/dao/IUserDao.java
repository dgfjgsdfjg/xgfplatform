/*
 * @ClassName IUserDao
 * @Description
 * @version 1.0
 * @Date 2020-06-23 10:39:35
 */
package com.cmpay.xgf.dao;

import com.cmpay.lemon.framework.dao.BaseDao;
import com.cmpay.xgf.bo.UserLoginBO;
import com.cmpay.xgf.dto.UserDTO;
import com.cmpay.xgf.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IUserDao extends BaseDao<UserDO, Integer> {

    @Override
    UserDO get(Integer id);

    @Override
    int insert(UserDO entity);

    @Override
    int update(UserDO entity);

    @Override
    List<UserDO> find(UserDO entity);

    UserDO login(UserLoginBO entity);
}