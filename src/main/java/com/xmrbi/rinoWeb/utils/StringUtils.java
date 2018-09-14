package com.xmrbi.rinoWeb.utils;

import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
 * @Date: 2018-09-14 10:15
 */

public class StringUtils {
    private static final Logger logger = LoggerFactory.getLogger(StringUtil.class);
    public static final int PAD_LEFT = 0;
    public static final String PAD_LEFT_STR = "L";
    public static final int PAD_RIGHT = 1;
    public static final String PAD_RIGHT_STR = "R";
    public static final int BOOLEAN_EXP_YN = 1;
    public static final int BOOLEAN_EXP_YES_NO = 2;
    public static final int BOOLEAN_EXP_TF = 4;
    public static final int BOOLEAN_EXP_TRUE_FALSE = 8;
    public static final int BOOLEAN_EXP_CASE_LOWER = 16;
    public static final int BOOLEAN_EXP_CASE_UPPER = 32;
    public static final int BOOLEAN_EXP_CASE_CAMEL = 64;
    private static final String[] BOOLEAN_STR_YN = new String[]{"Y", "N"};
    private static final String[] BOOLEAN_STR_YES_NO = new String[]{"Yes", "No"};
    private static final String[] BOOLEAN_STR_TF = new String[]{"T", "F"};
    private static final String[] BOOLEAN_STR_TRUE_FALSE = new String[]{"True", "False"};
    private static final String PATTERN_ALPHABET_ONLY = "^[A-Za-z]*$";
    private static final String PATTERN_NUMBER_ONLY = "[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?";
    private static final String PATTERN_DIGIT_ONLY = "\\d+";
    private static final String PATTERN_HEX_CODE = "^#?([A-Fa-f0-9][A-Fa-f0-9])+$";
    private static final String[] FILE_SIZE_UNITS = new String[]{"B", "KB", "MB", "GB", "TB"};

    private StringUtils() {
        throw new IllegalStateException("Utility class cannot be Instance");
    }

    public static boolean toBoolean(String val) {
        if (val != null) {
            if ("y".equalsIgnoreCase(val) || "yes".equalsIgnoreCase(val)) {
                return true;
            }

            if ("t".equalsIgnoreCase(val) || "true".equalsIgnoreCase(val)) {
                return true;
            }
        }

        return false;
    }

    public static String booleanToString(boolean arg0, int exp) {
        int expType = exp & 15;
        int expCase = exp & 112;
        int indx = arg0 ? 0 : 1;
        String result;
        switch(expType) {
            case 1:
                result = BOOLEAN_STR_YN[indx];
                break;
            case 2:
                result = BOOLEAN_STR_YES_NO[indx];
                break;
            case 3:
            default:
                result = BOOLEAN_STR_TRUE_FALSE[indx];
                break;
            case 4:
                result = BOOLEAN_STR_TF[indx];
        }

        if (expCase == 16) {
            result = result.toLowerCase();
        } else if (expCase == 32) {
            result = result.toUpperCase();
        }

        return result;
    }

    public static String booleanToString(boolean arg0, String trueStr, String falseStr) {
        return arg0 ? trueStr : falseStr;
    }

    public static String setPad(String str, int len, char padChar, int padFlag) throws StringUtilException {
        String result = "";
        if (padFlag == 0) {
            result = Strings.padStart(str, len, padChar);
        } else {
            if (padFlag != 1) {
                throw new StringUtilException("Invalid Padding Option");
            }

            result = Strings.padEnd(str, len, padChar);
        }

        return result;
    }

    /** @deprecated */
    @Deprecated
    public static String setPad(String str, int len, char padChar, String padFlag) throws StringUtilException {
        String result = "";
        if ("L".equalsIgnoreCase(padFlag)) {
            result = Strings.padStart(str, len, padChar);
        } else {
            if (!"R".equalsIgnoreCase(padFlag)) {
                throw new StringUtilException("Invalid Padding Option");
            }

            result = Strings.padEnd(str, len, padChar);
        }

        return result;
    }

    public static String removePad(String str, char padChar, int padFlag) throws NullPointerException, StringUtilException {
        StringBuilder sb = new StringBuilder();
        boolean padEnd = false;
        if (str == null) {
            throw new NullPointerException("String for to remove pad is null");
        } else {
            int len;
            if (padFlag == 0) {
                for(len = 0; len < str.length(); ++len) {
                    char curChar = str.charAt(len);
                    if (curChar != padChar || padEnd) {
                        padEnd = true;
                        sb.append(curChar);
                    }
                }
            } else {
                if (padFlag != 1) {
                    throw new StringUtilException("Invalid Padding Option");
                }

                len = str.length();
                if (len > 0) {
                    for(int i = len - 1; i >= 0; --i) {
                        char curChar = str.charAt(i);
                        if (curChar != padChar || padEnd) {
                            padEnd = true;
                            sb.append(curChar);
                        }
                    }

                    sb = sb.reverse();
                }
            }

            return sb.toString();
        }
    }



    public static String escape(String src) {
        StringBuilder tmp = new StringBuilder();
        tmp.ensureCapacity(src.length() * 6);

        for(int i = 0; i < src.length(); ++i) {
            char j = src.charAt(i);
            if (!Character.isDigit(j) && !Character.isLowerCase(j) && !Character.isUpperCase(j)) {
                if (j < 256) {
                    tmp.append("%");
                    if (j < 16) {
                        tmp.append("0");
                    }

                    tmp.append(Integer.toString(j, 16));
                } else {
                    tmp.append("%u");
                    tmp.append(Integer.toString(j, 16));
                }
            } else {
                tmp.append(j);
            }
        }

        return tmp.toString();
    }

    public static String unescape(String str) {
        String rtnStr = new String();
        char[] arrInp = str.toCharArray();

        for(int i = 0; i < arrInp.length; ++i) {
            if (arrInp[i] == '%') {
                String hex;
                if (arrInp[i + 1] == 'u') {
                    hex = str.substring(i + 2, i + 6);
                    i += 5;
                } else {
                    hex = str.substring(i + 1, i + 3);
                    i += 2;
                }

                try {
                    rtnStr = rtnStr + new String(Character.toChars(Integer.parseInt(hex, 16)));
                } catch (NumberFormatException var6) {
                    rtnStr = rtnStr + "%";
                    i -= hex.length() > 2 ? 5 : 2;
                }
            } else {
                rtnStr = rtnStr + arrInp[i];
            }
        }

        return rtnStr;
    }

    public static boolean isAlphabetOnly(String str) {
        return isMatchWithPattern(str, "^[A-Za-z]*$");
    }

    public static boolean isNumber(String str) {
        return isMatchWithPattern(str, "[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?");
    }

    public static boolean isHexCode(String str) {
        return isMatchWithPattern(str, "^#?([A-Fa-f0-9][A-Fa-f0-9])+$");
    }

    public static boolean isDigit(String str) {
        return isMatchWithPattern(str, "\\d+");
    }

    static boolean isMatchWithPattern(String str, String regexp) {
        if (str == null) {
            throw new NullPointerException();
        } else {
            return str.matches(regexp);
        }
    }

    public static String uniCodeNullToEmpty(String str) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);
            if (ch == 0) {
                sb.append("");
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public static String headToUpper(String str) throws StringUtilException {
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            throw new StringUtilException("Illegal parameter : param is null");
        } else {
            int len = str.length();
            if (len == 0) {
                return str;
            } else if (len == 1) {
                return str.toUpperCase();
            } else {
                sb.append(str.substring(0, 1).toUpperCase());
                sb.append(str.substring(1).toLowerCase());
                return sb.toString();
            }
        }
    }

    public static String strToMD5(String str) {
        MessageDigest mdEnc = null;
        byte[] bip = null;

        try {
            mdEnc = MessageDigest.getInstance("MD5");
            bip = mdEnc.digest(str.getBytes());
        } catch (Exception var4) {
            logger.error(var4.getMessage(), var4);
        }

        return ByteSupport.byteArrayToHexString(bip);
    }

    public static String strToSha256(String str) {
        String result = null;

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] byteData = md.digest(str.getBytes());
            result = ByteSupport.byteArrayToHexString(byteData);
        } catch (NoSuchAlgorithmException var4) {
            logger.error(var4.getMessage(), var4);
        }

        return result;
    }

    public static String toFileSizeString(Long size) throws StringUtilException {
        StringBuilder sb = new StringBuilder();
        int unitIndx = 0;
        if (size != null && size >= 0L) {
            double newSize;
            for(newSize = (double)size / 1024.0D; newSize > 1024.0D; ++unitIndx) {
                newSize /= 1024.0D;
            }

            if (unitIndx == 0) {
                sb.append(String.format("%d", size));
            } else {
                sb.append(String.format("%.2f", newSize));
            }

            sb.append(" ");
            sb.append(FILE_SIZE_UNITS[unitIndx]);
            return sb.toString();
        } else {
            throw new StringUtilException("Invalid parameter");
        }
    }
}