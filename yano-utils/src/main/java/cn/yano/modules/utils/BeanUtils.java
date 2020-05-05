package cn.yano.modules.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class BeanUtils {
    public static Field[] getAllFields(Class className) {
        Field[] allFields = new Field[]{};
        for (; className != Object.class; className = className.getSuperclass()) {
            try {
                Field[] fields = className.getDeclaredFields();
                allFields = ArrayUtils.concat(allFields, fields);
            } catch (Exception e) {
                //这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。  
                //如果这里的异常打印或者往外抛，则就不会执行clazz = clazz.getSuperclass(),最后就不会进入到父类中了  
            }
        }
        return allFields;
    }

    public static Field[] getAllAccessableFields(Class className) {
        List<Field> result = new ArrayList<Field>();
        for (; className != Object.class; className = className.getSuperclass()) {
            try {
                Field[] fields = className.getDeclaredFields();
                for (Field field : fields) {
                    if (isAccessable(field)) {
                        result.add(field);
                    }
                }
            } catch (Exception e) {
                //这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。  
                //如果这里的异常打印或者往外抛，则就不会执行clazz = clazz.getSuperclass(),最后就不会进入到父类中了  
            }
        }

        return result.toArray(new Field[0]);
    }

    public static boolean isAccessable(Field field) {
        int mod = field.getModifiers();

//		boolean isPrivate = ((mod & Modifier.PRIVATE) != 0);
        boolean isAbstract = ((mod & Modifier.ABSTRACT) != 0);
        boolean isFinal = ((mod & Modifier.FINAL) != 0);
        boolean isNative = ((mod & Modifier.NATIVE) != 0);
        boolean isInterface = ((mod & Modifier.INTERFACE) != 0);

        if (isAbstract || isFinal || isNative || isInterface) {
            return false;
        } else {
            return true;
        }
    }
}
