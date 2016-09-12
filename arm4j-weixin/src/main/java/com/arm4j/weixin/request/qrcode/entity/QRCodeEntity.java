package com.arm4j.weixin.request.qrcode.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class QRCodeEntity {

    @JSONField(name = "action_name")
    private String actionName;

    @JSONField(name = "action_info")
    private QRCodeActionEntity actionInfo;

    @JSONField(name = "expire_seconds")
    private int expireSeconds;

    public String getActionName() {
        return actionName;
    }

    public QRCodeActionEntity getActionInfo() {
        return actionInfo;
    }

    public int getExpireSeconds() {
        return expireSeconds;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public void setActionInfo(QRCodeActionEntity actionInfo) {
        this.actionInfo = actionInfo;
    }

    public void setExpireSeconds(int expireSeconds) {
        this.expireSeconds = expireSeconds;
    }
}
