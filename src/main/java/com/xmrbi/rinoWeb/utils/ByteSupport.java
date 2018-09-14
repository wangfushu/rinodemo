package com.xmrbi.rinoWeb.utils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

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
 * @Date: 2018-09-14 10:19
 */

public class ByteSupport {
    private ByteSupport() {
        throw new IllegalStateException("Utility class cannot be Instance");
    }

    public static byte[] hexStringToByteArray(String hexStr) {
        if (hexStr != null && hexStr.length() % 2 == 0) {
            byte[] bytes = new byte[hexStr.length() / 2];

            for(int i = 0; i < hexStr.length(); i += 2) {
                byte value = (byte)Integer.parseInt(hexStr.substring(i, i + 2), 16);
                bytes[(int)Math.floor((double)i / 2.0D)] = value;
            }

            return bytes;
        } else {
            return new byte[0];
        }
    }

    public static String byteArrayToHexString(byte[] bytes) {
        if (bytes != null && bytes.length != 0) {
            StringBuilder sb = new StringBuilder(bytes.length * 2);

            for(int x = 0; x < bytes.length; ++x) {
                String hexNumber = "0" + Integer.toHexString(255 & bytes[x]);
                sb.append(hexNumber.substring(hexNumber.length() - 2));
            }

            return sb.toString();
        } else {
            return null;
        }
    }

    public static byte[] intToByteArray(int val, ByteOrder bo) {
        ByteBuffer buff = ByteBuffer.allocate(4);
        buff.order(bo);
        buff.putInt(val);
        return buff.array();
    }

    public static byte[] intToByteArray(int val) {
        return intToByteArray(val, ByteOrder.BIG_ENDIAN);
    }

    public static int byteArrayToInt(byte[] bytes, ByteOrder bo) throws ByteSupportException {
        if (bytes.length != 4) {
            throw new ByteSupportException("Invalid byte array size");
        } else {
            ByteBuffer buff = ByteBuffer.allocate(4);
            buff.order(bo);
            buff.put(bytes);
            buff.flip();
            return buff.getInt();
        }
    }

    public static int byteArrayToInt(byte[] bytes) throws ByteSupportException {
        return byteArrayToInt(bytes, ByteOrder.BIG_ENDIAN);
    }
}
