package net.ericsson.emovs.utilities;

import android.content.Context;

/**
 * Created by Joao Coelho on 2017-10-24.
 */

public class ContextRegistry {
    private static Context context;

    public static void bind(Context newContext) {
        context = newContext;
    }

    public static Context get() {
        return context;
    }
}
