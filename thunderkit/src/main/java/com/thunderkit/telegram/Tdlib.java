package com.thunderkit.telegram;

import org.drinkless.tdlib.TdApi;

/**
 * Stub implementation of Tdlib for ThunderKit framework.
 * This allows UI components to compile without requiring actual Telegram backend.
 *
 * All methods return null or default values - UI code should handle gracefully.
 */
public class Tdlib {

    // Singleton instance for compatibility
    private static final Tdlib INSTANCE = new Tdlib();

    public static Tdlib instance() {
        return INSTANCE;
    }

    public Tdlib() {}

    // Account management stubs
    public TdlibAccount account(long accountId) {
        return null;
    }

    public long currentAccountId() {
        return 0;
    }

    // File management stub
    public TdlibFilesManager files() {
        return null;
    }

    // UI helpers stub
    public TdlibUi ui() {
        return null;
    }

    // Cache stub
    public TdlibCache cache() {
        return null;
    }

    // Settings stub
    public TdlibSettingsManager settings() {
        return null;
    }

    // Status stub
    public TdlibStatusManager status() {
        return null;
    }

    // Emoji stub
    public TdlibEmojiManager emoji() {
        return null;
    }

    // Context stub
    public TdlibContext context() {
        return null;
    }

    // Send API calls (do nothing)
    public void send(TdApi.Function<?> function) {
        // Stub - does nothing
    }

    public void send(TdApi.Function<?> function, Object resultHandler) {
        // Stub - does nothing
    }

    // Listener methods (do nothing)
    public void listeners() {
        // Stub
    }

    public void addListener(Object listener) {
        // Stub
    }

    public void removeListener(Object listener) {
        // Stub
    }

    // Utility methods
    public boolean isAuthorized() {
        return false;
    }

    public boolean hasAccount(long accountId) {
        return false;
    }
}
