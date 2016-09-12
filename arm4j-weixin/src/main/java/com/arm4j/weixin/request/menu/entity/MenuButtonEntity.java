package com.arm4j.weixin.request.menu.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class MenuButtonEntity {

    @JSONField(name = "name")
    private String name;

    @JSONField(name = "type")
    private String type;

    @JSONField(name = "key")
    private String key;

    @JSONField(name = "url")
    private String url;

    @JSONField(name = "media_id")
    private String mediaId;

    @JSONField(name = "sub_button")
    private List<MenuButtonEntity> subButton;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getKey() {
        return key;
    }

    public String getUrl() {
        return url;
    }

    public String getMediaId() {
        return mediaId;
    }

    public List<MenuButtonEntity> getSubButton() {
        return subButton;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public void setSubButton(List<MenuButtonEntity> subButton) {
        this.subButton = subButton;
    }
}
