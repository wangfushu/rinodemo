package com.xmrbi.rinoWeb.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Properties;

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
 * @Date: 2018-09-10 17:44
 */
public class MessageConfigConstant {
    private static Logger logger = LoggerFactory.getLogger(MessageConfigConstant.class);
    private static Properties props;
    static{
        loadProps();
    }
    //自定义表主键的数据库驱动
    public static String IDUTIL_DRIVER;
    //自定义表主键的数据库地址
    public static String IDUTIL_URL;
    //自定义表主键的数据库用户名
    public static String IDUTIL_USERNAME;
    //自定义表主键的数据库用户密码
    public static String IDUTIL_PASSWORD;

    public static String socket_server_port;
    public static String websocket_server_port;

    public static String langCode;
    public static String countryCode;


    synchronized static private void loadProps(){
        logger.info("加载配置文件内容");
        props = new Properties();
        InputStream in = null;
        try {
            in = MessageConfigConstant.class.getClassLoader().getResourceAsStream("constant.properties");
            props.load(in);
            IDUTIL_DRIVER=props.getProperty("IDUTIL_DRIVER");
            IDUTIL_URL=props.getProperty("IDUTIL_URL");
            IDUTIL_USERNAME=props.getProperty("IDUTIL_USERNAME");
            IDUTIL_PASSWORD=props.getProperty("IDUTIL_PASSWORD");
            socket_server_port= props.getProperty("socket.server.port");
            websocket_server_port= props.getProperty("websocket.server.port");

            langCode= props.getProperty("langCode");
            countryCode= props.getProperty("countryCode");

        } catch (Exception e) {
            logger.error("加载失败constant.properties "+e.getMessage());
        } finally {
            try {
                if(null != in) {
                    in.close();
                }
            } catch (Exception e) {
                logger.error("xai-constant.properties文件流关闭出现异常"+e.getMessage());
            }
        }
    }
}
