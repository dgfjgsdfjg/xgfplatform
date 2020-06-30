package com.cmpay.xgf.dto;

import com.cmpay.framework.data.response.PageableRspDTO;

import java.util.List;

public class RolePageRspDTO extends PageableRspDTO {
    private List<RoleInfoDTO> list;

    public List<RoleInfoDTO> getList() {
        return list;
    }

    public void setList(List<RoleInfoDTO> list) {
        this.list = list;
    }
}
