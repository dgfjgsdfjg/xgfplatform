package com.cmpay.xgf.service;

import com.cmpay.xgf.dto.UserDTO;
import com.cmpay.xgf.entity.UserDO;

/**
 *
 * @author xgf
 */
public interface LoginService {

    /**
     * 登录login
     * @return int
     * @param userDTO
     * 登录
     */
    UserDO login(UserDTO userDTO);

}
