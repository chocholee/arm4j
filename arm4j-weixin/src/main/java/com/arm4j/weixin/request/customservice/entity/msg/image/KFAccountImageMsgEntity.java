package com.arm4j.weixin.request.customservice.entity.msg.image;

import com.alibaba.fastjson.annotation.JSONField;
import com.arm4j.weixin.request.customservice.entity.KFAccountMsgEntity;

/**
 * Created by liwenhe on 16/11/16.
 */
public class KFAccountImageMsgEntity extends KFAccountMsgEntity {

    private String msgType = "image";

    private ImageMsgEntity image;

    @JSONField(name = "msgtype")
    public String getMsgType() {
        return msgType;
    }

    @JSONField(name = "image")
    public ImageMsgEntity getImage() {
        return image;
    }

    public void setImage(ImageMsgEntity image) {
        this.image = image;
    }
}
