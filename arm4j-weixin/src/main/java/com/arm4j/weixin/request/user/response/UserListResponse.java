package com.arm4j.weixin.request.user.response;

import com.alibaba.fastjson.annotation.JSONField;

public class UserListResponse {

    @JSONField(name = "total")
    private Integer total;

    @JSONField(name = "count")
    private Integer count;

    @JSONField(name = "data")
    private UserListDataResponse data;

    @JSONField(name = "next_openid")
    private String nextOpenId;

    public Integer getTotal() {
        return total;
    }

    public Integer getCount() {
        return count;
    }

    public UserListDataResponse getData() {
        return data;
    }

    public String getNextOpenId() {
        return nextOpenId;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setData(UserListDataResponse data) {
        this.data = data;
    }

    public void setNextOpenId(String nextOpenId) {
        this.nextOpenId = nextOpenId;
    }
}
