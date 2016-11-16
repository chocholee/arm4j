package com.arm4j.weixin.request.customservice.entity.msg.voice;

import com.alibaba.fastjson.annotation.JSONField;
import com.arm4j.weixin.request.customservice.entity.KFAccountMsgEntity;

/**
 * Created by liwenhe on 16/11/16.
 */
public class KFAccountVoiceMsgEntity extends KFAccountMsgEntity {

    private String msgType = "voice";

    private VoiceMsgEntity voice;

    @JSONField(name = "msgtype")
    public String getMsgType() {
        return msgType;
    }

    @JSONField(name = "voice")
    public VoiceMsgEntity getVoice() {
        return voice;
    }

    public void setVoice(VoiceMsgEntity voice) {
        this.voice = voice;
    }
}
