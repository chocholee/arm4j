package com.arm4j.weixin.request.tags;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.arm4j.core.DefaultEntityParam;
import com.arm4j.core.DefaultURLParam;
import com.arm4j.weixin.WeiXinCoreManagement;
import com.arm4j.weixin.WeiXinToken;
import com.arm4j.weixin.exception.WeiXinRequestException;
import com.arm4j.weixin.request.tags.response.TagsUserGetResponse;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
public class WeiXinTagsMembersBatchUnTaggingRequest {

    public static void request(String accessToken, int tagid, List<String> openidList) throws WeiXinRequestException {
        Map<String, Object> tagMap = new HashMap<>();
        tagMap.put("tagid", tagid);
        tagMap.put("openid_list", openidList);

        // 发送请求
        String result = WeiXinCoreManagement.getInstance().get(WeiXinToken.TAGS_MEMBERS_BATCHUNTAGGING)
                .createConn()
                .connect(
                        new DefaultURLParam.Builder()
                                .add("access_token", accessToken)
                                .build(),
                        new DefaultEntityParam(JSON.toJSONString(tagMap))
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
