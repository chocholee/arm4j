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
public class WeiXinTagsUpdateRequest {

    public static boolean request(String accessToken, TagsEntity entity) throws WeiXinRequestException {
        Map<String, Map<String, Object>> map = new HashMap<>();
        Map<String, Object> tagMap = new HashMap<>();
        tagMap.put("name", entity.getName());
        tagMap.put("id", entity.getId());
        map.put("tag", tagMap);

        // 发送请求
        String result = WeiXinCoreManagement.getInstance().get(WeiXinToken.TAGS_UPDATE)
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
            int errCode = resultJSON.getInteger("errcode");
            return 0 == errCode;
        }
        throw new WeiXinRequestException("请求失败,原因[未知]");
    }

}
