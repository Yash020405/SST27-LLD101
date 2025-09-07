package com.example.render;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TextStyleFactory {
    private final Map<String, TextStyle> cache = new ConcurrentHashMap<>();

    public TextStyle getTextStyle(String font, int size, boolean bold) {
        String key = font + "|" + size + "|" + bold;
        return cache.computeIfAbsent(key, k -> new TextStyle(font, size, bold));
    }
}
