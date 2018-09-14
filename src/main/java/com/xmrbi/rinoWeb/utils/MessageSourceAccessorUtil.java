package com.xmrbi.rinoWeb.utils;

import org.springframework.context.support.MessageSourceAccessor;

/**
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 *
 *
 * @description :
 * ---------------------------------
 * @Author: wangfushu
 * @Date: 2018-09-14 10:41
 */

public class MessageSourceAccessorUtil {
    private static MessageSourceAccessorUtil instance = new MessageSourceAccessorUtil();
    private MessageSourceAccessor messageSourceAccessor;

    public MessageSourceAccessorUtil() {
    }

    public static MessageSourceAccessorUtil getInstance() {
        return instance;
    }

    public static void setMessageSourceAccessor(MessageSourceAccessor messageSourceAccessor) {
        getInstance().messageSourceAccessor = messageSourceAccessor;
    }

    public static String getMessage(String code) {
        String result = getInstance().messageSourceAccessor.getMessage(code);
        if (result == null) {
            result = code;
        }

        return result;
    }
}

