package com.cmpay.xgf.controller;

import com.cmpay.framework.data.response.GenericRspDTO;
import com.cmpay.lemon.common.utils.BeanUtils;
import com.cmpay.lemon.framework.annotation.QueryBody;
import com.cmpay.lemon.framework.page.PageInfo;
import com.cmpay.lemon.framework.utils.IdGenUtils;
import com.cmpay.xgf.dto.MenuInfoDTO;
import com.cmpay.xgf.dto.MenuPageRspDTO;
import com.cmpay.xgf.dto.RoleInfoDTO;
import com.cmpay.xgf.dto.RolePageRspDTO;
import com.cmpay.xgf.entity.MenuDO;
import com.cmpay.xgf.entity.RoleDO;
import com.cmpay.xgf.enums.MsgEnum;
import com.cmpay.xgf.service.MenuService;
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

    @PostMapping("/createMenu")
    @ResponseBody
    public void createMenu(@RequestBody MenuDO menuDO) {

        menuDO.setMenuId(Integer.valueOf(IdGenUtils.generateId("XGF_ID")));

        menuDO.setCreateBy("xgf");

        menuDO.setCreateDate(LocalDateTime.now().toString());

        menuDO.setUpdateBy("xgf");

        menuDO.setUpdateDate(LocalDateTime.now().toString());

        menuDO.setIsUsed(1);

        menuService.createMenu(menuDO);

    }

    @GetMapping("/lists")
    public GenericRspDTO<MenuPageRspDTO> list(@QueryBody MenuDO menuDO) {

        menuDO.setIsUsed(1);

        List<Map> mapList = menuService.selectAllMenu();

//        List<MenuInfoDTO> dtoList = new ArrayList<>();
//
//        doList.stream().forEach(item -> {
//            // 逐步把DO 转换成DTO 放进dtoList里去
//            MenuInfoDTO dto = new MenuInfoDTO();
//            BeanUtils.copyProperties(dto, item);
//            dtoList.add(dto);
//        });

        // 设定list
        MenuPageRspDTO menuPageRspDTO = new MenuPageRspDTO();

        menuPageRspDTO.setList(mapList);

        PageInfo<Map> pageInfo = new PageInfo<Map>(mapList);

        menuPageRspDTO.setPageNum(pageInfo.getPageNum());
        menuPageRspDTO.setPageSize(pageInfo.getPageSize());
        menuPageRspDTO.setPages(pageInfo.getPages());
        menuPageRspDTO.setTotal(pageInfo.getTotal());
        return GenericRspDTO.newInstance(MsgEnum.SUCCESS,menuPageRspDTO);

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
