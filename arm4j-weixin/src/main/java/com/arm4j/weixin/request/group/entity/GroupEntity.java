package com.arm4j.weixin.request.group.entity;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by liwenhe on 16/11/23.
 */
public class GroupEntity {

    @JSONField(name = "id")
    private Integer id;

    @JSONField(name = "name")
    private String name;

    @JSONField(name = "count")
    private Integer count;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCount() {
        return count;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
