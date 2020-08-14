package com.csii.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DurationFormatUtils;

public class TimeUtil {
    public static final int MILLISECOND = 14;
    public static final int SECOND = 13;
    public static final int MINUTE = 12;
    public static final int HOUR = 10;
    public static final int DAY = 5;
    public static final int MONTH = 2;
    public static final int YEAR = 1;
    public static final String DEFAULT_TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String DEFAULT_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    public static final String[] WEEK_DAY = new String[] { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
    public static final String[] TIME_PATTERNS = new String[]{ 
    		"yy/MM/dd HH:mm:ss.SSS", 
    		"yyyy-MM-dd HH:mm:ss.SSS",
            "yyyy/MM/dd HH:mm:ss.SSS", 
            "yyyyMMdd HH:mm:ss.SSS", 
            "yy/MM/dd HH:mm:ss", 
            "yyyy-MM-dd HH:mm:ss", 
            "yyyy/MM/dd HH:mm:ss",
            "yyyyMMdd HH:mm:ss", 
            "yyyyMMddhhmmss", 
            "yy/MM/dd", 
            "yyyy-MM-dd", 
            "yyyy/MM/dd", 
            "yyyyMMdd" 
            };
    
    @SuppressWarnings("static-access")
	public static int getWeekDay(Date date) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar.get(calendar.DAY_OF_WEEK);
    }

    public static String getWeekDayCN(Date date) {
        int weekDay = getWeekDay(date);
        if (weekDay > WEEK_DAY.length || weekDay <= 0) {
            throw new RuntimeException("[UTIL]日期解析失败[" + date + "]");
        }
        return WEEK_DAY[weekDay - 1];
    }

    public static String nowTime(String format) {

        return convTime(new Date(), format);
    }

    public static String nowTime() {
        return nowTime("yyyy-MM-dd HH:mm:ss");
    }

    public static String nowDate() {
        return nowTime("yyyy-MM-dd");
    }

    public static String convTime(Date time) {
        return convTime(time, "yyyy-MM-dd HH:mm:ss");
    }

    public static String convTime(Date time, String format) {
        if (time == null) {
            return null;
        }

        return DateFormatUtils.format(time, format);
    }

    public static String convTime(String time) {
        return convTime(time, "yyyy-MM-dd HH:mm:ss");
    }

    public static String convTime(String time, String format) {
        if (null == time || time.trim().equals("")) {
            return null;
        }

        Date d = parseTime(time);
        return convTime(d, format);
    }

    public static String convTime(long time) {
        return convTime(time, "yyyy-MM-dd HH:mm:ss");
    }

    public static String convTime(long time, String format) {
        return DateFormatUtils.format(time, format);
    }

    public static Date parseTime(String time) {
        return parseTime(time, null, null, null);
    }

    public static Date parseTime(String time, String format) {
        return parseTime(time, format, null, null);
    }

    public static Date parseTime(String time, TimeZone timeZone) {
        return parseTime(time, null, timeZone);
    }

    public static Date parseTime(String time, String format, TimeZone timeZone) {
        return parseTime(time, format, timeZone, null);
    }

    public static Date parseTime(String time, String format, Locale locale) {
        return parseTime(time, format, null, locale);
    }

    public static Date parseTime(String time, String format, TimeZone timeZone, Locale locale) {
        if (null == time || time.trim().equals("")) {
            return null;
        }

        String[] astrPatterns = (String[]) null;

        if (format != null && !format.trim().equals(""))
            astrPatterns = new String[] { format };
        else {
            astrPatterns = TIME_PATTERNS;
            
        }

        Date dateResult = null;

        if (locale == null) {
            locale = Locale.getDefault();
        }

        for (int i = 0; i < astrPatterns.length; i++) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(astrPatterns[i], locale);

                if (timeZone != null) {
                    sdf.setTimeZone(timeZone);
                }

                dateResult = sdf.parse(time);
            } catch (Exception localException) {
            }
            if (dateResult != null) {
                break;
            }
        }
        if (dateResult == null) {
            throw new RuntimeException("[UTIL]日期字符串解析失败[" + time + "]");
        }

        return dateResult;
    }

    public static long decTime(Date d1, Date d2) {
        if (d1 == null) {
            return 0L;
        }

        if (d2 == null) {
            return 0L;
        }

        long lDiff = d1.getTime() - d2.getTime();

        return lDiff;
    }

    public static long decTime(String time1, String time2) {
        Date d1 = parseTime(time1);
        Date d2 = parseTime(time2);
        return decTime(d1, d2);
    }

    public static Date rollTime(Date time, int field, int delta) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(time);
        calendar.add(field, delta);
        return calendar.getTime();
    }

    public static String durationFormat(long time) {
        return durationFormat(time, "d天H小时m分s秒");
    }

    public static String durationFormat(long time, String format) {
        return DurationFormatUtils.formatDuration(time, format);
    }
}