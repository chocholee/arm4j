package com.arm4j.weixin.request.customservice.entity.msg.mpnews;

import com.alibaba.fastjson.annotation.JSONField;
import com.arm4j.weixin.request.customservice.entity.KFAccountMsgEntity;

/**
 * Created by liwenhe on 16/11/16.
 */
public class KFAccountMpNewsMsgEntity extends KFAccountMsgEntity {

    private String msgType = "mpnews";

    private MpNewsMsgEntity mpNews;

    @JSONField(name = "msgtype")
    public String getMsgType() {
        return msgType;
    }

    @JSONField(name = "mpnews")
    public MpNewsMsgEntity getMpNews() {
        return mpNews;
    }

    public void setMpNews(MpNewsMsgEntity mpNews) {
        this.mpNews = mpNews;
    }
}
