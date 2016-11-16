package com.arm4j.weixin.request.customservice.entity.msg.text;

import com.alibaba.fastjson.annotation.JSONField;
import com.arm4j.weixin.request.customservice.entity.KFAccountMsgEntity;

/**
 * Created by liwenhe on 16/11/16.
 */
public class KFAccountTextMsgEntity extends KFAccountMsgEntity {

    private String msgType = "text";

    private TextMsgEntity text;

    @JSONField(name = "msgtype")
    public String getMsgType() {
        return msgType;
    }

    @JSONField(name = "text")
    public TextMsgEntity getText() {
        return text;
    }

    public void setText(TextMsgEntity text) {
        this.text = text;
    }
}
