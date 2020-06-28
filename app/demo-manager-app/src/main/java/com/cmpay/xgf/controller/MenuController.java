package com.cmpay.xgf.controller;

import com.cmpay.xgf.entity.MenuDO;
import com.cmpay.xgf.entity.RoleDO;
import com.cmpay.xgf.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    @PostMapping("/createMenu")
    @ResponseBody
    public void createMenu(@RequestBody MenuDO menuDO) {

        menuDO.setCreateBy("xgf");

        menuDO.setCreateDate(LocalDateTime.now().toString());

        menuDO.setUpdateBy("xgf");

        menuDO.setUpdateDate(LocalDateTime.now().toString());

        menuDO.setIsUsed(1);

        menuService.createMenu(menuDO);

    }

    @PutMapping("/delete")
    @ResponseBody
    public void delete(@RequestBody MenuDO menuDO) {


        menuDO.setIsUsed(0);

        menuDO.setUpdateBy("xgf");

        menuDO.setUpdateDate(LocalDateTime.now().toString());

        menuService.delete(menuDO);

    }

}
