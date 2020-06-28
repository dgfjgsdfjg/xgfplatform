package com.cmpay.xgf.controller;
import com.cmpay.lemon.framework.utils.IdGenUtils;
import com.cmpay.xgf.entity.RoleDO;
import com.cmpay.xgf.entity.UserDO;
import com.cmpay.xgf.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;


    @PostMapping("/createRole")
    @ResponseBody
    public void createRole(@RequestBody RoleDO roleDO) {

        roleDO.setRoleId(Integer.valueOf(IdGenUtils.generateId("XGF_ID")));

        roleDO.setRoleName(roleDO.getRoleName());

        roleDO.setCreateBy("xgf");

        roleDO.setCreateDate(LocalDateTime.now().toString());

        roleDO.setUpdateBy("xgf");

        roleDO.setUpdateDate(LocalDateTime.now().toString());

        roleDO.setIsUsed(1);

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
