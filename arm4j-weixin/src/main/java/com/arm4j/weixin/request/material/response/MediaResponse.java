package com.arm4j.weixin.request.material.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.arm4j.weixin.request.material.entity.MediaType;

public class MediaResponse {

    @JSONField(name = "type", deserialize = false)
    private MediaType type;

    @JSONField(name = "media_id")
    private String mediaId;

    @JSONField(name = "url")
    private String url;

    @JSONField(name = "created_at")
    private long createdAt;

    public MediaType getType() {
        return type;
    }

    public String getMediaId() {
        return mediaId;
    }

    public String getUrl() {
        return url;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setType(MediaType type) {
        this.type = type;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }
}
