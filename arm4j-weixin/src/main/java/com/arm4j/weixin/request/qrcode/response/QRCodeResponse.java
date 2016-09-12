package com.arm4j.weixin.request.qrcode.response;

import com.alibaba.fastjson.annotation.JSONField;

public class QRCodeResponse {

    @JSONField(name = "url")
    private String url;

    @JSONField(name = "ticket")
    private String ticket;

    @JSONField(name = "expire_seconds")
    private int expireSeconds;

    public String getUrl() {
        return url;
    }

    public String getTicket() {
        return ticket;
    }

    public int getExpireSeconds() {
        return expireSeconds;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public void setExpireSeconds(int expireSeconds) {
        this.expireSeconds = expireSeconds;
    }
}
