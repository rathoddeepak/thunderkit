# Telegram Dependency Removal Strategy

## Analysis Summary

**Total Telegram References:** ~8,700
**TdApi Imports:** 20+ files
**Telegram Package Imports:** 20+ files

---

## 🎯 Strategy: 3-Tier Approach

### Tier 1: STUB (Keep UI Logic) ⭐ RECOMMENDED
Create minimal stub interfaces/classes that preserve UI functionality without Telegram backend.

### Tier 2: REMOVE (Telegram-Specific Features)
Delete files that are purely Telegram-specific with no generic UI value.

### Tier 3: REPLACE (Framework-Specific Implementations)
Replace Telegram utilities with generic framework implementations.

---

## 📊 Most Common Dependencies

### TdApi Classes (626 references to TdApi.Message)
```
TdApi.Message          - 626 refs
TdApi.FormattedText    - 270 refs
TdApi.TextEntity       - 183 refs
TdApi.File             - 174 refs
TdApi.User             - 154 refs
TdApi.Chat             - 127 refs
TdApi.MessageSender    - 123 refs
```

### Tdlib Classes (199 refs to TdlibUi)
```
TdlibUi                - 199 refs
TdlibManager           - 153 refs
TdlibFilesManager      - 98 refs
TdlibAccentColor       - 95 refs
TdlibAccount           - 84 refs
TdlibDelegate          - 54 refs
```

---

## 🔧 Implementation Plan

### Phase 1: Create Stub Package ✅

Create `com.thunderkit.telegram/` with minimal stubs:

```
thunderkit/src/main/java/com/thunderkit/telegram/
├── Tdlib.java                    # Main stub interface
├── TdlibManager.java             # Manager stub
├── TdlibDelegate.java            # Delegate interface
├── TdlibAccount.java             # Account stub
├── TdlibUi.java                  # UI helper stub
├── TdlibFilesManager.java        # File manager stub
├── TdlibAccentColor.java         # Color stub
└── [other stubs as needed]
```

Create `org.drinkless.tdlib/` with TdApi stubs:

```
thunderkit/src/main/java/org/drinkless/tdlib/
├── TdApi.java                    # Main TdApi with inner classes
│   ├── Object
│   ├── Message
│   ├── FormattedText
│   ├── TextEntity
│   ├── File
│   ├── User
│   ├── Chat
│   └── [other common types]
└── Client.java                   # Client stub (if needed)
```

### Phase 2: Identify Removable Files

Files that can be DELETED (pure Telegram, no UI value):

```
component/chat/          # Most chat-specific components
data/                    # Telegram data models
loader/                  # Telegram-specific loaders (partially)
```

Files to KEEP (UI value):

```
navigation/              # ✅ All navigation files (core UI)
widget/                  # ✅ Most widgets (UI components)
theme/                   # ✅ Theme system (generic)
tool/                    # ✅ UI utilities (generic)
component/base/          # ✅ Base components
component/popups/        # ✅ Popup components
```

### Phase 3: Safe Removal Process

For each file:
1. Check if it provides generic UI value
2. If YES → Keep and stub dependencies
3. If NO → Delete entirely
4. If PARTIAL → Extract generic UI, remove Telegram logic

---

## 🛠️ Stub Implementation Examples

### Minimal TdApi Stub

```java
package org.drinkless.tdlib;

public class TdApi {
    public static class Object {}

    public static class Message extends Object {
        public long id;
        public MessageSender senderId;
        public long chatId;
        public MessageContent content;
        public int date;
    }

    public static class FormattedText extends Object {
        public String text;
        public TextEntity[] entities;
    }

    public static class TextEntity extends Object {
        public int offset;
        public int length;
        public TextEntityType type;
    }

    public static class File extends Object {
        public int id;
        public long size;
        public String path;
        public LocalFile local;
        public RemoteFile remote;
    }

    public static class LocalFile extends Object {
        public String path;
        public boolean isDownloadingCompleted;
        public long downloadedSize;
    }

    public static class RemoteFile extends Object {
        public String id;
        public boolean isUploadingCompleted;
        public long uploadedSize;
    }

    // Add more as needed...
}
```

### Minimal Tdlib Stub

```java
package com.thunderkit.telegram;

public class Tdlib {
    // Stub implementation - does nothing but compiles

    public static final Tdlib instance() {
        return new Tdlib();
    }

    public TdlibAccount account(long accountId) {
        return null;
    }

    public TdlibFilesManager files() {
        return null;
    }

    // Add minimal methods as compilation requires
}
```

---

## 🎨 UI-Preserving Stubs

These stubs preserve UI logic without Telegram backend:

### TdlibUi Stub (199 references)

```java
package com.thunderkit.telegram;

import android.graphics.drawable.Drawable;

public class TdlibUi {
    // Provide default implementations that work for UI

    public static Drawable getDrawable(Object obj) {
        return null; // UI will handle null gracefully
    }

    public static CharSequence getText(Object obj) {
        return ""; // Return empty string
    }

    // Add more UI helper methods as needed
}
```

### TdlibAccentColor Stub (95 references)

```java
package com.thunderkit.telegram;

public class TdlibAccentColor {
    public int id;
    public int[] colors;

    public TdlibAccentColor(int id, int[] colors) {
        this.id = id;
        this.colors = colors;
    }

    public int getPrimaryColor() {
        return colors != null && colors.length > 0 ? colors[0] : 0;
    }
}
```

---

## 🗑️ Files to Remove Entirely

These provide NO generic UI value:

### Component/Chat (Most files)
```
component/chat/MessagesListManager.java
component/chat/MessageThreadManager.java
component/chat/TdlibMessageListener.java
[90% of chat component files]
```

### Data Package (All files)
```
data/TD*.java              # All Telegram data wrappers
data/TG*.java              # All Telegram game data
```

### Telegram-Specific Widgets
```
widget/EmojiPacksInfoView.java     # Unless you need emoji packs
widget/ReactionsSelectorRecyclerView.java  # Unless you need reactions
widget/SuggestedChatsView.java     # Telegram-specific
```

---

## ✅ Safe Removal Checklist

Before removing any file:

- [ ] Does it extend BaseView/ViewController? → Keep
- [ ] Is it in navigation/? → Keep
- [ ] Is it in theme/? → Keep
- [ ] Does it provide animation utilities? → Keep
- [ ] Is it purely Telegram data model? → Remove
- [ ] Is it in component/chat/? → Probably remove
- [ ] Can UI logic be extracted? → Extract then remove

---

## 🔄 Migration Process

### Step 1: Create Stubs (Safe)
Create all stub classes - doesn't break anything.

### Step 2: Test Compilation
Try to compile, see what breaks.

### Step 3: Iteratively Fix
- Add missing stub methods
- Remove clearly Telegram-only files
- Keep all UI-valuable code

### Step 4: Clean Up
Remove unused stubs and imports.

---

## 🎯 Priority Order

1. **HIGH PRIORITY** - Create TdApi and Tdlib stubs
2. **MEDIUM PRIORITY** - Remove data/ and component/chat/
3. **LOW PRIORITY** - Clean up individual widget dependencies

---

## 📝 Notes

- **DON'T** remove anything that affects navigation, theming, or animation
- **DO** stub liberally - stubs are better than deletions
- **TEST** frequently - compile after each major change
- **KEEP** UI performance intact - don't change rendering logic

---

## Next Steps

1. Create stub packages
2. Compile and identify errors
3. Add stubs incrementally
4. Remove truly unused files
5. Verify sample app still works
