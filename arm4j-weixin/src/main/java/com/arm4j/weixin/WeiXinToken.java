package com.arm4j.weixin;

public enum WeiXinToken {
    ACCESS_TOKEN("https://api.weixin.qq.com/cgi-bin/token"),                                        // 获取access_token

    GET_CALLBACK_IP("https://api.weixin.qq.com/cgi-bin/getcallbackip"),                             // 获取微信服务器IP地址

    MENU_CREATE("https://api.weixin.qq.com/cgi-bin/menu/create"),                                   // 创建菜单
    MENU_GET("https://api.weixin.qq.com/cgi-bin/menu/get"),                                         // 查询菜单
    MENU_DELETE("https://api.weixin.qq.com/cgi-bin/menu/delete"),                                   // 删除菜单
    MENU_ADD_CONDITIONAL("https://api.weixin.qq.com/cgi-bin/menu/addconditional"),                  // 添加个性化菜单
    MENU_DEL_CONDITIONAL("https://api.weixin.qq.com/cgi-bin/menu/delconditional"),                  // 删除个性化菜单

    MEDIA_UPLOAD("https://api.weixin.qq.com/cgi-bin/media/upload"),                                 // 新增临时素材
    MEDIA_GET("https://api.weixin.qq.com/cgi-bin/media/get"),                                       // 获取临时素材
    MEDIA_UPLOAD_IMG_TO_URL("https://api.weixin.qq.com/cgi-bin/media/uploadimg"),                   // 上传图文消息内的图片获取URL

    MATERIAL_ADD_NEWS("https://api.weixin.qq.com/cgi-bin/material/add_news"),                       // 新增永久图文素材
    MATERIAL_ADD_MATERIAL("https://api.weixin.qq.com/cgi-bin/material/add_material"),               // 新增其他类型永久素材
    MATERIAL_GET_MATERIAL("https://api.weixin.qq.com/cgi-bin/material/get_material"),               // 获取永久素材
    MATERIAL_DEL_MATERIAL("https://api.weixin.qq.com/cgi-bin/material/del_material"),               // 删除永久素材
    MATERIAL_UPDATE_NEWS("https://api.weixin.qq.com/cgi-bin/material/update_news"),                 // 修改永久图文素材
    MATERIAL_GET_MATERIAL_COUNT("https://api.weixin.qq.com/cgi-bin/material/get_materialcount"),    // 获取素材总数
    MATERIAL_BATCH_GET_MATERIAL("https://api.weixin.qq.com/cgi-bin/material/batchget_material"),    // 获取素材列表

    TAGS_CREATE("https://api.weixin.qq.com/cgi-bin/tags/create"),                                   // 创建标签
    TAGS_GET("https://api.weixin.qq.com/cgi-bin/tags/get"),                                         // 获取标签
    TAGS_UPDATE("https://api.weixin.qq.com/cgi-bin/tags/update"),                                   // 编辑标签
    TAGS_DELETE("https://api.weixin.qq.com/cgi-bin/tags/delete"),                                   // 删除标签
    TAGS_USER_GET("https://api.weixin.qq.com/cgi-bin/user/tag/get"),                                // 获取标签下粉丝列表
    TAGS_GETIDLIST("https://api.weixin.qq.com/cgi-bin/tags/getidlist"),                             // 获取用户身上的标签列表
    TAGS_MEMBERS_BATCHTAGGING("https://api.weixin.qq.com/cgi-bin/tags/members/batchtagging"),       // 批量为用户打标签
    TAGS_MEMBERS_BATCHUNTAGGING("https://api.weixin.qq.com/cgi-bin/tags/members/batchuntagging"),   // 批量为用户取消标签

    USER_INFO_UPDATE_REMARK("https://api.weixin.qq.com/cgi-bin/user/info/updateremark"),            // 设置用户备注名
    USER_INFO_GET("https://api.weixin.qq.com/cgi-bin/user/info"),                                   // 获取用户基本信息
    USER_INFO_BATCH_GET("https://api.weixin.qq.com/cgi-bin/user/info/batchget"),                    // 批量获取用户信息
    USER_LIST_GET("https://api.weixin.qq.com/cgi-bin/user/get"),                                    // 获取用户列表

    SHORT_URL("https://api.weixin.qq.com/cgi-bin/shorturl"),                                        // 长链接转短链接接口

    QRCODE_CREATE("https://api.weixin.qq.com/cgi-bin/qrcode/create"),                               // 创建二维码ticket
    QRCODE_SHOW("https://mp.weixin.qq.com/cgi-bin/showqrcode");                                     // 通过ticket换取二维码

    private final String name;

    WeiXinToken(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
