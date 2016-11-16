package com.arm4j.weixin.request.customservice.entity.msg.music;

import com.alibaba.fastjson.annotation.JSONField;
import com.arm4j.weixin.request.customservice.entity.KFAccountMsgEntity;

/**
 * Created by liwenhe on 16/11/16.
 */
public class KFAccountMusicMsgEntity extends KFAccountMsgEntity {

    private String msgType = "music";

    private MusicMsgEntity music;

    @JSONField(name = "msgtype")
    public String getMsgType() {
        return msgType;
    }

    @JSONField(name = "music")
    public MusicMsgEntity getMusic() {
        return music;
    }

    public void setMusic(MusicMsgEntity music) {
        this.music = music;
    }
}
