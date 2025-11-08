package com.thunderkit.telegram;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;

import org.drinkless.tdlib.TdApi;

/**
 * Stub for TdlibUi - UI helper methods for Telegram objects.
 * Returns safe default values that won't crash UI rendering.
 */
public class TdlibUi {

    // Text helpers - return safe defaults
    public static CharSequence getText(TdApi.FormattedText text) {
        return text != null && text.text != null ? text.text : "";
    }

    public static CharSequence getText(TdApi.Message message) {
        return "";
    }

    public static CharSequence getMessagePreview(TdApi.Message message) {
        return "";
    }

    public static String getTitle(TdApi.Chat chat) {
        return chat != null && chat.title != null ? chat.title : "Chat";
    }

    public static String getTitle(TdApi.User user) {
        if (user == null) return "User";
        if (user.firstName != null && user.lastName != null) {
            return user.firstName + " " + user.lastName;
        }
        return user.firstName != null ? user.firstName : "User";
    }

    // Drawable helpers - return null (UI should handle gracefully)
    public static Drawable getDrawable(Object obj) {
        return null;
    }

    public static Drawable getAvatar(TdApi.User user) {
        return null;
    }

    public static Drawable getAvatar(TdApi.Chat chat) {
        return null;
    }

    // Status helpers
    public static CharSequence getUserStatus(TdApi.User user) {
        return "offline";
    }

    public static CharSequence getMessageDate(int date) {
        return "";
    }

    // Formatting helpers
    public static SpannableStringBuilder format(TdApi.FormattedText text) {
        return new SpannableStringBuilder(text != null && text.text != null ? text.text : "");
    }

    public static SpannableStringBuilder formatMessage(TdApi.Message message) {
        return new SpannableStringBuilder("");
    }

    // Content type helpers
    public static String getContentType(TdApi.MessageContent content) {
        if (content == null) return "message";
        return content.getClass().getSimpleName().replace("Message", "").toLowerCase();
    }

    public static boolean isMediaContent(TdApi.MessageContent content) {
        return content instanceof TdApi.MessagePhoto ||
               content instanceof TdApi.MessageVideo ||
               content instanceof TdApi.MessageAnimation;
    }

    // File helpers
    public static String getFileName(TdApi.File file) {
        return file != null && file.local != null && file.local.path != null ?
               file.local.path : "file";
    }

    public static String getFileSize(long size) {
        if (size < 1024) return size + " B";
        if (size < 1024 * 1024) return (size / 1024) + " KB";
        return (size / (1024 * 1024)) + " MB";
    }

    // Safe defaults for UI
    public static int getColor(Object obj) {
        return 0xFF000000; // Default black
    }

    public static int getAccentColor(long userId) {
        return 0xFF2196F3; // Default blue
    }
}
