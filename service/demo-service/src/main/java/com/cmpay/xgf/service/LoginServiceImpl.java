package com.cmpay.xgf.service;

import com.cmpay.xgf.dao.IUserDao;
import com.cmpay.xgf.dto.UserDTO;
import com.cmpay.xgf.entity.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xgf
 */
@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    IUserDao userDao;


    @Override
    public UserDO login(UserDTO userDTO) {

        return userDao.get(userDTO.getuId());
    }
}
