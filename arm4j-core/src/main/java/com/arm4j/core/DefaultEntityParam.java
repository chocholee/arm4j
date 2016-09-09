package com.arm4j.core;

/**
 * 默认的entity参数类
 * @see Param
 *
 * @author liwenhe
 */
public class DefaultEntityParam implements Param {

    private String entity;

    public DefaultEntityParam() {
    }

    public DefaultEntityParam(String entity) {
        this.entity = entity;
    }

    public String getParam() {
        return this.entity;
    }

}
