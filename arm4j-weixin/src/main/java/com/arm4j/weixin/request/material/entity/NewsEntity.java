package com.arm4j.weixin.request.material.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class NewsEntity {

    @JSONField(name = "title")
    private String title;

    @JSONField(name = "thumb_media_id")
    private String thumbMediaId;

    @JSONField(name = "author")
    private String author;

    @JSONField(name = "digest")
    private String digest;

    @JSONField(name = "content_source_url")
    private String contentSourceUrl;

    @JSONField(name = "content")
    private String content;

    @JSONField(name = "show_cover_pic")
    private int showCoverPic;

    public String getTitle() {
        return title;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public String getAuthor() {
        return author;
    }

    public String getDigest() {
        return digest;
    }

    public String getContentSourceUrl() {
        return contentSourceUrl;
    }

    public String getContent() {
        return content;
    }

    public int getShowCoverPic() {
        return showCoverPic;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public void setContentSourceUrl(String contentSourceUrl) {
        this.contentSourceUrl = contentSourceUrl;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setShowCoverPic(int showCoverPic) {
        this.showCoverPic = showCoverPic;
    }
}