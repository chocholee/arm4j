package com.arm4j.weixin.request.customservice.entity.msg.card;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by liwenhe on 16/11/16.
 */
public class CardMsgEntity {

    private String cardId;

    @JSONField(name = "card_id")
    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}
