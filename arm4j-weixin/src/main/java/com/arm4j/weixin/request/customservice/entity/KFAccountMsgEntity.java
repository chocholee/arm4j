package com.arm4j.weixin.request.customservice.entity;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by liwenhe on 16/11/16.
 */
public abstract class KFAccountMsgEntity {

    private String toUser;

    @JSONField(name = "touser")
    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }
}
