package com.arm4j.weixin.request.customservice.entity.msg.music;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by liwenhe on 16/11/16.
 */
public class MusicMsgEntity {

    private String title;

    private String description;

    private String musicUrl;

    private String hqMusicUrl;

    private String thumbMediaId;

    @JSONField(name = "title")
    public String getTitle() {
        return title;
    }

    @JSONField(name = "description")
    public String getDescription() {
        return description;
    }

    @JSONField(name = "musicurl")
    public String getMusicUrl() {
        return musicUrl;
    }

    @JSONField(name = "hqmusicurl")
    public String getHqMusicUrl() {
        return hqMusicUrl;
    }

    @JSONField(name = "thumb_media_id")
    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }

    public void setHqMusicUrl(String hqMusicUrl) {
        this.hqMusicUrl = hqMusicUrl;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }
}
