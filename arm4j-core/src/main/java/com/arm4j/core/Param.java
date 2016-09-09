package com.arm4j.core;

/**
 * 参数接口类，统一调用方法
 * @see DefaultURLParam 自定义url参数时需要继承此类
 * @see DefaultEntityParam 自定义entity参数时需要继承此类
 *
 * @author liwenhe
 */
public interface Param {

    /**
     * 统一方法
     *
     * @return String
     */
    String getParam();

}
