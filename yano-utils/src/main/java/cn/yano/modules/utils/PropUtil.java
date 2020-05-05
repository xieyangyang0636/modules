package cn.yano.modules.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

/**
 * PropUtil
 * Created by xieyangyang0636 on 2020/1/19.
 */
public class PropUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(PropUtil.class);

    private static String getFile(String sourceName) throws IOException {
        String file = System.getProperty("data." + sourceName + ".file");
        if (StringUtils.isBlank(file)) {
            file = System.getenv("dataprocess_prop_home");
            // 如果没有就按照当前目录为服务的根目录
            if (StringUtils.isBlank(file) || StringUtils.equals(".", file)) {
                file = System.getProperty("user.dir").replace("bin", "webapps");
            }
            // 将地址都转换为linux模式的地址
            if (File.separatorChar != '/') {
                file = file.replaceAll("\\\\", "/");
            }
            // 如果最后一个是目录标志，就去掉
            if (file.charAt(file.length() - 1) == '/') {
                file = file.substring(0, file.length() - 1);
            }
            file += "/procConf/" + sourceName + "-proc.properties";
            System.setProperty("data." + sourceName + ".file", file);
            LOGGER.info("dataprocess Server file: " + file);
        }

        return file;
    }

    public static String getProcProperty(String sourceName, String key) {
        InputStream inputStream = null;
        try {
            String file = getFile(sourceName);
            inputStream = new FileInputStream(file);
            Properties props = new Properties();
            props.load(inputStream);
            return props.getProperty(key);
        } catch (Exception e) {
            LOGGER.error("PropUtil getProcProperty error: " + e.toString());
            return null;
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                LOGGER.error("PropUtil getProcProper error: " + e.toString());
            }
        }
    }

    public static void setProcProperty(String sourceName, String key, String value) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            String file = getFile(sourceName);
            inputStream = new FileInputStream(file);
            Properties props = new Properties();
            props.load(inputStream);
            props.setProperty(key, value);
            outputStream = new FileOutputStream(file);
            props.store(outputStream, "Update '" + key + " ' value '" + value + "'");
        } catch (Exception e) {
            LOGGER.error("PropUtil setProcProperty error: " + e.toString());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                LOGGER.error("PropUtil setProcProperty error: " + e.toString());
            }
        }
    }
}