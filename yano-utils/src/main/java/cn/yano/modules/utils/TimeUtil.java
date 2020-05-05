package cn.yano.modules.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 时间工具类
 * Created by xieyangyang0636 on 2020/1/19.
 */
public class TimeUtil {

    public static final String FORMAT_YMD = "yyyyMMdd";
    public static final String FORMAT_YMD_HMS = "yyyyMMdd HHmmss";

    /**
     * 字符串转时间戳
     *
     * @param ymd    字符串日期
     * @param format 格式
     * @return 时间戳
     */
    public static long string2long(String ymd, String format) throws ParseException {
        return string2long(ymd, format, 0);
    }

    /**
     * 字符串转时间戳
     *
     * @param ymd    字符串日期
     * @param format 格式
     * @param offset 偏移天数
     * @return 时间戳
     */
    public static long string2long(String ymd, String format, int offset) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        Date date = new SimpleDateFormat(format).parse(ymd);
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, offset);
        return calendar.getTimeInMillis();
    }

    /**
     * 时间戳转字符串
     *
     * @param stmp   时间戳
     * @param format 格式
     * @return 字符串日期
     */
    public static String long2string(long stmp, String format) throws ParseException {
        return new SimpleDateFormat(format).format(new Date(stmp));
    }

    /**
     * 日期转时间戳
     *
     * @param date 日期
     * @return 时间戳
     */
    public static long date2long(Date date) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取日期范围
     *
     * @param start  开始日期
     * @param end    结束日期
     * @param format 日期格式
     * @return 日期范围
     * @throws ParseException
     */
    public static List<String> getDateRange(String start, String end, String format) throws ParseException {
        List<String> rangeList = new ArrayList<>();
        Calendar startCal = Calendar.getInstance();
        Calendar endCal = Calendar.getInstance();
        startCal.setTime(new SimpleDateFormat(format).parse(start));
        endCal.setTime(new SimpleDateFormat(format).parse(end));
        while (startCal.before(endCal)) {
            rangeList.add(new SimpleDateFormat(format).format(startCal.getTime()));
            startCal.add(Calendar.DAY_OF_YEAR, 1);
        }
        if (!rangeList.isEmpty() || startCal.equals(endCal)) {
            rangeList.add(new SimpleDateFormat(format).format(endCal.getTime()));
        }
        return rangeList;
    }
}
