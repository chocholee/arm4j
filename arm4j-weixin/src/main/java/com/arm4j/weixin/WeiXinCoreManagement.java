package com.arm4j.weixin;

import com.arm4j.core.HttpURLConnFactory;
import com.arm4j.core.HttpURLConnFactoryManager;

import java.util.HashMap;
import java.util.Map;

/**
 * 微信核心管理工具(单例)
 *
 * @author liwenhe
 */
@SuppressWarnings("unchecked")
public class WeiXinCoreManagement {

    private static final Map factoryPool = new HashMap<String, HttpURLConnFactory>();

    // 初始化默认参数
    static {
        HttpURLConnFactory accessTokenFactory = new HttpURLConnFactory("https://api.weixin.qq.com/cgi-bin/token");
        HttpURLConnFactory getCallbackIpFactory = new HttpURLConnFactory("https://api.weixin.qq.com/cgi-bin/getcallbackip");
        factoryPool.put(WeiXinToken.ACCESS_TOKEN, accessTokenFactory);
        factoryPool.put(WeiXinToken.GET_CALLBACK_IP, getCallbackIpFactory);
    }

    private static WeiXinCoreManagement instance = null;

    private HttpURLConnFactoryManager connFactoryManager = null;

    private WeiXinCoreManagement() {
        this.connFactoryManager = new HttpURLConnFactoryManager<WeiXinToken, HttpURLConnFactory>(factoryPool);
    }

    public static HttpURLConnFactoryManager getInstance() {
        if (null == instance) {
            synchronized (WeiXinCoreManagement.class) {
                if (null == instance) {
                    instance = new WeiXinCoreManagement();
                    return instance.connFactoryManager;
                }
            }
        }
        return instance.connFactoryManager;
    }
}
