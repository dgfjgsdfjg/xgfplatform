package com.cmpay.xgf.controller;


import com.cmpay.lemon.framework.utils.IdGenUtils;
import com.cmpay.lemon.framework.utils.PageUtils;
import com.cmpay.xgf.dto.UserDTO;
import com.cmpay.xgf.entity.RoleDO;
import com.cmpay.xgf.service.LoginService;
import com.cmpay.xgf.service.RoleService;
import com.cmpay.xgf.service.UserService;
import com.cmpay.xgf.entity.UserDO;
import com.cmpay.xgf.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author lihuiquan
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    LoginService loginService;
    @Autowired
    RoleService roleService;

    @PostMapping("/reg")
    @ResponseBody
    public UserDO reg(@RequestBody UserDO userDO) {

        userDO.setuId(Integer.valueOf(IdGenUtils.generateId("XGF_ID")));

        userDO.setPassword(Md5.md5(userDO.getPassword()));

        userDO.setCreateBy("xgf");

        userDO.setCreateDate(LocalDateTime.now().toString());

        userDO.setUpdateBy("xgf");

        userDO.setUpdateDate(LocalDateTime.now().toString());

        userDO.setIsUsed(1);

        userService.regist(userDO);

        int userRoleId = Integer.valueOf(IdGenUtils.generateId("XGF_ID"));

        RoleDO roleDO = roleService.selectRoleByRoleName(userDO.getRoleName());

        userService.insertRole(userDO.getuId(),userRoleId,roleDO.getRoleId());

        return userDO;

    }


    @PutMapping("/delete")
    @ResponseBody
    public void delete(@RequestBody UserDO userDO) {

        userDO.setIsUsed(0);

        userDO.setUpdateBy("xgf");

        userDO.setUpdateDate(LocalDateTime.now().toString());

        userService.delete(userDO);

    }

    //查询用户
    @GetMapping("/list")
    @ResponseBody
    public List<UserDO> findUsers() {

        UserDO userDO = new UserDO();

        userDO.setCreateBy("xgf");

        return userService.findUsers(userDO);

    }

    //分页查询用户
    @GetMapping("/plist")
    @ResponseBody
    public List<UserDO> pageFindUsers() {

        UserDO userDO = new UserDO();

        userDO.setCreateBy("xgf");

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
