package com.arm4j.weixin.request.customservice.entity.msg.card;

import com.alibaba.fastjson.annotation.JSONField;
import com.arm4j.weixin.request.customservice.entity.KFAccountMsgEntity;

/**
 * Created by liwenhe on 16/11/16.
 */
public class KFAccountCardMsgEntity extends KFAccountMsgEntity {

    private String msgType = "wxcard";

    private KFAccountCardMsgEntity wxCard;

    @JSONField(name = "msgtype")
    public String getMsgType() {
        return msgType;
    }

    @JSONField(name = "wxcard")
    public KFAccountCardMsgEntity getWxCard() {
        return wxCard;
    }

    public void setWxCard(KFAccountCardMsgEntity wxCard) {
        this.wxCard = wxCard;
    }
}
