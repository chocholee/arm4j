package com.arm4j.weixin.request.customservice.entity.msg.voice;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by liwenhe on 16/11/16.
 */
public class VoiceMsgEntity {

    private String mediaId;

    @JSONField(name = "media_id")
    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
