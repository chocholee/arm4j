package com.arm4j.weixin.request.tags;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.arm4j.core.DefaultEntityParam;
import com.arm4j.core.DefaultURLParam;
import com.arm4j.weixin.WeiXinCoreManagement;
import com.arm4j.weixin.WeiXinToken;
import com.arm4j.weixin.exception.WeiXinRequestException;
import com.arm4j.weixin.request.tags.entity.TagsEntity;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class WeiXinTagsCreateRequest {

    public static TagsEntity request(String accessToken, TagsEntity entity) throws WeiXinRequestException {
        Map<String, Map<String, String>> map = new HashMap<>();
        Map<String, String> tagMap = new HashMap<>();
        tagMap.put("name", entity.getName());
        map.put("tag", tagMap);

        // 发送请求
        String result = WeiXinCoreManagement.getInstance().get(WeiXinToken.TAGS_CREATE)
                .createConn()
                .connect(
                        new DefaultURLParam.Builder()
                                .add("access_token", accessToken)
                                .build(),
                        new DefaultEntityParam(JSON.toJSONString(map))
                ).doPost();

        // 处理返回结果
        if (!StringUtils.isEmpty(result)) {
            JSONObject resultJSON = JSON.parseObject(result);
            if (resultJSON.containsKey("tag"))
                return resultJSON.getObject("tag", TagsEntity.class);
            else {
                throw new WeiXinRequestException(result);
            }
        }
        throw new WeiXinRequestException("请求失败,原因[未知]");
    }

}
