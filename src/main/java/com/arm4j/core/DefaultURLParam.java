package com.arm4j.core;

import java.util.*;

/**
 * 默认的url参数类
 * @see Param
 *
 * @author liwenhe
 */
public class DefaultURLParam implements Param {

    public String getParam() {
        return this.format(new ArrayList(Builder.params.entrySet()));
    }

    private String format(List param) {
        StringBuilder paramsToString = new StringBuilder();
        Iterator<Map.Entry<String, String>> iterator = param.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> tmp = iterator.next();
            if (null != tmp.getValue()) {
                paramsToString.append(tmp.getKey()).append("=").append(tmp.getValue());
            } else {
                paramsToString.append(tmp.getKey());
            }

            if (iterator.hasNext()) {
                paramsToString.append("&");
            }
        }
        return paramsToString.toString();
    }

    public final static class Builder {

        private final static Map<String, String> params = new HashMap<String, String>();

        public Builder add(String value) {
            DefaultURLParam.Builder.params.put(value, null);
            return this;
        }

        public Builder add(String key, String value) {
            DefaultURLParam.Builder.params.put(key, value);
            return this;
        }

        public DefaultURLParam build() {
            return new DefaultURLParam();
        }
    }

}
