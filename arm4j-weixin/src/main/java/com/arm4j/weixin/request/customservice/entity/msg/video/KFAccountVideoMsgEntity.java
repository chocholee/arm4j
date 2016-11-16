package com.arm4j.weixin.request.customservice.entity.msg.video;

import com.alibaba.fastjson.annotation.JSONField;
import com.arm4j.weixin.request.customservice.entity.KFAccountMsgEntity;

/**
 * Created by liwenhe on 16/11/16.
 */
public class KFAccountVideoMsgEntity extends KFAccountMsgEntity {

    private String msgType = "video";

    private VideoMsgEntity video;

    @JSONField(name = "msgtype")
    public String getMsgType() {
        return msgType;
    }

    @JSONField(name = "video")
    public VideoMsgEntity getVideo() {
        return video;
    }

    public void setVideo(VideoMsgEntity video) {
        this.video = video;
    }
}
