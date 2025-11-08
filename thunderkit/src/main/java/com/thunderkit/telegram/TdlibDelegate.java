package com.thunderkit.telegram;

import org.drinkless.tdlib.TdApi;

/**
 * Stub interface for TdlibDelegate - receives Telegram updates.
 * UI components can implement this without requiring Telegram backend.
 */
public interface TdlibDelegate {

    // Authorization state
    default void onAuthorizationStateChanged(TdApi.Object authorizationState) {
        // Stub
    }

    // Updates
    default void onUpdate(TdApi.Object update) {
        // Stub
    }

    // Messages
    default void onNewMessage(TdApi.Message message) {
        // Stub
    }

    default void onMessageContent(long chatId, long messageId, TdApi.MessageContent newContent) {
        // Stub
    }

    default void onMessageEdited(long chatId, long messageId, TdApi.Message message) {
        // Stub
    }

    default void onMessagesDeleted(long chatId, long[] messageIds) {
        // Stub
    }

    // Chats
    default void onChatUpdated(TdApi.Chat chat) {
        // Stub
    }

    default void onChatTitle(long chatId, String title) {
        // Stub
    }

    default void onChatPhoto(long chatId, TdApi.ChatPhoto photo) {
        // Stub
    }

    // Users
    default void onUserUpdated(TdApi.User user) {
        // Stub
    }

    // Files
    default void onFileUpdated(TdApi.File file) {
        // Stub
    }

    // Errors
    default void onError(TdApi.Error error) {
        // Stub
    }
}
