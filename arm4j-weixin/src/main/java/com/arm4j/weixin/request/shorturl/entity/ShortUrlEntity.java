package com.arm4j.weixin.request.shorturl.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class ShortUrlEntity {

    @JSONField(name = "action")
    private String action;

    @JSONField(name = "long_url")
    private String longUrl;

    public String getAction() {
        return action;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }
}
