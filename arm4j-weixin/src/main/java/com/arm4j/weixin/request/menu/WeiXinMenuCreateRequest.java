package com.arm4j.weixin.request.menu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.arm4j.core.DefaultEntityParam;
import com.arm4j.core.DefaultURLParam;
import com.arm4j.weixin.WeiXinCoreManagement;
import com.arm4j.weixin.WeiXinToken;
import com.arm4j.weixin.exception.WeiXinRequestException;
import com.arm4j.weixin.request.menu.entity.MenuEntity;
import org.apache.commons.lang3.StringUtils;

@SuppressWarnings("unchecked")
public class WeiXinMenuCreateRequest {

    public static void request(String accessToken, MenuEntity entity) throws WeiXinRequestException {
        // 发送请求
        String result = WeiXinCoreManagement.getInstance().get(WeiXinToken.MENU_CREATE)
                .createConn()
                .connect(
                        new DefaultURLParam.Builder()
                                .add("access_token", accessToken)
                                .build(),
                        new DefaultEntityParam(JSON.toJSONString(entity))
                ).doPost();

        // 处理返回结果
        if (!StringUtils.isEmpty(result)) {
            JSONObject resultJSON = JSON.parseObject(result);
            int errCode = resultJSON.getInteger("errcode");
            if (0 != errCode) {
                throw new WeiXinRequestException(result);
            }
        } else {
            throw new WeiXinRequestException("请求失败,原因[未知]");
        }
    }

}
