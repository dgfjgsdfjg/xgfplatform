package com.cmpay.xgf.controller;
import com.cmpay.xgf.entity.RoleDO;
import com.cmpay.xgf.entity.UserDO;
import com.cmpay.xgf.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/Role")
public class RoleController {

    @Autowired
    RoleService roleService;


    @PostMapping("/createRole")
    @ResponseBody
    public void createRole(RoleDO roleDO) {

        roleService.createRole(roleDO);

    }

    @PutMapping("/delete")
    @ResponseBody
    public void delete() {

        RoleDO roleDO = new RoleDO();

        roleDO.setRoleId(1);

        roleDO.setIsUsed(0);

        roleDO.setUpdateBy("xgf");

        roleDO.setUpdateDate(LocalDateTime.now().toString());

        roleService.delete(roleDO);

    }

}
