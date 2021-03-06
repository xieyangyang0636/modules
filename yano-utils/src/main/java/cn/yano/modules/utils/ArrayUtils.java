package cn.yano.modules.utils;

import java.util.Arrays;

/**
 * Created by xieyangyang0636 on 2020/1/19.
 */
public class ArrayUtils {
    /**
     *
     * concat:合并数组
     *
     * @author Heroying
     * @param first
     * @param second
     * @return
     * @since JDK 1.6
     */
    public static <T> T[] concat(T[] first, T second) {
        T[] result = Arrays.copyOf(first, first.length + 1);
        result[first.length] = second;
        return result;
    }

    /**
     *
     * concat:合并数组
     *
     * @author Heroying
     * @param first
     * @param second
     * @return
     * @since JDK 1.6
     */
    public static <T> T[] concat(T[] first, T[] second) {
        T[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }

    /**
     *
     * concatAll:合并数组
     *
     * @author Heroying
     * @param first
     * @param rest
     * @return
     * @since JDK 1.6
     */
    public static <T> T[] concatAll(T[] first, T[]... rest) {
        int totalLength = first.length;
        for (T[] array : rest) {
            totalLength += array.length;
        }
        T[] result = Arrays.copyOf(first, totalLength);
        int offset = first.length;
        for (T[] array : rest) {
            System.arraycopy(array, 0, result, offset, array.length);
            offset += array.length;
        }
        return result;
    }
}
