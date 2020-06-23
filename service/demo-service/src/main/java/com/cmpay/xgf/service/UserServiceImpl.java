package com.cmpay.xgf.service;

import com.cmpay.xgf.dao.IUserDao;
import com.cmpay.xgf.entity.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xgf
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    IUserDao userDao;

    @Override
    public int regist(UserDO userDO) {

        return userDao.insert(userDO);

    }
}
