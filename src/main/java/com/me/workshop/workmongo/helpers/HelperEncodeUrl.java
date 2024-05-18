package com.me.workshop.workmongo.helpers;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class HelperEncodeUrl {
    public static String decodeParam(String text) {
        return URLDecoder.decode(text, StandardCharsets.UTF_8);
    }

    public static Date convertDate(String textDate, Date defaultValue) {
        var sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        return getDate(textDate, sdf);
    }

    private static Date getDate(String textDate, SimpleDateFormat sdf) {
        try {
            return sdf.parse(textDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
