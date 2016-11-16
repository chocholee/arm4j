package com.arm4j.weixin.request.customservice.entity.msg.text;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by liwenhe on 16/11/16.
 */
public class TextMsgEntity {

    private String content;

    @JSONField(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
