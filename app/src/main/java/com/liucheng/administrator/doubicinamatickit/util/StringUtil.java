package com.liucheng.administrator.doubicinamatickit.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 邹柳钦 on 2017/12/4 0004.
 */

public class StringUtil {

    //一段话截取其中的数字或者.
    public static String BoxOfficeString(String s) {
        String regEx = "^(\\+)?\\d+(\\.\\d+)?$ ";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(s);
        return m.replaceAll("").trim();
    }
}
