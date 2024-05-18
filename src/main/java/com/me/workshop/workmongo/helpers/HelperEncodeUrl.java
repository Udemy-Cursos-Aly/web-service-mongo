package com.me.workshop.workmongo.helpers;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class HelperEncodeUrl {
    public static String decodeParam(String text) {
        return URLDecoder.decode(text, StandardCharsets.UTF_8);
    }
}
