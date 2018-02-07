package net.ericsson.emovs.utilities.test;

import net.ericsson.emovs.utilities.entitlements.IEntitlementCallback;

import java.lang.reflect.Field;
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
}
