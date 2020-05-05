package cn.yano.modules.utils;

import org.apache.log4j.PropertyConfigurator;

import java.util.Properties;

/**
 * log4j工具类
 * Created by xieyangyang0636 on 2020/1/19.
 */
public class Log4jUtil {
    /**
     * 重载log4j配置
     *
     * @param logName 日志文件名
     */
    public static void initLogProp(String logName) {
        Properties pro = new Properties();
        pro.put("log4j.rootLogger", "INFO, R");
        pro.put("log4j.appender.R", "org.apache.log4j.RollingFileAppender");
        pro.put("log4j.appender.R.File", logName);
        pro.put("log4j.appender.R.MaxFileSize", "500MB");
        pro.put("log4j.appender.R.MaxBackupIndex", "10");
        pro.put("log4j.appender.R.layout", "org.apache.log4j.PatternLayout");
        pro.put("log4j.appender.R.layout.ConversionPattern", "%d [%t] %-5p %c - %m%n");
        PropertyConfigurator.configure(pro);
    }

    /**
     * 重载log4j配置
     *
     * @param logName 日志文件名
     */
    public static void initLogPropWithConsole(String logName) {
        Properties pro = new Properties();
        pro.put("log4j.rootLogger", "INFO, R, stdout");
        pro.put("log4j.appender.stdout", "org.apache.log4j.ConsoleAppender");
        pro.put("log4j.appender.stdout.layout", "org.apache.log4j.PatternLayout");
        pro.put("log4j.appender.stdout.layout.ConversionPattern", "%d [%t] %-5p %c - %m%n");
        pro.put("log4j.appender.R", "org.apache.log4j.RollingFileAppender");
        pro.put("log4j.appender.R.File", logName);
        pro.put("log4j.appender.R.MaxFileSize", "500MB");
        pro.put("log4j.appender.R.MaxBackupIndex", "10");
        pro.put("log4j.appender.R.layout", "org.apache.log4j.PatternLayout");
        pro.put("log4j.appender.R.layout.ConversionPattern", "%d [%t] %-5p %c - %m%n");
        PropertyConfigurator.configure(pro);
    }
}
