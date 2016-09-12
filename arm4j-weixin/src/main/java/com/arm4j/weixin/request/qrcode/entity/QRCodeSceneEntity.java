package com.arm4j.weixin.request.qrcode.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class QRCodeSceneEntity {

    @JSONField(name = "scene_id")
    private String sceneId;

    @JSONField(name = "scene_str")
    private String sceneStr;

    public String getSceneId() {
        return sceneId;
    }

    public String getSceneStr() {
        return sceneStr;
    }

    public void setSceneId(String sceneId) {
        this.sceneId = sceneId;
    }

    public void setSceneStr(String sceneStr) {
        this.sceneStr = sceneStr;
    }
}
