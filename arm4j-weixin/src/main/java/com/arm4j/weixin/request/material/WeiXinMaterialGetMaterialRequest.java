package com.arm4j.weixin.request.material;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.arm4j.core.DefaultEntityParam;
import com.arm4j.core.DefaultURLParam;
import com.arm4j.weixin.WeiXinCoreManagement;
import com.arm4j.weixin.WeiXinToken;
import com.arm4j.weixin.exception.WeiXinRequestException;
import com.arm4j.weixin.request.material.entity.NewsEntity;
import com.arm4j.weixin.request.material.response.VideoResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.util.CharArrayBuffer;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class WeiXinMaterialGetMaterialRequest {

    /**
     * @param accessToken
     * @param mediaId
     * @param <T>   List<NewsEntity> | VideoResponse | InputStream
     * @return      List<NewsEntity> | VideoResponse | InputStream
     * @throws WeiXinRequestException
     */
    public static <T> T request(String accessToken, String mediaId) throws WeiXinRequestException {
        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("media_id", mediaId);

        // 发送请求
        InputStream is = WeiXinCoreManagement.getInstance().get(WeiXinToken.MATERIAL_GET_MATERIAL)
                .createConn()
                .connect(
                        new DefaultURLParam.Builder()
                                .add("access_token", accessToken)
                                .build(),
                        new DefaultEntityParam(JSON.toJSONString(bodyMap))
                ).doPostAsStream();

        try {
            final Reader reader = new InputStreamReader(is, "utf-8");
            final CharArrayBuffer buffer = new CharArrayBuffer(is.available());
            final char[] tmp = new char[1024];
            int l;
            while ((l = reader.read(tmp)) != -1) {
                buffer.append(tmp, 0, l);
            }

            // 处理返回结果
            String result = buffer.toString();
            if (!StringUtils.isEmpty(result)) {
                try {
                    JSONObject resultJSON = JSON.parseObject(result);
                    if (resultJSON.containsKey("news_item")) {
                        String newsItemStr = resultJSON.getString("news_item");
                        return (T) JSON.parseArray(newsItemStr, NewsEntity.class);
                    } else if (resultJSON.containsKey("down_url")) {
                        return (T) JSON.parseObject(result, VideoResponse.class);
                    } else {
                        throw new WeiXinRequestException("获取的素材不是图文素材或视频素材");
                    }
                } finally {
                    reader.close();
                    is.close();
                }
            }
        } catch (IOException e) {
            throw new WeiXinRequestException(e);
        } catch (JSONException e) {
            return (T) is;
        }
        throw new WeiXinRequestException("请求失败,原因[未知]");
    }

}
