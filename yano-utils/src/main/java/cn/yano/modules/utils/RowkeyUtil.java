package cn.yano.modules.utils;

/**
 * RowKey 工具类
 * Created by xieyangyang0636 on 2020/1/19.
 */
public class RowkeyUtil {

    /**
     * 翻转时间戳
     *
     * @param timeStmp 时间戳
     * @return 翻转的时间戳（10位数字）
     */
    public static Long reverseStmp(Long timeStmp) {
        if (timeStmp.compareTo(9999999999L) > 0) {
            timeStmp = Long.valueOf(timeStmp.toString().substring(0, 10));
        }
        return 9999999999L - timeStmp;
    }
}
