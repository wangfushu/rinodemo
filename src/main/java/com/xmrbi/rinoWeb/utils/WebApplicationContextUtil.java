package com.xmrbi.rinoWeb.utils;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.FrameworkServlet;

import javax.servlet.ServletContext;

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

public class WebApplicationContextUtil extends WebApplicationContextUtils {
    private static WebApplicationContext wac;
    private static WebApplicationContext requiredWac;
    private static ServletContext servletContext;

    public WebApplicationContextUtil() {
    }

    public static void setServletContext(ServletContext servletContext) {
        servletContext = servletContext;
    }

    public static ServletContext getServletContext() {
        return servletContext;
    }

    public static WebApplicationContext getRequiredWebApplicationContext() {
        requiredWac = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        return requiredWac;
    }

    public static WebApplicationContext setWebApplicationContext(WebApplicationContext wac) {
        wac = wac;
        return wac;
    }

    public static WebApplicationContext setWebApplicationContextByDispatcherName(ServletContext servletContext, String dispathcerServletName) {
        wac = WebApplicationContextUtils.getWebApplicationContext(servletContext, FrameworkServlet.SERVLET_CONTEXT_PREFIX + dispathcerServletName);
        requiredWac = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        return wac;
    }

    public static WebApplicationContext getWebApplicationContext() {
        return wac;
    }

    public static Object getBeanFromRoot(String beanName) {
        return getRequiredWebApplicationContext().getBean(beanName);
    }
}

