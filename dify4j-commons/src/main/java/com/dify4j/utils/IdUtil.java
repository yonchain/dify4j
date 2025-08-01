package com.dify4j.utils;

import java.util.UUID;

public class IdUtil {

    public static String generateId() {
        return UUID.randomUUID().toString();
    }
}
