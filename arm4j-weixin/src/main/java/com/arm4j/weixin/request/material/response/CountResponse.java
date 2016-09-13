package com.arm4j.weixin.request.material.response;

import com.alibaba.fastjson.annotation.JSONField;

public class CountResponse {

    @JSONField(name = "voice_count")
    private String voiceCount;

    @JSONField(name = "video_count")
    private String videoCount;

    @JSONField(name = "image_count")
    private String imageCount;

    @JSONField(name = "news_count")
    private String newsCount;

    public String getVoiceCount() {
        return voiceCount;
    }

    public String getVideoCount() {
        return videoCount;
    }

    public String getImageCount() {
        return imageCount;
    }

    public String getNewsCount() {
        return newsCount;
    }

    public void setVoiceCount(String voiceCount) {
        this.voiceCount = voiceCount;
    }

    public void setVideoCount(String videoCount) {
        this.videoCount = videoCount;
    }

    public void setImageCount(String imageCount) {
        this.imageCount = imageCount;
    }

    public void setNewsCount(String newsCount) {
        this.newsCount = newsCount;
    }
}
