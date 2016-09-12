package com.arm4j.weixin.request.tags.response;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class TagsUserGetDataResponse {

    @JSONField(name = "openid")
    private List<String> openId;

    public List<String> getOpenId() {
        return openId;
    }

    public void setOpenId(List<String> openId) {
        this.openId = openId;
    }
}
