package com.cmpay.xgf.controller;

import com.cmpay.framework.data.request.GenericDTO;
import com.cmpay.framework.data.response.GenericRspDTO;
import com.cmpay.lemon.framework.annotation.QueryBody;
import com.cmpay.xgf.service.UserService;
import com.cmpay.xgf.entity.UserDO;
import com.cmpay.xgf.enums.MsgEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lihuiquan
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    @ResponseBody
    public UserDO login(@RequestBody  UserDO userDO) {

        userService.login();

        return userDO;

    }
}
