package com.arm4j.weixin.request.user.response;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class UserListDataResponse {

    @JSONField(name = "openid")
    private List<String> openIds;

    public List<String> getOpenIds() {
        return openIds;
    }

    public void setOpenIds(List<String> openIds) {
        this.openIds = openIds;
    }
}
