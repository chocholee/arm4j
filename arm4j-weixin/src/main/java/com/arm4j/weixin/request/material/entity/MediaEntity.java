package com.arm4j.weixin.request.material.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.File;

public class MediaEntity {

    @JSONField(serialize = false, deserialize = false)
    private String name;

    @JSONField(serialize = false, deserialize = false)
    private File file;

    @JSONField(name = "title")
    private String title;

    @JSONField(name = "introduction")
    private String introduction;

    public String getName() {
        return name;
    }

    public File getFile() {
        return file;
    }

    public String getTitle() {
        return title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
