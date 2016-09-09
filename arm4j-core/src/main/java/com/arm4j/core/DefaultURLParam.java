package com.arm4j.core;

import java.util.*;

/**
 * 默认的url参数类
 * @see Param
 *
 * @author liwenhe
 */
public class DefaultURLParam implements Param {

    private List<Map.Entry<String, String>> values = new ArrayList<>(Builder.params.entrySet());

    /**
     * 对参数进行升序处理
     *
     * @return Param
     */
    public Param asc() {
        Collections.sort(values, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        return this;
    }

    /**
     * 对参数进行降序处理
     *
     * @return Param
     */
    public Param desc() {
        Collections.sort(values, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                if (o1.getKey().compareTo(o2.getKey()) > 0)
                    return -1;
                if (o1.getKey().compareTo(o2.getKey()) < 0)
                    return 1;
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        return this;
    }

    public String getParam() {
        return this.format(values);
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
