# ThunderKit Cleanup Guide

**Safe removal of Telegram-specific files while preserving UI functionality**

---

## 🎯 Cleanup Strategy

### Goals
1. ✅ Remove purely Telegram-specific code
2. ✅ Keep all generic UI components
3. ✅ Maintain performance and animations
4. ✅ Preserve navigation and theme systems
5. ✅ Reduce framework size

### Approach
- **Conservative**: Remove only obviously Telegram-specific files
- **Test-Driven**: Build and test after each removal
- **Reversible**: Use git to track changes

---

## 📋 Removal Checklist

### Tier 1: Safe to Remove (Pure Telegram Logic)

#### 1. Chat Component Files (90% removable)

**Directory:** `thunderkit/src/main/java/com/thunderkit/component/chat/`

**Safe to delete:**
```bash
# Telegram-specific chat managers
component/chat/MessagesListManager.java
component/chat/MessageThreadManager.java
component/chat/InlineResultsController.java
component/chat/TdlibMessageListener.java
component/chat/MediaPreviewsController.java
component/chat/VoiceVideoButtonManager.java
component/chat/MessageEditManager.java
component/chat/PinnedMessagesBar.java
component/chat/ReplyBarView.java
component/chat/SearchMessagesController.java
component/chat/CallScheduleController.java
component/chat/GroupCallController.java

# Most .java files in component/chat/ are Telegram-specific
```

**Consider keeping:**
```bash
# Generic UI that might be useful
component/chat/MessageView.java           # If you need message UI
component/chat/InputView.java             # If you need input UI
component/chat/MediaLayout.java           # If you need media layout
```

**Removal command:**
```bash
# Review first, then delete
rm -rf thunderkit/src/main/java/com/thunderkit/component/chat/
```

---

#### 2. Data Package (100% removable)

**Directory:** `thunderkit/src/main/java/com/thunderkit/data/`

All data models are Telegram-specific wrappers.

**Files to delete:**
```bash
data/TD*.java              # TdApi data wrappers
data/TG*.java              # Telegram game data
data/ChatList.java         # Telegram chat lists
data/UserData.java         # Telegram user data
data/MessageData.java      # Telegram message data

# Essentially all files in data/
```

**Removal command:**
```bash
rm -rf thunderkit/src/main/java/com/thunderkit/data/
```

---

#### 3. Telegram-Specific Widgets

**Directory:** `thunderkit/src/main/java/com/thunderkit/widget/`

**Safe to delete:**
```bash
widget/EmojiPacksInfoView.java              # Telegram emoji packs
widget/EmojiStatusInfoView.java             # Telegram premium feature
widget/ReactionsSelectorRecyclerView.java   # Telegram reactions
widget/SuggestedChatsView.java              # Telegram suggestions
widget/BubbleLayout.java                    # Telegram chat bubbles (unless needed)
widget/InlineResultsWrap.java               # Telegram bot results
widget/CallLayout.java                      # Telegram calls
widget/SecretChatLayout.java                # Telegram secret chats
widget/SponsoredMessageView.java            # Telegram ads
widget/StoryViewer*.java                    # Telegram stories
widget/ViewPagerTopView.java (if Telegram-specific)
```

**Check before deleting:**
```bash
widget/CustomEmojiEditText.java    # Might be useful for emoji input
widget/ChartLayout.java             # Might be useful for charts
widget/WallpaperParametersView.java # Depends if you need wallpapers
```

---

#### 4. Component Subdirectories

**Directories to review:**

```bash
component/emoji/          # Telegram emoji system (partially removable)
component/inline/         # Telegram inline bots (fully removable)
component/passcode/       # Telegram passcode (might be useful)
component/sharedmedia/    # Telegram shared media (mostly removable)
component/sticker/        # Telegram stickers (mostly removable)
component/user/           # Telegram user profiles (mostly removable)
component/dialogs/        # Telegram dialog lists (mostly removable)
component/preview/        # Preview components (check individually)
```

**Example removals:**
```bash
# Telegram inline bots (safe to delete)
rm -rf thunderkit/src/main/java/com/thunderkit/component/inline/

# Telegram dialog lists (safe to delete)
rm -rf thunderkit/src/main/java/com/thunderkit/component/dialogs/

# Telegram shared media (safe to delete)
rm -rf thunderkit/src/main/java/com/thunderkit/component/sharedmedia/
```

---

### Tier 2: Keep (Generic UI Value)

#### ✅ Navigation System (KEEP ALL)
```bash
navigation/              # Complete navigation framework
  - NavigationController.java
  - ViewController.java
  - HeaderView.java
  - DrawerController.java
  - All other navigation files
```

#### ✅ Core Widgets (KEEP MOST)
```bash
widget/BaseView.java                   # Base view class
widget/CircleButton.java               # Reusable button
widget/MaterialEditText.java           # Material text input
widget/CheckView.java                  # Checkbox component
widget/ShadowView.java                 # Shadow effects
widget/RootFrameLayout.java            # Root container
widget/PopupLayout.java                # Popup system
widget/FrameLayoutFix.java             # Framework fixes
widget/NoScrollTextView.java           # Optimized text view
widget/ProgressComponent.java          # Progress indicators
widget/ListInfoView.java               # List UI
widget/DoubleTextView.java             # Two-line text
widget/AttachDelegate.java             # Lifecycle delegates
```

#### ✅ Theme System (KEEP ALL)
```bash
theme/                   # Complete theme system
  - Theme.java
  - ThemeManager.java
  - ColorState.java
  - ThemeDelegate.java
  - All other theme files
```

#### ✅ Tools (KEEP ALL)
```bash
tool/                    # UI utilities
  - UI.java
  - Screen.java
  - Views.java
  - Paints.java
  - DrawAlgorithms.java
  - All other tool files
```

#### ✅ Component Base (KEEP ALL)
```bash
component/base/         # Base component classes
```

#### ✅ Component Popups (KEEP MOST)
```bash
component/popups/       # Popup components (mostly reusable)
```

---

## 🔧 Cleanup Process

### Step-by-Step

#### 1. Backup First
```bash
cd /Users/zoop/dev/abeya/ThunderKit
git add .
git commit -m "Backup before Telegram cleanup"
```

#### 2. Start with Safest Removals

**Remove data package:**
```bash
rm -rf thunderkit/src/main/java/com/thunderkit/data/
./gradlew build  # Test
```

**Remove inline components:**
```bash
rm -rf thunderkit/src/main/java/com/thunderkit/component/inline/
./gradlew build  # Test
```

**Remove dialogs components:**
```bash
rm -rf thunderkit/src/main/java/com/thunderkit/component/dialogs/
./gradlew build  # Test
```

#### 3. Remove Chat Components (Carefully)

```bash
# Option A: Remove entire directory
rm -rf thunderkit/src/main/java/com/thunderkit/component/chat/

# Option B: Remove selectively (recommended)
cd thunderkit/src/main/java/com/thunderkit/component/chat/
rm MessagesListManager.java
rm MessageThreadManager.java
rm TdlibMessageListener.java
# ... remove others as needed

./gradlew build  # Test after each removal
```

#### 4. Remove Telegram-Specific Widgets

```bash
cd thunderkit/src/main/java/com/thunderkit/widget/

# Remove one by one, testing each time
rm EmojiPacksInfoView.java && ../../../../../../../../../gradlew build
rm EmojiStatusInfoView.java && ../../../../../../../../../gradlew build
rm ReactionsSelectorRecyclerView.java && ../../../../../../../../../gradlew build
rm SuggestedChatsView.java && ../../../../../../../../../gradlew build
```

#### 5. Fix Compilation Errors

If build fails:
- Check error message
- Identify if file is needed
- Either: Keep the file OR add stub for dependency
- Rebuild

#### 6. Test Sample App

```bash
./gradlew :sample:assembleDebug
# Install and test on device
```

---

## 📊 Size Reduction Estimate

| Component | Files | Estimated Size | Impact |
|-----------|-------|----------------|--------|
| data/ | ~50 | ~500KB | ⭐⭐⭐ Safe |
| component/chat/ | ~80 | ~1.5MB | ⭐⭐⭐ Safe |
| component/inline/ | ~15 | ~200KB | ⭐⭐⭐ Safe |
| component/dialogs/ | ~20 | ~300KB | ⭐⭐⭐ Safe |
| component/sharedmedia/ | ~10 | ~150KB | ⭐⭐ Mostly safe |
| Telegram widgets | ~30 | ~400KB | ⭐⭐ Review each |
| **Total Removable** | **~200** | **~3MB** | **~30% reduction** |

---

## 🧪 Verification After Cleanup

### 1. Build Verification
```bash
./gradlew clean build
```

**Expected:** No compilation errors

### 2. Component Count
```bash
find thunderkit/src/main/java -name "*.java" | wc -l
```

**Before cleanup:** 605 files
**After cleanup:** ~400 files (estimated)

### 3. Size Verification
```bash
du -sh thunderkit/src/main/java
```

**Before cleanup:** ~8MB
**After cleanup:** ~5-6MB (estimated)

### 4. Functional Testing

Run sample app and verify:
- ✅ Navigation works
- ✅ Theme switching works
- ✅ Animations are smooth
- ✅ No crashes
- ✅ UI renders properly

---

## ⚠️ Common Issues

### Issue 1: Compilation Error After Removal

**Problem:** `cannot find symbol: class XxxView`

**Solution:**
1. Check if other files depend on removed file
2. Either:
   - Restore the file (keep it)
   - Remove dependent files too
   - Stub the dependency

### Issue 2: Missing Methods

**Problem:** `cannot find symbol: method doSomething()`

**Solution:**
Add stub method to telegram stub classes

### Issue 3: Runtime Crash

**Problem:** NullPointerException in UI

**Solution:**
1. Check stub returns appropriate defaults
2. Add null checks in UI code
3. Enhance stub implementation

---

## 🎯 Recommended Cleanup Levels

### Level 1: Conservative (Recommended)
**Remove:** data/, component/inline/, component/dialogs/
**Keep:** Everything else
**Result:** ~20% size reduction, very safe

### Level 2: Moderate
**Remove:** Level 1 + component/chat/, Telegram-specific widgets
**Keep:** Navigation, theme, core widgets
**Result:** ~30% size reduction, mostly safe

### Level 3: Aggressive
**Remove:** Level 2 + component/emoji/, component/sticker/, etc.
**Keep:** Only navigation, theme, essential widgets
**Result:** ~40% size reduction, requires testing

---

## 📝 Cleanup Checklist

- [ ] Backup code with git
- [ ] Start with data/ removal
- [ ] Test build after each removal
- [ ] Remove component/inline/
- [ ] Remove component/dialogs/
- [ ] Selectively remove from component/chat/
- [ ] Remove Telegram-specific widgets
- [ ] Fix any compilation errors
- [ ] Test sample app
- [ ] Verify UI functionality
- [ ] Commit changes

---

## ✅ What to Keep (Summary)

**Always Keep:**
- ✅ `navigation/` - Complete package
- ✅ `theme/` - Complete package
- ✅ `tool/` - Complete package
- ✅ `widget/BaseView.java` and core widgets
- ✅ `component/base/` - Complete package
- ✅ `component/popups/` - Most files
- ✅ Animation-related files
- ✅ Custom view implementations

**Always Remove:**
- ❌ `data/` - Complete package
- ❌ `component/inline/` - Complete package
- ❌ `component/dialogs/` - Complete package
- ❌ Most of `component/chat/`
- ❌ Telegram-branded widgets

---

## 🚀 After Cleanup

Your framework will be:
- ✅ Smaller and cleaner
- ✅ Faster to build
- ✅ Easier to understand
- ✅ Telegram-independent
- ✅ Still fully functional for UI

**Result:** A lean, mean UI framework! 💪

---

**Location:** `/Users/zoop/dev/abeya/ThunderKit/`
