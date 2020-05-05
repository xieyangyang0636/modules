package cn.yano.modules.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;


public class PatterUtils {
    private static final Logger logger = LoggerFactory.getLogger(PatterUtils.class);

    private static final Pattern IPV4_PATTERN =
            Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    private static final Pattern IPV6_STD_PATTERN =
            Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
    private static final Pattern IPV6_HEX_COMPRESSED_PATTERN =
            Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");

    //校验格式为yyyy-MM-dd HH:mm:ss,包括闰年月日，如2000-02-29 00:00:00 存在，校验�?�过�?2001-02-29 00:00:00 不存在，校验不�?�过
    private static final Pattern TIME_PATTERN =
            Pattern.compile("^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29))\\s+([0-1]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$");

    private static boolean isIPv4Address(final String input) {
        return IPV4_PATTERN.matcher(input).matches();
    }

    private static boolean isIPv6StdAddress(final String input) {
        return IPV6_STD_PATTERN.matcher(input).matches();
    }

    private static boolean isIPv6HexCompressedAddress(final String input) {
        return IPV6_HEX_COMPRESSED_PATTERN.matcher(input).matches();
    }

    private static boolean isIPv6Address(final String input) {
        return isIPv6StdAddress(input) || isIPv6HexCompressedAddress(input);
    }

    public static boolean isIPAddress(final String input) {
        return isIPv4Address(input) || isIPv6Address(input);
    }

    public static boolean isDate(final String date) {
        String dt = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            long d = Long.parseLong(date);
            if (new Date(d).getTime() > new Date(Long.parseLong("1435593600000")).getTime() &&
                    new Date(d).getTime() < new Date(Long.parseLong("4591267200000")).getTime()) {
                dt = sdf.format(new Date(d));
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            logger.info("日期转换失败，日期为�?" + date + ",错误信息为：" + e.getMessage());
            return false;
        } catch (Exception e) {
            logger.info(e.getMessage());
            return false;
        }
    }

}
