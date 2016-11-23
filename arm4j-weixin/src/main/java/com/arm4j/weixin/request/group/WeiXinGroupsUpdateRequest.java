package com.arm4j.weixin.request.group;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.arm4j.core.DefaultEntityParam;
import com.arm4j.core.DefaultURLParam;
import com.arm4j.weixin.WeiXinCoreManagement;
import com.arm4j.weixin.WeiXinToken;
import com.arm4j.weixin.exception.WeiXinRequestException;
import com.arm4j.weixin.request.group.entity.GroupEntity;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liwenhe on 16/11/23.
 */
@SuppressWarnings("unchecked")
public class WeiXinGroupsUpdateRequest {

    public static void request(String accessToken, GroupEntity group) throws WeiXinRequestException {
        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("group", group);

        // 发送请求
        String result = WeiXinCoreManagement.getInstance().get(WeiXinToken.GROUPS_UPDATE)
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
            int errCode = resultJSON.getInteger("errcode");
            if (0 != errCode) {
                throw new WeiXinRequestException(result);
            }
        } else {
            throw new WeiXinRequestException("请求失败,原因[未知]");
        }
    }

}
