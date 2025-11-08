package com.thunderkit.telegram;

import org.drinkless.tdlib.TdApi;

/**
 * Stub for TdlibCache - caches Telegram objects.
 */
public class TdlibCache {

    public TdlibCache() {}

    public TdApi.User getUser(long userId) {
        return null;
    }

    public TdApi.Chat getChat(long chatId) {
        return null;
    }

    public TdApi.Message getMessage(long chatId, long messageId) {
        return null;
    }

    public TdApi.File getFile(int fileId) {
        return null;
    }

    public void putUser(TdApi.User user) {}
    public void putChat(TdApi.Chat chat) {}
    public void putMessage(TdApi.Message message) {}
    public void putFile(TdApi.File file) {}
}
