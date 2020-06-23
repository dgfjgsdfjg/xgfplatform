package com.cmpay.xgf.service;

import com.cmpay.xgf.entity.UserDO;
import org.springframework.stereotype.Service;


/**
 *
 * @author xgf
 */

public interface UserService {

    /**
     * 登录login
     * @return int
     * @param userDO
     * 登录
     */
    int regist(UserDO userDO);

}
