package com.cmpay.xgf.controller;


import com.cmpay.lemon.framework.utils.IdGenUtils;
import com.cmpay.xgf.dto.UserDTO;
import com.cmpay.xgf.service.LoginService;
import com.cmpay.xgf.service.UserService;
import com.cmpay.xgf.entity.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lihuiquan
 */
@RestController("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    LoginService loginService;

    @PostMapping("/regist")
    @ResponseBody
    public UserDO regist(@RequestBody UserDO userDO) {


        userDO.setuId(2);

        userService.regist(userDO);

        return userDO;

    }

    @PostMapping("/login")
    @ResponseBody
    public UserDTO login(@RequestBody UserDTO userDTO) {


        userDTO.setuId(2);


        loginService.login(userDTO);

        return userDTO;

    }
}
