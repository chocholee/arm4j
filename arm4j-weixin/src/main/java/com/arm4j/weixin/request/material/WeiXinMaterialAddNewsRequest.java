package com.arm4j.weixin.request.material;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.arm4j.core.DefaultEntityParam;
import com.arm4j.core.DefaultURLParam;
import com.arm4j.weixin.WeiXinCoreManagement;
import com.arm4j.weixin.WeiXinToken;
import com.arm4j.weixin.exception.WeiXinRequestException;
import com.arm4j.weixin.request.material.entity.NewsEntity;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
public class WeiXinMaterialAddNewsRequest {

    public static String request(String accessToken, List<NewsEntity> articles) throws WeiXinRequestException {
        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("articles", articles);

        // 发送请求
        String result = WeiXinCoreManagement.getInstance().get(WeiXinToken.MATERIAL_ADD_NEWS)
                .createConn()
                .connect(
                        new DefaultURLParam.Builder()
                                .add("access_token", accessToken)
                                .build(),
                        new DefaultEntityParam(JSON.toJSONString(bodyMap))
                ).doPost();

        // 处理返回结果
        if (!StringUtils.isEmpty(result)) {
            JSONObject resultJSON = JSON.parseObject(result);
            if (!resultJSON.containsKey("errcode")) {
                return resultJSON.getString("media_id");
            } else {
                throw new WeiXinRequestException(result);
            }
        }
        throw new WeiXinRequestException("请求失败,原因[未知]");
    }

}
