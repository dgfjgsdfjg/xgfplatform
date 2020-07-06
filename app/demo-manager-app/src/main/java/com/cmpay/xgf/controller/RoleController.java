package com.cmpay.xgf.controller;
import com.cmpay.framework.data.request.GenericDTO;
import com.cmpay.framework.data.response.GenericRspDTO;
import com.cmpay.lemon.common.utils.BeanUtils;
import com.cmpay.lemon.framework.annotation.QueryBody;
import com.cmpay.lemon.framework.data.NoBody;
import com.cmpay.lemon.framework.page.PageInfo;
import com.cmpay.lemon.framework.security.SecurityUtils;
import com.cmpay.lemon.framework.utils.IdGenUtils;
import com.cmpay.xgf.dto.*;
import com.cmpay.xgf.entity.RoleDO;
import com.cmpay.xgf.entity.UserDO;
import com.cmpay.xgf.enums.MsgEnum;
import com.cmpay.xgf.service.RoleService;
import com.cmpay.xgf.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


@RestController
@RequestMapping("/v1/ui-template/role")
public class RoleController {

    @Autowired
    RoleService roleService;


    @PostMapping("/save")
    @ResponseBody
    public GenericRspDTO<NoBody> reg(@RequestBody RoleInfoReqDTO roleInfoReqDTO) {

        RoleDO roleDO = new RoleDO();

        roleDO.setRoleId(Integer.valueOf(IdGenUtils.generateId("XGF_ID")));

        roleDO.setRoleName(roleInfoReqDTO.getRoleName());

        roleDO.setCreateBy(SecurityUtils.getLoginName());

        roleDO.setCreateDate(LocalDateTime.now().toString());

        roleDO.setUpdateBy(SecurityUtils.getLoginName());

        roleDO.setUpdateDate(LocalDateTime.now().toString());

        roleDO.setIsUsed(1);

        roleService.createRole(roleDO);

        List<Integer> roleMenuIds = new ArrayList<>();

        for(int i = 0;i<roleInfoReqDTO.getMenuIds().size();i++) {

            roleMenuIds.add(i,Integer.valueOf(IdGenUtils.generateId("XGF_ID")));
        }

        roleService.insertMenu(roleDO.getRoleId(),roleMenuIds,roleInfoReqDTO.getMenuIds());

        //userService.insertRole(userDO.getuId(),userRoleId,userDO.getRoleId());

        return GenericRspDTO.newInstance(MsgEnum.SUCCESS);

    }

    @GetMapping("/lists")
    public GenericRspDTO<RolePageRspDTO> list(@QueryBody RoleDO roleDO) {

        roleDO.setIsUsed(1);

        List<RoleDO> doList = roleService.find(roleDO);

        List<RoleInfoDTO> dtoList = new ArrayList<>();

        doList.stream().forEach(item -> {
            // 逐步把DO 转换成DTO 放进dtoList里去
            RoleInfoDTO dto = new RoleInfoDTO();
            BeanUtils.copyProperties(dto, item);
            dtoList.add(dto);
        });

        // 设定list
        RolePageRspDTO roleRspDTO = new RolePageRspDTO();

        roleRspDTO.setList(dtoList);

        PageInfo<RoleInfoDTO> pageInfo = new PageInfo<RoleInfoDTO>(dtoList);

        roleRspDTO.setPageNum(pageInfo.getPageNum());
        roleRspDTO.setPageSize(pageInfo.getPageSize());
        roleRspDTO.setPages(pageInfo.getPages());
        roleRspDTO.setTotal(pageInfo.getTotal());
        return GenericRspDTO.newInstance(MsgEnum.SUCCESS,roleRspDTO);

    }


    @PostMapping("/delete")
    public GenericRspDTO<NoBody> delete(@RequestBody RoleReqDTO roleReqDTO) {

        List<Integer> roleId = roleReqDTO.getRoleIds();

        List<RoleDO> roleDOS = new ArrayList<RoleDO>();

        for(int i = 0;i<roleId.size();i++) {

            roleDOS.add(i,new RoleDO());
        }

        for (RoleDO roleDO : roleDOS) {

            roleDO.setIsUsed(0);

            roleDO.setRoleId(roleId.get(roleDOS.indexOf(roleDO)));

            roleDO.setUpdateBy(SecurityUtils.getLoginName());

            roleDO.setUpdateDate(LocalDateTime.now().toString());

            roleService.delete(roleDO);
        }

        return GenericRspDTO.newInstance(MsgEnum.SUCCESS);

    }

}
