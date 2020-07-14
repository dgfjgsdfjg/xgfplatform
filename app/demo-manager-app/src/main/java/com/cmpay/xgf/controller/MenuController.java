package com.cmpay.xgf.controller;

import com.cmpay.framework.data.response.GenericRspDTO;
import com.cmpay.lemon.common.utils.BeanUtils;
import com.cmpay.lemon.framework.annotation.QueryBody;
import com.cmpay.lemon.framework.data.NoBody;
import com.cmpay.lemon.framework.page.PageInfo;
import com.cmpay.lemon.framework.security.SecurityUtils;
import com.cmpay.lemon.framework.utils.IdGenUtils;
import com.cmpay.xgf.dao.IMenuDao;
import com.cmpay.xgf.dto.*;
import com.cmpay.xgf.entity.MenuDO;
import com.cmpay.xgf.entity.RoleDO;
import com.cmpay.xgf.entity.RoleMenuDO;
import com.cmpay.xgf.entity.UserDO;
import com.cmpay.xgf.enums.MsgEnum;
import com.cmpay.xgf.service.MenuService;
import com.cmpay.xgf.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/ui-template/menu")
public class MenuController {

    @Autowired
    MenuService menuService;


    @GetMapping("/select")
    public GenericRspDTO<MenuPageRspDTO> select(@QueryBody MenuDO menuDO) {

        menuDO.setIsUsed(1);

        List<Map> mapList = menuService.selectAllMenu();

        MenuPageRspDTO menuPageRspDTO = new MenuPageRspDTO();

        menuPageRspDTO.setList(mapList);

        PageInfo<Map> pageInfo = new PageInfo<Map>(mapList);

        menuPageRspDTO.setPageNum(pageInfo.getPageNum());
        menuPageRspDTO.setPageSize(pageInfo.getPageSize());
        menuPageRspDTO.setPages(pageInfo.getPages());
        menuPageRspDTO.setTotal(pageInfo.getTotal());
        return GenericRspDTO.newInstance(MsgEnum.SUCCESS,menuPageRspDTO);

    }


    @GetMapping("/info/{id}")
    public GenericRspDTO<MenuInfoRspDTO> getRoleInfoById(@PathVariable("id") int id) {

//        RoleDO roleDO = roleService.get(id);
//
//        RoleMenuDO roleMenuDO = new RoleMenuDO();
//        roleMenuDO.setRoleId(id);
//        roleMenuDO.setIsUsed(1);
//
//        List<RoleMenuDO> roleMenuDOList = roleService.findRoleMenu(roleMenuDO);
//
//        List<Integer> menuIds = new ArrayList<>();
//
//        for(int i = 0;i<roleMenuDOList.size();i++) {
//
//            menuIds.add(i,roleMenuDOList.get(i).getMenuId());
//        }
//
          MenuInfoRspDTO menuInfoRspDTO = new MenuInfoRspDTO();
//        roleInfoRspDTO.setRoleName(roleDO.getRoleName());
//        roleInfoRspDTO.setMenuIds(menuIds);
//
          return GenericRspDTO.newInstance(MsgEnum.SUCCESS,menuInfoRspDTO);
    }


    @PostMapping("/save")
    @ResponseBody
    public GenericRspDTO<NoBody> reg(@RequestBody MenuDO menuDO) {

        menuDO.setMenuId(Integer.valueOf(IdGenUtils.generateId("XGF_ID")));

        menuDO.setParentId(menuService.getByOperate(menuDO.getOperate()).getMenuId());

        menuDO.setOperate(menuDO.getOperate() + "/" + menuDO.getMenuName());

        menuDO.setCreateBy(SecurityUtils.getLoginName());

        menuDO.setCreateDate(LocalDateTime.now().toString());

        menuDO.setUpdateBy(SecurityUtils.getLoginName());

        menuDO.setUpdateDate(LocalDateTime.now().toString());

        menuDO.setIsUsed(1);

        menuService.insert(menuDO);

        return GenericRspDTO.newInstance(MsgEnum.SUCCESS);

    }


    @GetMapping("/lists")
    public GenericRspDTO<MenuPageRspDTO> list(@QueryBody MenuDO menuDO) {

        menuDO.setIsUsed(1);

        List<Map> mapList = menuService.selectAllMenu();

        MenuPageRspDTO menuPageRspDTO = new MenuPageRspDTO();

        menuPageRspDTO.setList(mapList);

        PageInfo<Map> pageInfo = new PageInfo<Map>(mapList);

        menuPageRspDTO.setPageNum(pageInfo.getPageNum());
        menuPageRspDTO.setPageSize(pageInfo.getPageSize());
        menuPageRspDTO.setPages(pageInfo.getPages());
        menuPageRspDTO.setTotal(pageInfo.getTotal());
        return GenericRspDTO.newInstance(MsgEnum.SUCCESS,menuPageRspDTO);

    }


    @PostMapping("/delete/{id}")
    public GenericRspDTO<NoBody> delete(@PathVariable("id") int id) {

            MenuDO menuDO = new MenuDO();

            menuDO.setIsUsed(0);
            menuDO.setMenuId(id);

            menuService.delete(menuDO);

        return GenericRspDTO.newInstance(MsgEnum.SUCCESS);

    }

}
