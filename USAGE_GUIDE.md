# ThunderKit Usage Guide

A comprehensive guide to using the ThunderKit framework in your Android projects.

## Table of Contents

1. [Getting Started](#getting-started)
2. [Basic Navigation](#basic-navigation)
3. [Advanced Navigation](#advanced-navigation)
4. [Theme System](#theme-system)
5. [Animations](#animations)
6. [UI Components](#ui-components)
7. [Best Practices](#best-practices)
8. [Troubleshooting](#troubleshooting)

---

## Getting Started

### Project Setup

1. **Add ThunderKit to your project:**

```gradle
// settings.gradle
include ':thunderkit'
include ':thunderkit-vkryl'

// app/build.gradle
dependencies {
    implementation project(':thunderkit')
}
```

2. **Initialize in your Application class (optional but recommended):**

```java
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // Initialize ThunderKit utilities
        // Configure theme, locale, etc.
    }
}
```

3. **Set up your MainActivity:**

```java
public class MainActivity extends AppCompatActivity {
    private NavigationController navigationController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create root layout
        RootFrameLayout rootLayout = new RootFrameLayout(this);
        setContentView(rootLayout);

        // Initialize navigation
        navigationController = new NavigationController(this);
        // TODO: Call proper initialization methods as needed

        // Push initial screen
        navigationController.push(new HomeViewController());
    }

    @Override
    public void onBackPressed() {
        if (navigationController != null && !navigationController.onBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (navigationController != null) {
            navigationController.destroy();
        }
    }
}
```

---

## Basic Navigation

### Creating a ViewController

ViewControllers are the building blocks of ThunderKit navigation:

```java
public class MyViewController extends ViewController<Void> {

    @Override
    protected View onCreateView(Context context) {
        // Build your UI here
        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);

        // Add views...

        return layout;
    }

    @Override
    public CharSequence getTitle() {
        return "My Screen";
    }

    @Override
    protected void onAttach() {
        super.onAttach();
        // Called when screen becomes active
        // Initialize data, start animations, etc.
    }

    @Override
    protected void onDetach() {
        super.onDetach();
        // Called when screen is removed from stack
        // Clean up resources, stop animations, etc.
    }
}
```

### Navigation Operations

```java
// Push a new screen
navigationController.push(new DetailViewController());

// Pop current screen
navigationController.pop();

// Pop to a specific screen
navigationController.popTo(homeViewController);

// Pop to root
navigationController.popToRoot();

// Replace current screen
navigationController.replace(new NewViewController());
```

### ViewController with Arguments

Use the generic type parameter to pass data:

```java
public class DetailViewController extends ViewController<DetailData> {
    private DetailData data;

    @Override
    public void setArguments(DetailData args) {
        super.setArguments(args);
        this.data = args;
    }

    @Override
    protected View onCreateView(Context context) {
        TextView tv = new TextView(context);
        tv.setText("ID: " + data.getId());
        return tv;
    }
}

// Usage:
DetailData data = new DetailData(123);
DetailViewController vc = new DetailViewController();
vc.setArguments(data);
navigationController.push(vc);
```

---

## Advanced Navigation

### Custom Headers

```java
@Override
protected HeaderView onCreateHeaderView() {
    HeaderView header = new HeaderView(context());
    header.setTitle(getTitle());
    return header;
}

@Override
protected void onCreateHeaderButtons(HeaderView headerView) {
    // Add custom header buttons
    HeaderButton button = new HeaderButton(context());
    button.setIcon(R.drawable.ic_settings);
    button.setOnClickListener(v -> openSettings());
    headerView.addButton(button);
}
```

### Drawer Navigation

```java
// Create drawer controller
DrawerController drawer = new DrawerController(context);

// Set drawer content
drawer.setDrawerContent(new MyDrawerContentView(context));

// Open/close drawer
drawer.openDrawer();
drawer.closeDrawer();
```

### Modal Presentations

```java
// Show as popup/modal
PopupLayout popup = new PopupLayout(context);
popup.setContentView(myCustomView);
popup.show();

// Dismiss
popup.dismiss();
```

### Navigation Listeners

```java
navigationController.addStackStateListener(new NavigationController.StackStateListener() {
    @Override
    public void onStackChanged(NavigationController controller, ViewController<?> current) {
        // React to navigation changes
    }
});
```

---

## Theme System

### Using Themes

ThunderKit supports dynamic theming:

```java
// Set theme
ThemeManager.setCurrentTheme(ThemeId.CLASSIC);

// Get current theme
int currentTheme = ThemeManager.getCurrentTheme();

// Listen to theme changes
view.addThemeListener(new ThemeChangeListener() {
    @Override
    public void onThemeChanged(int themeId, ThemeDelegate theme) {
        // Update your UI
        updateColors();
        invalidate();
    }
});
```

### Using Colors

```java
// Get theme colors
int textColor = Theme.getColor(ColorId.text_primary);
int backgroundColor = Theme.getColor(ColorId.background);

// Get themed drawables
Drawable ripple = Theme.getRippleDrawable(ColorId.text_primary);
Drawable selector = Theme.getSelector(ColorId.background);
```

### Custom Theme Implementation

```java
public class MyCustomTheme implements ThemeDelegate {
    @Override
    public int getColor(@ColorId int colorId) {
        switch (colorId) {
            case ColorId.text_primary:
                return Color.BLACK;
            case ColorId.background:
                return Color.WHITE;
            // ... more colors
        }
        return 0;
    }

    @Override
    public int getId() {
        return ThemeId.CUSTOM;
    }
}

// Register and use
ThemeManager.registerTheme(new MyCustomTheme());
ThemeManager.setCurrentTheme(ThemeId.CUSTOM);
```

---

## Animations

### FactorAnimator

The core animation system:

```java
public class MyAnimatedView extends BaseView implements FactorAnimator.Target {
    private static final int ANIMATOR_EXPAND = 0;
    private FactorAnimator expandAnimator;
    private float expandFactor;

    public MyAnimatedView(Context context) {
        super(context);
        expandAnimator = new FactorAnimator(
            ANIMATOR_EXPAND,
            this,
            AnimatorUtils.DECELERATE_INTERPOLATOR,
            300  // duration in ms
        );
    }

    public void expand() {
        expandAnimator.animateTo(1.0f);
    }

    public void collapse() {
        expandAnimator.animateTo(0.0f);
    }

    @Override
    public void onFactorChanged(int id, float factor, float fraction, FactorAnimator callee) {
        if (id == ANIMATOR_EXPAND) {
            this.expandFactor = factor;
            invalidate();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // Use expandFactor (0.0 to 1.0) to animate your view
        float scale = 0.5f + (expandFactor * 0.5f);
        canvas.scale(scale, scale, getWidth() / 2f, getHeight() / 2f);
        // ... draw content
    }
}
```

### BoolAnimator

For boolean state animations:

```java
private BoolAnimator visibilityAnimator;

public MyView(Context context) {
    super(context);
    visibilityAnimator = new BoolAnimator(0, this,
        AnimatorUtils.DECELERATE_INTERPOLATOR, 200);
}

public void show() {
    visibilityAnimator.setValue(true, true);  // animated
}

public void hide() {
    visibilityAnimator.setValue(false, true);
}

@Override
public void onFactorChanged(int id, float factor, float fraction, FactorAnimator callee) {
    setAlpha(factor);
}
```

### ListAnimator

For animating lists of items:

```java
ListAnimator<MyItem> listAnimator = new ListAnimator<>(
    (item, set, isRemoval, position) -> {
        // Animate item addition/removal
    },
    (item) -> item.getId()  // Unique ID provider
);

// Update list with animation
listAnimator.measure(newList, false);
```

---

## UI Components

### Common Widgets

#### CircleButton

```java
CircleButton button = new CircleButton(context);
button.init(R.drawable.ic_add, 56, 4f, ColorId.circleButtonPositive);
button.setOnClickListener(v -> doAction());
```

#### MaterialEditText

```java
MaterialEditText editText = new MaterialEditText(context);
editText.setHint("Enter text...");
editText.addTextChangedListener(new SimpleTextWatcher() {
    @Override
    public void onTextChanged(String text) {
        // Handle text changes
    }
});
```

#### CheckView

```java
CheckView checkView = new CheckView(context);
checkView.setChecked(true, animated);
checkView.setOnClickListener(v -> {
    boolean isChecked = checkView.toggle(true);
    // Handle state change
});
```

#### ShadowView

```java
ShadowView shadowView = new ShadowView(context);
shadowView.setSimpleTopShadow(true);
// Add shadow to layouts
```

### Custom Views

Extend `BaseView` for custom widgets:

```java
public class MyCustomWidget extends BaseView {
    public MyCustomWidget(Context context) {
        super(context);
        // Initialize
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // Custom measurement
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // Custom drawing
    }
}
```

---

## Best Practices

### 1. Memory Management

```java
@Override
protected void onDetach() {
    super.onDetach();
    // Clean up listeners
    if (myListener != null) {
        removeListener(myListener);
        myListener = null;
    }
    // Cancel animations
    if (animator != null) {
        animator.cancel();
    }
    // Clear large objects
    bitmap = null;
}
```

### 2. Lifecycle Handling

```java
@Override
protected void onAttach() {
    super.onAttach();
    // Start loading data
    loadData();
}

@Override
protected void onResume() {
    super.onResume();
    // Resume animations, refresh data
}

@Override
protected void onPause() {
    super.onPause();
    // Pause animations, save state
}
```

### 3. Efficient UI Updates

```java
// Use invalidate() for redrawing
private void updateUI() {
    if (isAttached()) {
        invalidate();
    }
}

// Use requestLayout() when dimensions change
private void updateSize() {
    if (isAttached()) {
        requestLayout();
    }
}
```

### 4. Theme Awareness

```java
public class ThemedView extends BaseView implements ThemeChangeListener {
    public ThemedView(Context context) {
        super(context);
        addThemeListener(this);
    }

    @Override
    public void onThemeChanged(int themeId, ThemeDelegate theme) {
        // Refresh colors
        invalidate();
    }

    @Override
    protected void onDetach() {
        super.onDetach();
        removeThemeListener(this);
    }
}
```

### 5. Smooth Animations

```java
// Always use FactorAnimator for smooth animations
private void animateChange() {
    // Bad: ValueAnimator with manual updates
    // Good: FactorAnimator
    animator.animateTo(targetValue);
}
```

---

## Troubleshooting

### Common Issues

#### 1. Navigation not working

**Problem:** NavigationController not responding
```java
// Solution: Ensure proper initialization
navigationController = new NavigationController(this);
// Call all required initialization methods
```

#### 2. Theme colors not applying

**Problem:** Colors not updating
```java
// Solution: Ensure ThemeManager is initialized
ThemeManager.setCurrentTheme(ThemeId.CLASSIC);

// And views implement theme listeners
addThemeListener(this);
```

#### 3. Animations stuttering

**Problem:** Choppy animations
```java
// Solution: Use hardware acceleration
setLayerType(LAYER_TYPE_HARDWARE, null);

// And optimize onDraw
@Override
protected void onDraw(Canvas canvas) {
    // Minimize allocations in onDraw
    // Reuse objects when possible
}
```

#### 4. Memory leaks

**Problem:** Memory not released
```java
// Solution: Clean up in onDetach
@Override
protected void onDetach() {
    super.onDetach();
    removeAllListeners();
    cancelAnimations();
    clearReferences();
}
```

#### 5. Back button not working

**Problem:** Back press not handled
```java
// Solution: Implement in Activity
@Override
public void onBackPressed() {
    if (!navigationController.onBackPressed()) {
        super.onBackPressed();
    }
}
```

### Build Errors

#### Missing dependencies

If you see import errors for Telegram-specific classes:
1. Remove those imports
2. Replace with framework-specific alternatives
3. Or stub the missing classes

#### Package conflicts

If package names conflict:
```bash
# Update all references
find . -name "*.java" -exec sed -i '' 's/old.package/new.package/g' {} \;
```

---

## Additional Resources

- **README.md** - Framework overview
- **Sample App** - `/sample/` directory
- **Source Code** - Well-documented classes in `/thunderkit/`

---

## Support

For issues or questions:
1. Check this guide
2. Review the sample app
3. Examine the source code comments
4. Refer to the original Telegram-X implementation

---

**Happy coding with ThunderKit!** 🚀
