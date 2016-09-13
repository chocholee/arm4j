package com.arm4j.weixin.request.material.response.batchget;

import com.alibaba.fastjson.annotation.JSONField;
import com.arm4j.weixin.request.material.entity.NewsEntity;

import java.util.List;

public class ContentResponse {

    @JSONField(name = "news_item")
    private List<NewsEntity> newsItems;

    public List<NewsEntity> getNewsItems() {
        return newsItems;
    }

    public void setNewsItems(List<NewsEntity> newsItems) {
        this.newsItems = newsItems;
    }
}
