package net.ericsson.emovs.utilities.system;

import java.lang.reflect.Field;

/**
 * Created by Joao Coelho on 2018-05-05.
 */

public class Utils {
    public static void setPrivate(Object obj, Class<?> cls, String prop, Object value) {
        Field field = null;
        try {
            field = cls.getDeclaredField(prop);
            field.setAccessible(true);
            field.set(obj, value);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
