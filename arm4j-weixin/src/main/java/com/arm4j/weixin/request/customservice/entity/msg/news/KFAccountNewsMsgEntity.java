package com.arm4j.weixin.request.customservice.entity.msg.news;

import com.alibaba.fastjson.annotation.JSONField;
import com.arm4j.weixin.request.customservice.entity.KFAccountMsgEntity;

/**
 * Created by liwenhe on 16/11/16.
 */
public class KFAccountNewsMsgEntity extends KFAccountMsgEntity {

    private String msgType = "news";

    private NewsMsgEntity news;

    @JSONField(name = "msgtype")
    public String getMsgType() {
        return msgType;
    }

    @JSONField(name = "news")
    public NewsMsgEntity getNews() {
        return news;
    }

    public void setNews(NewsMsgEntity news) {
        this.news = news;
    }
}
