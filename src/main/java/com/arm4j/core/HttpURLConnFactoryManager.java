package com.arm4j.core;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 用于管理 {@code HttpURLConnFactory} 的容器，需要使用时取出即可
 * 容器为Map，map的key为别名，map的value为{@code HttpURLConnFactory}
 *
 * @author liwenhe
 */
public class HttpURLConnFactoryManager {

    private Map<String, HttpURLConnFactory> httpURLConnFactoryMap = new ConcurrentHashMap<String, HttpURLConnFactory>();

    public HttpURLConnFactoryManager() {
    }

    /**
     * 初始化时构造 {@code HttpURLConnFactory}
     *
     * @param httpURLConnFactoryMap
     */
    public HttpURLConnFactoryManager(Map<String, HttpURLConnFactory> httpURLConnFactoryMap) {
        this.httpURLConnFactoryMap = httpURLConnFactoryMap;
    }

    /**
     * 当类实例化后，也可以通过此方法载入 {@code HttpURLConnFactory}
     *
     * @param alias
     * @param httpURLConnFactory
     */
    public void add(String alias, HttpURLConnFactory httpURLConnFactory) {
        httpURLConnFactoryMap.put(alias, httpURLConnFactory);
    }

    /**
     * 当类实例化后，也可以通过此方法移除 {@code HttpURLConnFactory}
     *
     * @param alias
     */
    public void delete(String alias) {
        httpURLConnFactoryMap.remove(alias);
    }

    /**
     * 当类实例化后，也可以通过此方法得到 {@code HttpURLConnFactory}
     *
     * @param alias
     */
    public HttpURLConnFactory get(String alias) {
        return httpURLConnFactoryMap.get(alias);
    }

}
