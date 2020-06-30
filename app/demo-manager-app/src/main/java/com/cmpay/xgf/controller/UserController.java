package com.cmpay.xgf.controller;


import com.cmpay.framework.data.request.GenericDTO;
import com.cmpay.framework.data.response.GenericRspDTO;
import com.cmpay.lemon.common.utils.BeanUtils;
import com.cmpay.lemon.common.utils.JudgeUtils;
import com.cmpay.lemon.framework.annotation.QueryBody;
import com.cmpay.lemon.framework.page.PageInfo;
import com.cmpay.lemon.framework.security.SecurityUtils;
import com.cmpay.lemon.framework.security.UserInfoBase;
import com.cmpay.lemon.framework.utils.IdGenUtils;
import com.cmpay.lemon.framework.utils.PageUtils;
import com.cmpay.xgf.dao.IUserDao;
import com.cmpay.xgf.dto.*;
import com.cmpay.xgf.entity.RoleDO;
import com.cmpay.xgf.enums.MsgEnum;
import com.cmpay.xgf.service.LoginService;
import com.cmpay.xgf.service.RoleService;
import com.cmpay.xgf.service.UserService;
import com.cmpay.xgf.entity.UserDO;
import com.cmpay.xgf.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lihuiquan
 */
@RestController
@RequestMapping("/v1/ui-template/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    LoginService loginService;
    @Autowired
    RoleService roleService;

    @PostMapping("/save")
    @ResponseBody
    public GenericRspDTO<UserPageRspDTO> reg(@RequestBody UserDO userDO) {

        userDO.setuId(Integer.valueOf(IdGenUtils.generateId("XGF_ID")));

        userDO.setPassword(Md5.md5(userDO.getPassword()));

        userDO.setCreateBy(SecurityUtils.getLoginName());

        userDO.setCreateDate(LocalDateTime.now().toString());

        userDO.setUpdateBy(SecurityUtils.getLoginName());

        userDO.setUpdateDate(LocalDateTime.now().toString());

        userDO.setIsUsed(1);

        userService.regist(userDO);

        int userRoleId = Integer.valueOf(IdGenUtils.generateId("XGF_ID"));

        RoleDO roleDO = roleService.selectRoleByRoleName(userDO.getRoleName());

        userService.insertRole(userDO.getuId(),userRoleId,roleDO.getRoleId());

        UserPageRspDTO userRspDTO = new UserPageRspDTO();

        return GenericRspDTO.newInstance(MsgEnum.SUCCESS, userRspDTO);

    }

    @PostMapping("/update")
    @ResponseBody
    public GenericRspDTO<UserPageRspDTO> update(@RequestBody UserDO userDO) {

        userDO.setUpdateBy(SecurityUtils.getLoginName());

        userDO.setUpdateDate(LocalDateTime.now().toString());

        userDO.setIsUsed(1);

        userService.update(userDO);

        UserPageRspDTO userRspDTO = new UserPageRspDTO();

        return GenericRspDTO.newInstance(MsgEnum.SUCCESS, userRspDTO);

    }


    @GetMapping("/info")
    public GenericRspDTO<UserDTO> getUserInfo(@QueryBody GenericDTO genericDTO) {
        UserInfoBase loginUser = SecurityUtils.getLoginUser();
        UserDO userDO = userService.get(Integer.valueOf(loginUser.getUserId()));
        UserDTO userDTO = BeanUtils.copyPropertiesReturnDest(new UserDTO(), userDO);
        return GenericRspDTO.newInstance(MsgEnum.SUCCESS,userDTO);
    }


    @GetMapping("/info/{id}")
    public GenericRspDTO<UserInfoDTO> getUserInfoById(@PathVariable("id") int id) {
        UserDO userDO = userService.get(id);
        UserInfoDTO userInfoDTO = BeanUtils.copyPropertiesReturnDest(new UserInfoDTO(), userDO);
        return GenericRspDTO.newInstance(MsgEnum.SUCCESS,userInfoDTO);
    }


    @PostMapping("/delete")
    @ResponseBody
    public GenericRspDTO<UserPageRspDTO> delete(@RequestBody UserDO userDO) {

        userDO.setIsUsed(0);

        userDO.setUpdateBy(SecurityUtils.getLoginName());

        userDO.setUpdateDate(LocalDateTime.now().toString());

        userService.delete(userDO);

        UserPageRspDTO userRspDTO = new UserPageRspDTO();

        return GenericRspDTO.newInstance(MsgEnum.SUCCESS, userRspDTO);

    }

    //查询用户
    @GetMapping("/list")
    public  GenericRspDTO<UserPageRspDTO> getUserList(@QueryBody UserDO userDO) {
        // 新建两个list 分别是DO和存Rsp的数组
        userDO.setIsUsed(1);
        List<UserDO> userDOList = userService.findUsers(userDO);
        List<UserInfoDTO> dtoList = new ArrayList<>();
        // 脱去敏感信息 转成rsp  rsp里还包含了分页信息
        userDOList.stream().forEach(item -> {
            // 逐步把DO 转换成DTO 放进dtoList里去
            UserInfoDTO dto = new UserInfoDTO();
            BeanUtils.copyProperties(dto, item);
            dtoList.add(dto);
        });
        // 设定list
        UserPageRspDTO userRspDTO = new UserPageRspDTO();

        userRspDTO.setList(dtoList);

        PageInfo<UserInfoDTO> pageInfo = new PageInfo<UserInfoDTO>(dtoList);

        userRspDTO.setPageNum(pageInfo.getPageNum());
        userRspDTO.setPageSize(pageInfo.getPageSize());
        userRspDTO.setPages(pageInfo.getPages());
        userRspDTO.setTotal(pageInfo.getTotal());
        return GenericRspDTO.newInstance(MsgEnum.SUCCESS, userRspDTO);
    }

    //分页查询用户
    @GetMapping("/plist")
    @ResponseBody
    public List<UserDO> pageFindUsers() {

        UserDO userDO = new UserDO();

        userDO.setCreateBy(SecurityUtils.getLoginName());

        List<UserDO> userDOS = PageUtils.pageQuery(1,4,() -> { return this.userService.pageFindUsers(userDO);});

        return userDOS;

    }



//    /**
//     * 分页查询用户列表
//     */
//    @GetMapping("/list")
//    public UserInfoQueryRspDTO getUserInfoPage(@QueryBody UserInfoQueryReqDTO userInfoQueryReqDTO) {
//        UserInfoQueryBO userInfoQueryBO = new UserInfoQueryBO();
//        BeanUtils.copyProperties(userInfoQueryBO, userInfoQueryReqDTO);
//        PageInfo<UserDO> page = userService.findUsers(userInfoQueryBO);
//
//        List<UserInfoDTO> userInfos = BeanConvertUtils.convertList(page.getList(), UserInfoDTO.class);
//        UserInfoQueryRspDTO userInfoQueryRspDTO = new UserInfoQueryRspDTO();
//        userInfoQueryRspDTO.setList(userInfos);
//        userInfoQueryRspDTO.setPageNum(page.getPageNum());
//        userInfoQueryRspDTO.setPageSize(page.getPageSize());
//        userInfoQueryRspDTO.setPages(page.getPages());
//        userInfoQueryRspDTO.setTotal(page.getTotal());
//        userInfoQueryRspDTO.setMsgCd(MsgEnum.SUCCESS.getMsgCd());
//        userInfoQueryRspDTO.setMsgInfo(MsgEnum.SUCCESS.getMsgInfo());
//        return userInfoQueryRspDTO;
//    }



}
