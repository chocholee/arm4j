package com.arm4j.weixin.request.material.response.batchget;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class BatchGetResponse {

    @JSONField(name = "total_count")
    private int totalCount;

    @JSONField(name = "item_count")
    private int itemCount;

    @JSONField(name = "item")
    private List<ItemResponse> items;

    public int getTotalCount() {
        return totalCount;
    }

    public int getItemCount() {
        return itemCount;
    }

    public List<ItemResponse> getItems() {
        return items;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public void setItems(List<ItemResponse> items) {
        this.items = items;
    }
}
