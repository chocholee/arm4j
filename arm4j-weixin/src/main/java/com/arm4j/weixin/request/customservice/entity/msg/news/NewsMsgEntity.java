package com.arm4j.weixin.request.customservice.entity.msg.news;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by liwenhe on 16/11/16.
 */
public class NewsMsgEntity {

    private List<NewsArticleMsgEntity> articles;

    @JSONField(name = "articles")
    public List<NewsArticleMsgEntity> getArticles() {
        return articles;
    }

    public void setArticles(List<NewsArticleMsgEntity> articles) {
        this.articles = articles;
    }
}
