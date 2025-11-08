package org.drinkless.tdlib;

/**
 * Stub implementation of TdApi for ThunderKit framework.
 * Provides minimal data structures to allow UI components to compile without Telegram backend.
 *
 * NOTE: This is a STUB - UI logic will work, but no actual Telegram functionality.
 */
public class TdApi {

    // Base class for all TdApi objects
    public static class Object {
        public Object() {}
    }

    // Base for functions
    public static class Function<T extends Object> extends Object {
        public Function() {}
    }

    // ========== MESSAGES ==========

    public static class Message extends Object {
        public long id;
        public MessageSender senderId;
        public long chatId;
        public MessageContent content;
        public int date;
        public int editDate;
        public MessageForwardInfo forwardInfo;
        public MessageReplyTo replyTo;
        public long interactionInfo;
        public String authorSignature;
        public long mediaAlbumId;
        public ReplyMarkup replyMarkup;

        public Message() {}
    }

    public static class FormattedText extends Object {
        public String text;
        public TextEntity[] entities;

        public FormattedText() {}
        public FormattedText(String text, TextEntity[] entities) {
            this.text = text;
            this.entities = entities;
        }
    }

    public static class TextEntity extends Object {
        public int offset;
        public int length;
        public TextEntityType type;

        public TextEntity() {}
        public TextEntity(int offset, int length, TextEntityType type) {
            this.offset = offset;
            this.length = length;
            this.type = type;
        }
    }

    public static class TextEntityType extends Object {}
    public static class TextEntityTypeBold extends TextEntityType {}
    public static class TextEntityTypeItalic extends TextEntityType {}
    public static class TextEntityTypeUnderline extends TextEntityType {}
    public static class TextEntityTypeStrikethrough extends TextEntityType {}
    public static class TextEntityTypeCode extends TextEntityType {}
    public static class TextEntityTypePre extends TextEntityType {
        public String language;
    }
    public static class TextEntityTypeTextUrl extends TextEntityType {
        public String url;
    }
    public static class TextEntityTypeUrl extends TextEntityType {}
    public static class TextEntityTypeMention extends TextEntityType {}
    public static class TextEntityTypeHashtag extends TextEntityType {}

    // ========== MESSAGE CONTENT ==========

    public static class MessageContent extends Object {}

    public static class MessageText extends MessageContent {
        public FormattedText text;
        public MessageText() {}
    }

    public static class MessagePhoto extends MessageContent {
        public Photo photo;
        public FormattedText caption;
        public MessagePhoto() {}
    }

    public static class MessageVideo extends MessageContent {
        public Video video;
        public FormattedText caption;
        public MessageVideo() {}
    }

    public static class MessageAnimation extends MessageContent {
        public Animation animation;
        public FormattedText caption;
        public MessageAnimation() {}
    }

    public static class MessageAudio extends MessageContent {
        public Audio audio;
        public FormattedText caption;
        public MessageAudio() {}
    }

    public static class MessageDocument extends MessageContent {
        public Document document;
        public FormattedText caption;
        public MessageDocument() {}
    }

    public static class MessageSticker extends MessageContent {
        public Sticker sticker;
        public MessageSticker() {}
    }

    public static class MessageVoiceNote extends MessageContent {
        public VoiceNote voiceNote;
        public FormattedText caption;
        public MessageVoiceNote() {}
    }

    // ========== MESSAGE SENDER ==========

    public static class MessageSender extends Object {}

    public static class MessageSenderUser extends MessageSender {
        public long userId;
        public MessageSenderUser() {}
    }

    public static class MessageSenderChat extends MessageSender {
        public long chatId;
        public MessageSenderChat() {}
    }

    // ========== MESSAGE INFO ==========

    public static class MessageForwardInfo extends Object {
        public MessageForwardOrigin origin;
        public int date;
        public String publicServiceAnnouncementType;
    }

    public static class MessageForwardOrigin extends Object {}

    public static class MessageReplyTo extends Object {}

    public static class ReplyMarkup extends Object {}

    // ========== FILES ==========

    public static class File extends Object {
        public int id;
        public long size;
        public long expectedSize;
        public LocalFile local;
        public RemoteFile remote;

        public File() {}
    }

    public static class LocalFile extends Object {
        public String path;
        public boolean canBeDownloaded;
        public boolean canBeDeleted;
        public boolean isDownloadingActive;
        public boolean isDownloadingCompleted;
        public long downloadedSize;

        public LocalFile() {}
    }

    public static class RemoteFile extends Object {
        public String id;
        public String uniqueId;
        public boolean isUploadingActive;
        public boolean isUploadingCompleted;
        public long uploadedSize;

        public RemoteFile() {}
    }

    // ========== MEDIA ==========

    public static class Photo extends Object {
        public boolean hasStickers;
        public Minithumbnail minithumbnail;
        public PhotoSize[] sizes;

        public Photo() {}
    }

    public static class PhotoSize extends Object {
        public String type;
        public File photo;
        public int width;
        public int height;
        public int[] progressiveSizes;

        public PhotoSize() {}
    }

    public static class Minithumbnail extends Object {
        public int width;
        public int height;
        public byte[] data;
    }

    public static class Video extends Object {
        public int duration;
        public int width;
        public int height;
        public String fileName;
        public String mimeType;
        public boolean hasStickers;
        public boolean supportsStreaming;
        public Minithumbnail minithumbnail;
        public Thumbnail thumbnail;
        public File video;

        public Video() {}
    }

    public static class Animation extends Object {
        public int duration;
        public int width;
        public int height;
        public String fileName;
        public String mimeType;
        public boolean hasStickers;
        public Minithumbnail minithumbnail;
        public Thumbnail thumbnail;
        public File animation;

        public Animation() {}
    }

    public static class Audio extends Object {
        public int duration;
        public String title;
        public String performer;
        public String fileName;
        public String mimeType;
        public Minithumbnail albumCoverMinithumbnail;
        public Thumbnail albumCoverThumbnail;
        public File audio;

        public Audio() {}
    }

    public static class Document extends Object {
        public String fileName;
        public String mimeType;
        public Minithumbnail minithumbnail;
        public Thumbnail thumbnail;
        public File document;

        public Document() {}
    }

    public static class VoiceNote extends Object {
        public int duration;
        public byte[] waveform;
        public String mimeType;
        public File voice;

        public VoiceNote() {}
    }

    public static class Sticker extends Object {
        public long setId;
        public int width;
        public int height;
        public String emoji;
        public StickerType type;
        public StickerFormat format;
        public Thumbnail thumbnail;
        public File sticker;

        public Sticker() {}
    }

    public static class StickerType extends Object {}
    public static class StickerFormat extends Object {}

    public static class Thumbnail extends Object {
        public ThumbnailFormat format;
        public int width;
        public int height;
        public File file;

        public Thumbnail() {}
    }

    public static class ThumbnailFormat extends Object {}

    // ========== USERS & CHATS ==========

    public static class User extends Object {
        public long id;
        public String firstName;
        public String lastName;
        public String username;
        public String phoneNumber;
        public UserStatus status;
        public ProfilePhoto profilePhoto;
        public boolean isContact;
        public boolean isMutualContact;
        public boolean isVerified;
        public boolean isPremium;
        public boolean isSupport;
        public String restrictionReason;
        public boolean isScam;
        public boolean isFake;
        public UserType type;

        public User() {}
    }

    public static class Chat extends Object {
        public long id;
        public ChatType type;
        public String title;
        public ChatPhoto photo;
        public ChatPermissions permissions;
        public Message lastMessage;
        public long[] positions;
        public long unreadCount;
        public long unreadMentionCount;
        public ChatNotificationSettings notificationSettings;

        public Chat() {}
    }

    public static class ChatType extends Object {}
    public static class UserType extends Object {}
    public static class UserStatus extends Object {}

    public static class ProfilePhoto extends Object {
        public long id;
        public File small;
        public File big;
        public Minithumbnail minithumbnail;

        public ProfilePhoto() {}
    }

    public static class ChatPhoto extends Object {
        public long id;
        public File small;
        public File big;
        public Minithumbnail minithumbnail;

        public ChatPhoto() {}
    }

    public static class ChatPermissions extends Object {
        public boolean canSendMessages;
        public boolean canSendMediaMessages;
        public boolean canSendPolls;
        public boolean canSendOtherMessages;
        public boolean canAddWebPagePreviews;
        public boolean canChangeInfo;
        public boolean canInviteUsers;
        public boolean canPinMessages;
    }

    public static class ChatNotificationSettings extends Object {
        public boolean useDefaultMuteFor;
        public int muteFor;
        public boolean useDefaultSound;
        public long soundId;
        public boolean useDefaultShowPreview;
        public boolean showPreview;
    }

    // ========== ERRORS ==========

    public static class Error extends Object {
        public int code;
        public String message;

        public Error() {}
        public Error(int code, String message) {
            this.code = code;
            this.message = message;
        }
    }

    // ========== COMMON ==========

    public static class Ok extends Object {
        public Ok() {}
    }

    // Add more stub classes as needed for compilation
}
