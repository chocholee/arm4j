package com.arm4j.weixin.request.user.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class UserInfoBatchGetEntity {

    @JSONField(name = "openid")
    private String openId;

    @JSONField(name = "lang")
    private String lang;

    public String getOpenId() {
        return openId;
    }

    public String getLang() {
        return lang;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
