package net.ericsson.emovs.utilities.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by Joao Coelho on 2018-02-05.
 */

public class TestUtils {

    public static void mockProvider(Class<?> myProviderClass, Object providerToMock) {
        Class<?>[] innerClss = myProviderClass.getDeclaredClasses();
        for (Class<?> innerCls : innerClss) {
            try {
                Field staticInstance = innerCls.getDeclaredField("sInstance");
                staticInstance.setAccessible(true);

                Field modifiersField = Field.class.getDeclaredField("modifiers");
                modifiersField.setAccessible(true);
                modifiersField.setInt(staticInstance, staticInstance.getModifiers() & ~Modifier.FINAL);

                staticInstance.set(null, myProviderClass.cast(providerToMock));
            } catch (NoSuchFieldException e) {
                // Do nothing - continue
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void mockPrivateAttribute(Object myObject, String attributeName, Object mockValue) {
        try {
            Field classInstance = myObject.getClass().getDeclaredField(attributeName);
            if (classInstance.isAccessible() == false) {
                classInstance.setAccessible(true);
            }

            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(classInstance, classInstance.getModifiers() & ~Modifier.FINAL);

            classInstance.set(classInstance.get(myObject), classInstance.getType().cast(mockValue));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object callPrivateStaticMethod(Class<?> declaringClass, String methodName, Object ... arguments) throws Exception {
        for(Method method : declaringClass.getDeclaredMethods()) {
            boolean accessible = method.isAccessible();
            try {
                method.setAccessible(true);
                if(Modifier.isStatic(method.getModifiers()) && method.getName().equals(methodName)) {
                    try {
                        return method.invoke(null, arguments);
                    } catch (IllegalArgumentException e) {
                        //Ignore. Might be an overloaded method with wrong parameters.
                        continue;
                    } catch (InvocationTargetException e) {
                        Throwable targetException = e.getTargetException();
                        if(targetException instanceof Exception) {
                            throw (Exception) targetException;
                        } else {
                            throw e;
                        }
                    }
                }
            } finally {
                method.setAccessible(accessible);
            }
        }
        throw new NoSuchMethodException("Could not find static method with name "+methodName+" in "+declaringClass.getName()+" matching the specified parameters.");
    }
}
