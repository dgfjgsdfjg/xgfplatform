package com.cmpay.xgf.dto;

import com.cmpay.framework.data.response.PageableRspDTO;
import lombok.Data;

import java.util.List;

@Data
public class UserPageReqDTO extends PageableRspDTO {

    private UserInfoDTO user;

    private List<Integer> usersIds;
}
