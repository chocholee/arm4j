package com.arm4j.weixin.request.customservice.entity.msg.video;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by liwenhe on 16/11/16.
 */
public class VideoMsgEntity {

    private String mediaId;

    private String thumbMediaId;

    private String title;

    private String description;

    @JSONField(name = "media_id")
    public String getMediaId() {
        return mediaId;
    }

    @JSONField(name = "thumb_media_id")
    public String getThumbMediaId() {
        return thumbMediaId;
    }

    @JSONField(name = "title")
    public String getTitle() {
        return title;
    }

    @JSONField(name = "description")
    public String getDescription() {
        return description;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
