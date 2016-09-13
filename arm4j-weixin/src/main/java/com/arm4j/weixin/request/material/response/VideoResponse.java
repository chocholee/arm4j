package com.arm4j.weixin.request.material.response;

import com.alibaba.fastjson.annotation.JSONField;

public class VideoResponse {

    @JSONField(name = "title")
    private String title;

    @JSONField(name = "description")
    private String description;

    @JSONField(name = "down_url")
    private String downUrl;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDownUrl() {
        return downUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDownUrl(String downUrl) {
        this.downUrl = downUrl;
    }
}
