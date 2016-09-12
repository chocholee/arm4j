package com.arm4j.weixin.request.menu.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class MenuEntity {

    @JSONField(name = "menuid")
    private String menuId;

    @JSONField(name = "matchrule")
    private MenuMatchRuleEntity menuMatchRuleEntity;

    @JSONField(name = "button")
    private List<MenuButtonEntity> buttons;

    public String getMenuId() {
        return menuId;
    }

    public MenuMatchRuleEntity getMenuMatchRuleEntity() {
        return menuMatchRuleEntity;
    }

    public List<MenuButtonEntity> getButtons() {
        return buttons;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public void setMenuMatchRuleEntity(MenuMatchRuleEntity menuMatchRuleEntity) {
        this.menuMatchRuleEntity = menuMatchRuleEntity;
    }

    public void setButtons(List<MenuButtonEntity> buttons) {
        this.buttons = buttons;
    }
}
