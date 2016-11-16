package com.arm4j.weixin.request.customservice.entity.msg.news;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by liwenhe on 16/11/16.
 */
public class NewsArticleMsgEntity {

    private String title;

    private String description;

    private String url;

    private String picUrl;

    @JSONField(name = "title")
    public String getTitle() {
        return title;
    }

    @JSONField(name = "description")
    public String getDescription() {
        return description;
    }

    @JSONField(name = "url")
    public String getUrl() {
        return url;
    }

    @JSONField(name = "picurl")
    public String getPicUrl() {
        return picUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
