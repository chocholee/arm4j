package com.arm4j.weixin.request.tags.response;

import com.alibaba.fastjson.annotation.JSONField;

public class TagsUserGetResponse {

    @JSONField(name = "count")
    private int count;

    @JSONField(name = "data")
    private TagsUserGetDataResponse data;

    @JSONField(name = "next_openid")
    private String nextOpenId;

    public int getCount() {
        return count;
    }

    public TagsUserGetDataResponse getData() {
        return data;
    }

    public String getNextOpenId() {
        return nextOpenId;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setData(TagsUserGetDataResponse data) {
        this.data = data;
    }

    public void setNextOpenId(String nextOpenId) {
        this.nextOpenId = nextOpenId;
    }
}
