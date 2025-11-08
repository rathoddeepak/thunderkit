package com.thunderkit.telegram;

import android.content.Context;

/**
 * Stub for TdlibManager - manages Tdlib instances.
 * UI components can reference this without requiring Telegram backend.
 */
public class TdlibManager {

    private static TdlibManager instance;

    public static TdlibManager instance() {
        if (instance == null) {
            instance = new TdlibManager();
        }
        return instance;
    }

    public TdlibManager() {}

    // Get Tdlib instance
    public Tdlib current() {
        return Tdlib.instance();
    }

    public Tdlib get(long accountId) {
        return null;
    }

    // Initialization stub
    public void initialize(Context context) {
        // Stub - does nothing
    }

    // Account management
    public TdlibAccount currentAccount() {
        return null;
    }

    public TdlibAccount[] accounts() {
        return new TdlibAccount[0];
    }

    public boolean hasAccounts() {
        return false;
    }

    // Listener stubs
    public void addListener(Object listener) {
        // Stub
    }

    public void removeListener(Object listener) {
        // Stub
    }
}
