package com.arm4j.weixin.request.material.entity;

import java.util.HashMap;
import java.util.Map;

public enum MediaType {
    IMAGE("image"), VOICE("voice"), VIDEO("video"), THUMB("thumb"), NEWS("news");

    private static Map<String, MediaType> caches = new HashMap<>();

    static {
        MediaType[] values = MediaType.values();
        for (MediaType type : values) {
            caches.put(type.getName(), type);
        }
    }

    private final String name;

    public String getName() {
        return name;
    }

    MediaType(String name) {
        this.name = name;
    }

    public static MediaType valueOfBy(String name) {
        return caches.get(name);
    }
}
