package com.cmpay.xgf.controller;

import com.cmpay.framework.data.request.GenericDTO;
import com.cmpay.framework.data.response.GenericRspDTO;
import com.cmpay.lemon.framework.annotation.QueryBody;
import com.cmpay.xgf.TestService;
import com.cmpay.xgf.dto.UserRspDTO;
import com.cmpay.xgf.enums.MsgEnum;
import com.cmpay.xgf.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lihuiquan
 */
@RestController
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/user/info")
    public GenericRspDTO<UserRspDTO> getAuditDepartmentInfo(@QueryBody GenericDTO genericDTO) {
        UserRspDTO userRspDTO=new UserRspDTO();
        userRspDTO.setUserName(testService.getUserName());
        return GenericRspDTO.newInstance(MsgEnum.SUCCESS, userRspDTO);

    }
}
