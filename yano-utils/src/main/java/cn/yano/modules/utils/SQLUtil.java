package cn.yano.modules.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;

/**
 * SQL工具类
 * Created by xieyangyang0636 on 2020/1/19.
 */
public class SQLUtil {

    /**
     * 对字符串子项加单引号
     *
     * @param val     字符串
     * @param splitor 分隔符
     * @return 结果
     */
    public static String makeSingleQuote(String val, String splitor) {
        StringBuilder builder = new StringBuilder();
        String[] array = val.split(splitor);
        for (String str : array) {
            builder.append("'").append(str).append("',");
        }
        return builder.substring(0, builder.length() - 1);
    }

    /**
     * Clob转成String
     *
     * @param clob Clob
     * @return String
     * @throws SQLException
     * @throws IOException
     */
    public static String ClobToString(Clob clob) throws SQLException, IOException {
        String reString = "";   //拼接变量
        Reader is = clob.getCharacterStream();// 得到流
        BufferedReader br = new BufferedReader(is);
        String s = br.readLine();
        StringBuffer sb = new StringBuffer();
        while (s != null) {
            sb.append(s);
            s = br.readLine();
        }
        reString = sb.toString(); //转换成字符串，进行返回
        return reString;
    }

}
