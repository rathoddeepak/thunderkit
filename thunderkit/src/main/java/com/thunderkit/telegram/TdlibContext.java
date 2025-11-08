package com.thunderkit.telegram;

import android.content.Context;

/**
 * Stub for TdlibContext - provides application context.
 */
public class TdlibContext {

    private Context context;

    public TdlibContext() {}

    public TdlibContext(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
