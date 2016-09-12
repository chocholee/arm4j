package com.arm4j.weixin.request.menu.response.menu;

import com.alibaba.fastjson.annotation.JSONField;
import com.arm4j.weixin.request.menu.entity.menu.MenuEntity;

import java.util.List;

public class MenuResponse {

    @JSONField(name = "menu")
    private List<MenuEntity> menus;

    @JSONField(name = "conditionalmenu")
    private List<MenuEntity> conditionalMenu;

    public List<MenuEntity> getMenus() {
        return menus;
    }

    public List<MenuEntity> getConditionalMenu() {
        return conditionalMenu;
    }

    public void setMenus(List<MenuEntity> menus) {
        this.menus = menus;
    }

    public void setConditionalMenu(List<MenuEntity> conditionalMenu) {
        this.conditionalMenu = conditionalMenu;
    }
}
