# ThunderKit

A comprehensive, high-performance UI/UX framework extracted from Telegram-X, providing professional-grade navigation, animations, theming, and UI components for Android applications.

## 🚀 What is ThunderKit?

ThunderKit is a complete Android UI framework that includes:

- **🧭 Advanced Navigation System** - Stack-based navigation with smooth transitions and gesture support
- **🎨 Comprehensive Theme Engine** - Dynamic theming with 200+ color IDs and multiple theme support
- **✨ Animation Framework** - Factor-based animation system for buttery-smooth transitions
- **🎯 100+ UI Components** - Production-tested, reusable widgets and views
- **🛠️ Utility Library** - Extensive Android and core utilities via vkryl

## 📦 Modules

ThunderKit is organized into three modules:

### 1. `thunderkit` - Main Framework
The core UI framework containing:
- **Navigation** (62 files) - ViewControllers, NavigationController, headers, drawers
- **Widgets** (118 files) - Buttons, lists, inputs, custom views
- **Theme** (20 files) - Theme management, color system, styling
- **Components** (125 files) - Base component classes and utilities
- **Tools** (22 files) - UI helpers, Screen utilities, Views helpers

**Package:** `com.thunderkit`

### 2. `thunderkit-vkryl` - Foundation Utilities
Core Android utilities and helpers (76 files):
- **Android utilities** - Custom views, animators, view helpers
- **Core utilities** - Collections, string utils, math helpers

**Package:** `me.vkryl.android` & `me.vkryl.core`

### 3. `sample` - Example Application
Sample app demonstrating ThunderKit usage

**Package:** `com.myproject`

## 🏗️ Architecture

```
Activity
└── RootFrameLayout
    ├── NavigationLayout
    │   └── ViewController's View
    ├── HeaderView
    │   ├── Back Button
    │   ├── Title
    │   └── Menu Buttons
    ├── Drawer (optional)
    └── Overlays/Popups
```

## 📚 Key Components

### Navigation System

**ViewController** - Base class for all screens:
```java
public class HomeScreen extends ViewController<Void> {
    @Override
    protected View onCreateView(Context context) {
        // Build your UI
        return view;
    }

    @Override
    public CharSequence getTitle() {
        return "Home";
    }
}
```

**NavigationController** - Manages screen stack:
- Push/pop screens with animations
- Gesture-based navigation
- Header management
- Lifecycle handling

### Theme System

**Dynamic theming with multiple themes:**
```java
// Set theme
ThemeManager.setCurrentTheme(ThemeId.CLASSIC);

// Listen to theme changes
view.addThemeListener((themeId, theme) -> {
    view.invalidate();
});

// Get themed colors
int color = Theme.getColor(ColorId.text_primary);
```

### Animation Framework

**FactorAnimator** - Smooth value-based animations:
```java
FactorAnimator animator = new FactorAnimator(0, this,
    AnimatorUtils.DECELERATE_INTERPOLATOR, 300);
animator.animateTo(1.0f);
```

### UI Widgets

100+ ready-to-use components:
- `CircleButton` - Material-style circular buttons
- `MaterialEditText` - Enhanced text inputs
- `CheckView` - Animated checkboxes
- `ShadowView` - Material shadow effects
- `PopupLayout` - Modal popups and dialogs
- And many more...

## 🎯 Getting Started

### 1. Add ThunderKit to Your Project

Clone or copy the ThunderKit library into your project:

```bash
git clone /path/to/ThunderKit
```

In your `settings.gradle`:
```gradle
include ':thunderkit'
include ':thunderkit-vkryl'
project(':thunderkit').projectDir = new File('/path/to/ThunderKit/thunderkit')
project(':thunderkit-vkryl').projectDir = new File('/path/to/ThunderKit/thunderkit-vkryl')
```

In your app's `build.gradle`:
```gradle
dependencies {
    implementation project(':thunderkit')
}
```

### 2. Initialize in Your Activity

```java
public class MainActivity extends AppCompatActivity {
    private NavigationController navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create root layout
        RootFrameLayout root = new RootFrameLayout(this);
        setContentView(root);

        // Initialize navigation
        navigation = new NavigationController(this);
        navigation.initialize(root);

        // Push first screen
        navigation.push(new HomeViewController());
    }
}
```

### 3. Create Your First Screen

```java
public class HomeViewController extends ViewController<Void> {
    @Override
    protected View onCreateView(Context context) {
        LinearLayout root = new LinearLayout(context);
        root.setOrientation(LinearLayout.VERTICAL);

        // Add your UI components
        TextView title = new TextView(context);
        title.setText("Welcome to ThunderKit!");
        root.addView(title);

        return root;
    }

    @Override
    public CharSequence getTitle() {
        return "Home";
    }

    public void navigateToSettings() {
        navigationController.push(new SettingsViewController());
    }
}
```

## 📖 Features in Detail

### Stack-Based Navigation
- Push/pop screens with smooth animations
- Gesture swipe-back support
- Back button handling
- Screen lifecycle management (`onAttach`, `onDetach`, `onResume`, `onPause`)

### Header System
- Customizable headers with title, back button, menu
- Edit mode headers
- Complex headers with scroll interactions
- Stretchy/expandable headers
- Pager headers

### Drawer Navigation
- Side drawer with custom content
- Smooth slide animations
- Gesture support

### Theme Engine
- Multiple built-in themes
- Dynamic theme switching
- Type-safe color IDs
- Listener-based updates
- Material Design support

### Animation System
- **FactorAnimator** - Value-based (0.0 to 1.0) animations
- **BoolAnimator** - Boolean state animations
- **ListAnimator** - List/collection animations
- Custom interpolators
- Smooth 60fps performance

### Advanced UI Components
- Material Design widgets
- Custom drawables and effects
- Touch feedback and ripples
- Advanced text rendering
- Image handling
- Video playback widgets
- And much more...

## 🎨 Customization

### Custom Theme
Create your own theme by extending the theme system:
```java
public class MyCustomTheme extends ThemeDelegate {
    @Override
    public int getColor(@ColorId int colorId) {
        // Return your custom colors
    }
}
```

### Custom Widgets
Extend base widget classes:
```java
public class MyWidget extends BaseView {
    public MyWidget(Context context) {
        super(context);
        // Initialize your widget
    }
}
```

## 📊 What's Included

| Component | Files | Description |
|-----------|-------|-------------|
| **Navigation** | 62 | Complete navigation system |
| **Widgets** | 118 | UI components and views |
| **Theme** | 20 | Theming and styling |
| **Components** | 125 | Base component classes |
| **Tools** | 22 | Utility helpers |
| **Vkryl Utils** | 76 | Core Android utilities |
| **Total** | **423** | Production-ready files |

## 🔧 Requirements

- **Android SDK:** API 21+ (Android 5.0 Lollipop)
- **Java:** 11+
- **AndroidX:** Required
- **Gradle:** 8.0+

## 🎯 Use Cases

ThunderKit is perfect for:
- ✅ Apps requiring smooth, Telegram-like navigation
- ✅ Projects needing advanced theming capabilities
- ✅ Applications with complex UI requirements
- ✅ Apps requiring high performance animations
- ✅ Projects wanting production-tested components

## 📝 Notes

### Origin
ThunderKit is extracted from **Telegram-X**, a production messaging app used by millions. All components are battle-tested and optimized for performance.

### Telegram-Specific Dependencies
Some components may reference Telegram-specific classes (TdLib, TdApi). These references need to be:
- Removed if not needed
- Stubbed for compilation
- Replaced with your own implementations

See `EXTRACTION_GUIDE.md` for details on removing Telegram dependencies.

## 📚 Documentation

- **Architecture Analysis:** See `/ARCHITECTURE_ANALYSIS.md` in original repo
- **Visual Diagrams:** See `/ARCHITECTURE_VISUAL.md` in original repo
- **Extraction Guide:** See `/EXTRACTION_GUIDE.md` in original repo

## 🤝 Contributing

This is a local framework extraction. Contributions and improvements are welcome!

## 📄 License

This code is extracted from Telegram-X. Please refer to Telegram-X's original license for terms and conditions.

---

## 🚀 Quick Example

```java
// In your Activity
public class MyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RootFrameLayout root = new RootFrameLayout(this);
        setContentView(root);

        NavigationController nav = new NavigationController(this);
        nav.initialize(root);
        nav.push(new HomeViewController());
    }
}

// Your screen
public class HomeViewController extends ViewController<Void> {
    @Override
    protected View onCreateView(Context context) {
        TextView tv = new TextView(context);
        tv.setText("Hello ThunderKit!");
        return tv;
    }
}
```

**That's it! You now have a powerful UI framework at your disposal.** 🎉

---

**Built with ❤️ from Telegram-X**
