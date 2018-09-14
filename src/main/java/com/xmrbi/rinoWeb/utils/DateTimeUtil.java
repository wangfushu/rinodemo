package com.xmrbi.rinoWeb.utils;

import com.google.common.base.Strings;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Locale;

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
 * @Date: 2018-09-14 16:02
 */
public class DateTimeUtil {
    public static final int TYPE_DATE = 8;
    public static final int TYPE_DATE_TIME = 14;
    public static final int TYPE_DATE_TIME_MILISECOND = 17;
    public static final int TYPE_DATE_TIME_MICROSECOND = 20;
    public static final int TYPE_DATE_TIME_NANOSECOND = 23;
    public static final int TIME_STRING = 1;
    public static final int DATE_STRING = 2;
    public static final int DATE_TIME_STRING = 4;

    public DateTimeUtil() {
    }

    public static Calendar toCalendar(String dateTimeStr) throws DateTimeUtilException {
        Calendar cal = Calendar.getInstance();
        int len = dateTimeStr.length();
        if (Strings.isNullOrEmpty(dateTimeStr)) {
            throw new DateTimeUtilException("Date Time String is Null or Empty");
        } else if (len != 14 && len != 17) {
            throw new DateTimeUtilException("Invalid length of date time string");
        } else if (!StringUtils.isDigit(dateTimeStr)) {
            throw new DateTimeUtilException("Invalid date time string");
        } else {
            try {
                cal.clear();
                cal.set(Integer.parseInt(dateTimeStr.substring(0, 4)), Integer.parseInt(dateTimeStr.substring(4, 6)) - 1, Integer.parseInt(dateTimeStr.substring(6, 8)), Integer.parseInt(dateTimeStr.substring(8, 10)), Integer.parseInt(dateTimeStr.substring(10, 12)), Integer.parseInt(dateTimeStr.substring(12, 14)));
                if (len == 17) {
                    cal.set(14, Integer.parseInt(dateTimeStr.substring(14, 17)));
                }

                return cal;
            } catch (Exception var4) {
                throw new DateTimeUtilException(var4);
            }
        }
    }

    public static String toPlaneDateTimeString(Calendar cal, int lenType, boolean bPadding) {
        StringBuffer sb = new StringBuffer();
        if (lenType == 8 || lenType == 14 || lenType == 17 || lenType == 20 || lenType == 23) {
            sb.append(Integer.toString(cal.get(1)));
            sb.append(bPadding ? Strings.padStart(String.valueOf(cal.get(2) + 1), 2, '0') : String.valueOf(cal.get(2)));
            sb.append(bPadding ? Strings.padStart(String.valueOf(cal.get(5)), 2, '0') : String.valueOf(cal.get(5)));
            if (lenType == 14 || lenType == 17 || lenType == 20 || lenType == 23) {
                sb.append(bPadding ? Strings.padStart(String.valueOf(cal.get(11)), 2, '0') : String.valueOf(cal.get(11)));
                sb.append(bPadding ? Strings.padStart(String.valueOf(cal.get(12)), 2, '0') : String.valueOf(cal.get(12)));
                sb.append(bPadding ? Strings.padStart(String.valueOf(cal.get(13)), 2, '0') : String.valueOf(cal.get(13)));
                if (lenType == 17 || lenType == 20 || lenType == 23) {
                    sb.append(bPadding ? Strings.padStart(String.valueOf(cal.get(14)), 3, '0') : String.valueOf(cal.get(14)));
                    if (lenType == 20 || lenType == 23) {
                        LocalDateTime dateTime = LocalDateTime.ofInstant(cal.toInstant(), ZoneId.systemDefault());
                        ZonedDateTime zoneDateTime = dateTime.atZone(ZoneId.systemDefault());
                        sb.append(bPadding ? Strings.padStart(String.valueOf(zoneDateTime.getNano()).substring(3, 6), 3, '0') : String.valueOf(zoneDateTime.getNano()));
                    }
                }
            }
        }

        return sb.toString();
    }

    public static String toPlaneDateTimeString(ZonedDateTime zoneDateTime, int lenType, boolean bPadding) {
        StringBuffer sb = new StringBuffer();
        if (lenType == 8 || lenType == 14 || lenType == 17 || lenType == 20 || lenType == 23) {
            sb.append(bPadding ? Strings.padStart(String.valueOf(zoneDateTime.getYear()), 4, '0') : String.valueOf(zoneDateTime.getYear()));
            sb.append(bPadding ? Strings.padStart(String.valueOf(zoneDateTime.getMonth().getValue()), 2, '0') : String.valueOf(zoneDateTime.getMonth()));
            sb.append(bPadding ? Strings.padStart(String.valueOf(zoneDateTime.getDayOfMonth()), 2, '0') : String.valueOf(zoneDateTime.getDayOfMonth()));
            if (lenType == 14 || lenType == 17 || lenType == 20 || lenType == 23) {
                sb.append(bPadding ? Strings.padStart(String.valueOf(zoneDateTime.getHour()), 2, '0') : String.valueOf(zoneDateTime.getHour()));
                sb.append(bPadding ? Strings.padStart(String.valueOf(zoneDateTime.getMinute()), 2, '0') : String.valueOf(zoneDateTime.getMinute()));
                sb.append(bPadding ? Strings.padStart(String.valueOf(zoneDateTime.getSecond()), 2, '0') : String.valueOf(zoneDateTime.getSecond()));
                if (lenType == 17 || lenType == 20 || lenType == 23) {
                    sb.append(bPadding ? Strings.padStart(String.valueOf(zoneDateTime.get(ChronoField.MILLI_OF_SECOND)), 3, '0') : String.valueOf(zoneDateTime.get(ChronoField.MILLI_OF_SECOND)));
                    if (lenType == 20 || lenType == 23) {
                        sb.append(bPadding ? Strings.padStart(String.valueOf(zoneDateTime.getNano()).substring(3, 6), 3, '0') : String.valueOf(zoneDateTime.getNano()));
                    }
                }
            }
        }

        return sb.toString();
    }

    public static String toFormatedTimeString(String dateTimeStr, String exp) throws DateTimeUtilException {
        Calendar cal = toCalendar(dateTimeStr);
        return toFormatedTimeString(cal, exp);
    }

    public static String toFormatedTimeString(Calendar cal, String exp) throws DateTimeUtilException {
        if (cal == null) {
            throw new DateTimeUtilException("Null pointer exception");
        } else {
            SimpleDateFormat dateformat = new SimpleDateFormat(exp);
            return dateformat.format(cal.getTime());
        }
    }

    public static String getDateTimeStringByLocale(String dateTimeStr, String langCd, String countryCd) throws DateTimeUtilException {
        String rtnStr = "";
        Locale locale = new Locale(langCd, countryCd);
        DateFormat dateFormat = DateFormat.getDateTimeInstance(2, 2, locale);
        Calendar cal = toCalendar(dateTimeStr);
        rtnStr = dateFormat.format(cal.getTime());
        return rtnStr;
    }

    public static String getDateTimeStringByLocaleWithLong(String dateTimeStr, String langCd, String countryCd) throws DateTimeUtilException {
        Locale locale = new Locale(langCd, countryCd);
        DateFormat dateFormat = DateFormat.getDateTimeInstance(1, 1, locale);
        Calendar cal = toCalendar(dateTimeStr);
        return dateFormat.format(cal.getTime());
    }

    public static String getDateStringByLocale(String dateTimeStr, String langCd, String countryCd) throws DateTimeUtilException {
        Locale locale = new Locale(langCd, countryCd);
        DateFormat dateFormat = DateFormat.getDateInstance(2, locale);
        Calendar cal = toCalendar(dateTimeStr);
        return dateFormat.format(cal.getTime());
    }

    public static String getTimeStringByLocale(String dateTimeStr, String langCd, String countryCd) throws DateTimeUtilException {
        Locale locale = new Locale(langCd, countryCd);
        DateFormat dateFormat = DateFormat.getTimeInstance(2, locale);
        Calendar cal = toCalendar(dateTimeStr);
        return dateFormat.format(cal.getTime());
    }
}

