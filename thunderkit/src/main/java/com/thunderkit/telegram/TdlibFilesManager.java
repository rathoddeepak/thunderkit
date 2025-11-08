package com.thunderkit.telegram;

import org.drinkless.tdlib.TdApi;

/**
 * Stub for TdlibFilesManager - manages file downloads/uploads.
 * UI components can reference this without requiring Telegram backend.
 */
public class TdlibFilesManager {

    public TdlibFilesManager() {}

    // Download methods - do nothing
    public void download(TdApi.File file) {
        // Stub
    }

    public void download(TdApi.File file, int priority) {
        // Stub
    }

    public void cancelDownload(TdApi.File file) {
        // Stub
    }

    // Upload methods - do nothing
    public void upload(TdApi.File file) {
        // Stub
    }

    public void cancelUpload(TdApi.File file) {
        // Stub
    }

    // File status
    public boolean isDownloading(TdApi.File file) {
        return false;
    }

    public boolean isDownloaded(TdApi.File file) {
        return file != null && file.local != null && file.local.isDownloadingCompleted;
    }

    public boolean isUploading(TdApi.File file) {
        return false;
    }

    public boolean isUploaded(TdApi.File file) {
        return file != null && file.remote != null && file.remote.isUploadingCompleted;
    }

    // File paths
    public String getFilePath(TdApi.File file) {
        return file != null && file.local != null ? file.local.path : null;
    }

    public String getFileDir() {
        return "";
    }

    // Listener stubs
    public void addListener(Object listener) {
        // Stub
    }

    public void removeListener(Object listener) {
        // Stub
    }
}
