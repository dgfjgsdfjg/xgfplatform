package com.cmpay.xgf.service;

import com.cmpay.lemon.common.utils.BeanUtils;
import com.cmpay.xgf.bo.UserLoginBO;
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



        UserLoginBO userLoginBO = new UserLoginBO();

        BeanUtils.copyProperties(userLoginBO,userDTO);

        return userDao.login(userLoginBO);
    }
}
