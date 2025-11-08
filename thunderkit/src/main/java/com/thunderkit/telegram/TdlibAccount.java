package com.thunderkit.telegram;

import org.drinkless.tdlib.TdApi;

/**
 * Stub for TdlibAccount - represents a Telegram account.
 * UI components can reference this without requiring Telegram backend.
 */
public class TdlibAccount {

    public long id;

    public TdlibAccount() {}

    public TdlibAccount(long id) {
        this.id = id;
    }

    // Account info
    public long getId() {
        return id;
    }

    public TdApi.User getUser() {
        return null;
    }

    public TdApi.User getMyUser() {
        return null;
    }

    public long getMyUserId() {
        return 0;
    }

    // Tdlib instance
    public Tdlib tdlib() {
        return Tdlib.instance();
    }

    // Authorization status
    public boolean isAuthorized() {
        return false;
    }

    public boolean isUnauthorized() {
        return true;
    }

    // Listener stubs
    public void addListener(Object listener) {
        // Stub
    }

    public void removeListener(Object listener) {
        // Stub
    }
}
