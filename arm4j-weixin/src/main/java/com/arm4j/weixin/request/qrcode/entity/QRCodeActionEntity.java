package com.arm4j.weixin.request.qrcode.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class QRCodeActionEntity {

    @JSONField(name = "scene")
    private QRCodeSceneEntity scene;

    public QRCodeSceneEntity getScene() {
        return scene;
    }

    public void setScene(QRCodeSceneEntity scene) {
        this.scene = scene;
    }
}
