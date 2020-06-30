package com.cmpay.xgf.dto;

import com.cmpay.framework.data.response.PageableRspDTO;
import lombok.Data;

import java.util.List;

@Data
public class UserPageRspDTO extends PageableRspDTO {

    private List<UserInfoDTO> list;

    public List<UserInfoDTO> getList() {
        return list;
    }

    public void setList(List<UserInfoDTO> list) {
        this.list = list;
    }

}
