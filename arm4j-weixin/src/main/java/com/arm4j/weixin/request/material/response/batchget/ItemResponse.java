package com.arm4j.weixin.request.material.response.batchget;

import com.alibaba.fastjson.annotation.JSONField;

public class ItemResponse {

    @JSONField(name = "media_id")
    private String mediaId;

    @JSONField(name = "content")
    private ContentResponse content;

    @JSONField(name = "name")
    private String name;

    @JSONField(name = "update_time")
    private String updateTime;

    @JSONField(name = "url")
    private String url;

    public String getMediaId() {
        return mediaId;
    }

    public ContentResponse getContent() {
        return content;
    }

    public String getName() {
        return name;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public String getUrl() {
        return url;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public void setContent(ContentResponse content) {
        this.content = content;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
