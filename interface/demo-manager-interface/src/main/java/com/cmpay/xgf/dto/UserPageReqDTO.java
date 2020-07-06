package com.cmpay.xgf.dto;

import com.cmpay.framework.data.response.PageableRspDTO;
import lombok.Data;

import java.util.List;

@Data
public class UserPageReqDTO extends PageableRspDTO {

    private List<Integer> Ids;

    public List<Integer> getIds() {
        return Ids;
    }

    public void setIds(List<Integer> ids) {
        Ids = ids;
    }
}
