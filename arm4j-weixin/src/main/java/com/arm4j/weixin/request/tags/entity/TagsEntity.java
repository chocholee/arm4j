package com.arm4j.weixin.request.tags.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class TagsEntity {

    @JSONField(name = "id")
    private int id;

    @JSONField(name = "count")
    private int count;

    @JSONField(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public int getCount() {
        return count;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
