package com.thunderkit.telegram;

import org.drinkless.tdlib.TdApi;

/**
 * Stub for TdlibStatusManager - manages user online status.
 */
public class TdlibStatusManager {

    public TdlibStatusManager() {}

    public boolean isOnline(long userId) {
        return false;
    }

    public CharSequence getStatus(TdApi.User user) {
        return "offline";
    }

    public void updateStatus() {}
}
