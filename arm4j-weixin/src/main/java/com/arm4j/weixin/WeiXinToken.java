package com.arm4j.weixin;

public enum WeiXinToken {
    ACCESS_TOKEN("https://api.weixin.qq.com/cgi-bin/token"),                        // 获取access_token

    GET_CALLBACK_IP("https://api.weixin.qq.com/cgi-bin/getcallbackip"),             // 获取微信服务器IP地址

    MENU_CREATE("https://api.weixin.qq.com/cgi-bin/menu/create"),                   // 创建菜单
    MENU_GET("https://api.weixin.qq.com/cgi-bin/menu/get"),                         // 查询菜单
    MENU_DELETE("https://api.weixin.qq.com/cgi-bin/menu/delete"),                   // 删除菜单
    MENU_ADD_CONDITIONAL("https://api.weixin.qq.com/cgi-bin/menu/addconditional"),  // 添加个性化菜单
    MENU_DEL_CONDITIONAL("https://api.weixin.qq.com/cgi-bin/menu/delconditional"),  // 删除个性化菜单

    TAGS_CREATE("https://api.weixin.qq.com/cgi-bin/tags/create"),                   // 创建标签
    TAGS_GET("https://api.weixin.qq.com/cgi-bin/tags/get"),                         // 获取标签
    TAGS_UPDATE("https://api.weixin.qq.com/cgi-bin/tags/update"),                   // 编辑标签
    TAGS_DELETE("https://api.weixin.qq.com/cgi-bin/tags/delete"),                   // 删除标签
    TAGS_USER_GET("https://api.weixin.qq.com/cgi-bin/user/tag/get"),                // 获取标签下粉丝列表
    TAGS_GETIDLIST("https://api.weixin.qq.com/cgi-bin/tags/getidlist"),             // 获取用户身上的标签列表
    TAGS_MEMBERS_BATCHTAGGING("https://api.weixin.qq.com/cgi-bin/tags/members/batchtagging"),       // 批量为用户打标签
    TAGS_MEMBERS_BATCHUNTAGGING("https://api.weixin.qq.com/cgi-bin/tags/members/batchuntagging"),   // 批量为用户取消标签

    USER_INFO_UPDATE_REMARK("https://api.weixin.qq.com/cgi-bin/user/info/updateremark"),            // 设置用户备注名
    USER_INFO_GET("https://api.weixin.qq.com/cgi-bin/user/info"),                                   // 获取用户基本信息
    USER_INFO_BATCH_GET("https://api.weixin.qq.com/cgi-bin/user/info/batchget"),                    // 批量获取用户信息
    USER_LIST_GET("https://api.weixin.qq.com/cgi-bin/user/get"),                                    // 获取用户列表

    SHORT_URL("https://api.weixin.qq.com/cgi-bin/shorturl"),                        // 长链接转短链接接口

    QRCODE_CREATE("https://api.weixin.qq.com/cgi-bin/qrcode/create"),               // 创建二维码ticket
    QRCODE_SHOW("https://mp.weixin.qq.com/cgi-bin/showqrcode");                     // 通过ticket换取二维码

    private final String name;

    WeiXinToken(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
