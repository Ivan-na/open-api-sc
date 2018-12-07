package com.fenbeitong.open.api.support.commons.util;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * DateHelper
 *
 * <p>日期帮助工具类
 *
 * @author ivan
 * @version 1.0 Created by ivan on 18-11-21 - 下午7:32.
 */
public class DateHelper extends DateUtils {
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_SDF = "yyyy-MM-dd";
    public static final String TIME_SDF = "yyyy-MM-dd HH:mm";
    public static final String YYYY = "yyyy";
    public static final String MM = "MM";
    public static final String DD = "dd";
    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String SHORT_TIME_SDF = "HH:mm";
    public static final String DATE_TIME_SLASH = "yyyy/MM/dd HH:mm:ss";
    public static final String DATE_TIME_SLASH_S = "yyyy/MM/dd";
    public static final String DATE_TIME_DOT = "yyyy.MM.dd HH:mm:ss";
    public static final String DATE_TIME_DOT_S = "yyyy.MM.dd";
    public static final String DATE_SDF_WZ = "yyyy年MM月dd日";

    private static String[] parsePatterns = {
            DATETIME_FORMAT,
            DATE_SDF,
            TIME_SDF,
            YYYY,
            MM,
            DD,
            YYYYMMDD,
            YYYYMMDDHHMMSS,
            SHORT_TIME_SDF,
            DATE_TIME_SLASH,
            DATE_TIME_SLASH_S,
            DATE_TIME_DOT,
            DATE_TIME_DOT_S,
            DATE_SDF_WZ
    };

    /**
     * @return java.lang.String
     * @author Created by ivan on 下午5:42 18-11-29. 得到当前日期字符串 格式（yyyy-MM-dd）.
     */
    public static String getDate() {
        return getDate(DATE_SDF);
    }

    /**
     * @param pattern :
     * @return java.lang.String
     * @author Created by ivan on 下午5:42 18-11-29. 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为：DEFAULT_SHORT
     * "HH:mm:ss" "E".
     */
    public static String getDate(String pattern) {
        return DateFormatUtils.format(new Date(), pattern);
    }

    /**
     * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为：DEFAULT_SHORT "HH:mm:ss" "E".
     *
     * @param date    需要转换的日期
     * @param pattern 指定的输出格式
     * @return String 指定格式的字符串，默认yyyy-MM-dd
     */
    public static String formatDate(Date date, Object... pattern) {
        String formatDate = null;
        if (null == date) {
            return formatDate;
        }
        if (pattern != null && pattern.length > 0) {
            formatDate = DateFormatUtils.format(date, pattern[0].toString());
        } else {
            formatDate = DateFormatUtils.format(date, DATE_SDF);
        }
        return formatDate;
    }

    /**
     * 得到日期+时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）. \
     *
     * @param date 需要转换的日期+时间
     * @return String yyyy-MM-dd HH:mm:ss
     */
    public static String formatDateTime(Date date) {
        return formatDate(date, DATETIME_FORMAT);
    }

    /**
     * 得到当前时间字符串 格式（HH:mm:ss）. \
     *
     * @return String HH:mm:ss
     */
    public static String getTime() {
        return formatDate(new Date(), "HH:mm:ss");
    }

    /**
     * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）.
     *
     * @return String yyyy-MM-dd HH:mm:ss
     */
    public static String getDateTime() {
        return formatDate(new Date(), DATETIME_FORMAT);
    }

    /**
     * 得到当前年份字符串 格式（yyyy）.
     *
     * @return String yyyy
     */
    public static String getYear() {
        return formatDate(new Date(), "yyyy");
    }

    /**
     * 得到当前月份字符串 格式（MM）.
     *
     * @return String MM
     */
    public static String getMonth() {
        return formatDate(new Date(), "MM");
    }

    /**
     * 得到当天字符串 格式（dd）.
     *
     * @return String dd
     */
    public static String getDay() {
        return formatDate(new Date(), "dd");
    }

    /**
     * 得到当前星期字符串 格式（E）星期几.
     *
     * @return String E
     */
    public static String getWeek() {
        return formatDate(new Date(), "E");
    }

    /**
     * 日期型字符串转化为日期,
     *
     * @param str 需要转换的字符串
     * @return Date 日期对象
     */
    public static Date parseDate(Object str) {
        if (str == null) {
            return null;
        }
        try {
            // 严格的日期转换，如2015-06-31转换抛异常
            return parseDateStrictly(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 日期型字符串转化为日期.
     *
     * @param str 需要转换的字符串
     * @return Date 日期对象
     */
    public static Date parseDateLoose(Object str) {
        if (str == null) {
            return null;
        }
        try {
            // 宽松的日转换，2015-06-31转换正常，转换后的日期格式为2015-07-01
            return parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取过去的天数.
     *
     * @param date 开始时间
     * @return long 天数
     */
    public static long pastDays(Date date) {
        long t = System.currentTimeMillis() - date.getTime();
        return t / (24 * 60 * 60 * 1000);
    }

    /**
     * 获取过去的小时.
     *
     * @param date 开始时间
     * @return long 小时数
     */
    public static long pastHour(Date date) {
        long t = System.currentTimeMillis() - date.getTime();
        return t / (60 * 60 * 1000);
    }

    /**
     * 获取过去的分钟.
     *
     * @param date 开始时间
     * @return long 分钟
     */
    public static long pastMinutes(Date date) {
        long t = System.currentTimeMillis() - date.getTime();
        return t / (60 * 1000);
    }

    /**
     * 转换为时间（天,时:分:秒.毫秒）.
     *
     * @param timeMillis 需要转换的毫秒值
     * @return String day，hour，min，s，ss
     */
    public static String formatDateTime(long timeMillis) {
        long day = timeMillis / (24 * 60 * 60 * 1000);
        long hour = timeMillis / (60 * 60 * 1000) - day * 24;
        long min = (timeMillis / (60 * 1000)) - day * 24 * 60 - hour * 60;
        long s = timeMillis / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60;
        long sss =
                timeMillis - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000 - min * 60 * 1000 - s * 1000;
        return (day > 0 ? day + "," : "") + hour + ":" + min + ":" + s + "." + sss;
    }

    /**
     * 判断2个日期是否在同一周内.
     *
     * @param date1 日期1
     * @param date2 另一个日期
     * @return 若在同一周则返回false, 不在同一周或任意日期为空则返回false
     * @see #isInSameWeek(Calendar cal1, Calendar cal2)
     */
    public static boolean isInSameWeek(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return false;
        }
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        return isInSameWeek(cal1, cal2);
    }

    /**
     * 判断2个日期是否在同一周内.
     *
     * @param cal1 日期1
     * @param cal2 另一个日期
     * @return 若在同一周则返回false, 不在同一周或任意日期为空则返回false
     */
    public static boolean isInSameWeek(Calendar cal1, Calendar cal2) {
        Calendar monday = getDayOfWeek(cal1, 1);
        Calendar sunday = getDayOfWeek(cal1, 7);
        sunday.set(
                sunday.get(Calendar.YEAR),
                sunday.get(Calendar.MONTH),
                sunday.get(Calendar.DATE),
                23,
                59,
                59);
        return cal2.compareTo(monday) >= 0 && cal2.compareTo(sunday) <= 0;
    }

    /**
     * 获取指定日期所在周的任意一天.
     *
     * <p>传入指定日期,及该星期指定的某一天.（星期一传1,星期天传7）
     *
     * <p>例如：
     *
     * <p>获取本周的礼拜五 <br>
     * <br>
     * Calendar cal = Calendar.getInstance(); <br>
     * cal.setTime(new Date()); <br>
     * getDayOfWeek(cal,5);
     *
     * <p>返回日期的准确时间为该天的零点,精确到毫秒,如 2014-10-01 00:00:00 000,
     *
     * @param c   指定日期
     * @param num 该星期指定的某一天
     * @return 指定的日期
     */
    public static Calendar getDayOfWeek(Calendar c, int num) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(c.getTime());
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayOfWeek == 0) {
            dayOfWeek = 7;
        }
        cal.add(Calendar.DATE, -dayOfWeek + num);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE), 0, 0, 0);
        long mills = cal.getTimeInMillis() / 1000;
        // 忽略毫秒数
        cal.setTimeInMillis(mills * 1000);
        return cal;
    }

    /**
     * 获取指定日期所在周的任意一天.
     *
     * @param date 日期
     * @param num  1-7
     * @return 具体日期
     * @see #getDayOfWeek(Calendar c, int num)
     */
    public static Date getDayOfWeek(Date date, int num) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return getDayOfWeek(cal, num).getTime();
    }

    /**
     * 判断指定日期是否为周末（周六/周日）.
     *
     * @param cal 指定日期
     * @return 若传入日期为周六/周日返回true,否则返回false
     */
    public static boolean isWeekEnd(Calendar cal) {
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY;
    }

    /**
     * 判断两日期是否是同一天.
     *
     * @param date1 日期一
     * @param date2 日期二
     * @return 为同一天 返回true,否则返回false
     */
    public static boolean isSameDay(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return false;
        }
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        return isSameDay(cal1, cal2);
    }

    /**
     * 判断两日期是否是同一天.
     *
     * @param cal1 日期一
     * @param cal2 日期二
     * @return true/false
     */
    public static boolean isSameDay(Calendar cal1, Calendar cal2) {
        if (cal1 == null || cal2 == null) {
            return false;
        } else {
            return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
                    && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)
                    && cal1.get(Calendar.DATE) == cal2.get(Calendar.DATE);
        }
    }

    /**
     * 获取两个日期的间隔天数.
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return 两个日期的间隔天数
     */
    public static Integer getDaysBetween(Date startDate, Date endDate) {
        Calendar fromCalendar = Calendar.getInstance();
        fromCalendar.setTime(startDate);
        fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
        fromCalendar.set(Calendar.MINUTE, 0);
        fromCalendar.set(Calendar.SECOND, 0);
        fromCalendar.set(Calendar.MILLISECOND, 0);

        Calendar toCalendar = Calendar.getInstance();
        toCalendar.setTime(endDate);
        toCalendar.set(Calendar.HOUR_OF_DAY, 0);
        toCalendar.set(Calendar.MINUTE, 0);
        toCalendar.set(Calendar.SECOND, 0);
        toCalendar.set(Calendar.MILLISECOND, 0);

        return (int)
                ((toCalendar.getTime().getTime() - fromCalendar.getTime().getTime())
                        / (1000 * 60 * 60 * 24));
    }
}
