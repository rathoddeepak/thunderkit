# ThunderKit Quick Reference

A one-page reference for common ThunderKit operations.

## 🚀 Basic Setup

```java
// MainActivity
public class MainActivity extends AppCompatActivity {
    private NavigationController nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RootFrameLayout root = new RootFrameLayout(this);
        setContentView(root);

        nav = new NavigationController(this);
        nav.push(new HomeViewController());
    }

    @Override
    public void onBackPressed() {
        if (!nav.onBackPressed()) super.onBackPressed();
    }
}
```

## 📱 Create a Screen

```java
public class MyScreen extends ViewController<Void> {
    @Override
    protected View onCreateView(Context context) {
        // Build UI
        return view;
    }

    @Override
    public CharSequence getTitle() {
        return "My Screen";
    }
}
```

## 🧭 Navigation

```java
// Push screen
navigationController.push(new DetailScreen());

// Pop screen
navigationController.pop();

// Pop to root
navigationController.popToRoot();

// Replace current screen
navigationController.replace(new NewScreen());
```

## 🎨 Theme Colors

```java
// Get color
int color = Theme.getColor(ColorId.text_primary);

// Listen to theme changes
view.addThemeListener((themeId, theme) -> {
    invalidate();
});

// Change theme
ThemeManager.setCurrentTheme(ThemeId.CLASSIC);
```

## ✨ Animations

```java
public class AnimatedView extends BaseView
    implements FactorAnimator.Target {

    private FactorAnimator animator;

    public AnimatedView(Context context) {
        super(context);
        animator = new FactorAnimator(0, this,
            AnimatorUtils.DECELERATE_INTERPOLATOR, 300);
    }

    public void animate() {
        animator.animateTo(1.0f);
    }

    @Override
    public void onFactorChanged(int id, float factor,
                               float fraction, FactorAnimator callee) {
        setAlpha(factor);
        invalidate();
    }
}
```

## 🎯 Common Widgets

```java
// Circle Button
CircleButton btn = new CircleButton(context);
btn.init(R.drawable.ic_add, 56, 4f, ColorId.circleButtonPositive);

// Edit Text
MaterialEditText edit = new MaterialEditText(context);
edit.setHint("Enter text");

// Checkbox
CheckView check = new CheckView(context);
check.setChecked(true, animated);

// Popup
PopupLayout popup = new PopupLayout(context);
popup.setContentView(view);
popup.show();
```

## 📋 Lifecycle Methods

```java
@Override
protected void onAttach() {
    super.onAttach();
    // Screen attached - load data
}

@Override
protected void onDetach() {
    super.onDetach();
    // Screen detached - cleanup
}

@Override
protected void onResume() {
    super.onResume();
    // Screen visible
}

@Override
protected void onPause() {
    super.onPause();
    // Screen hidden
}
```

## 🎨 Custom View

```java
public class MyView extends BaseView {
    public MyView(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int w, int h) {
        super.onMeasure(w, h);
        // Measure
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // Draw
    }
}
```

## 🔄 Passing Data

```java
// Define data class
public class UserData {
    int id;
    String name;
}

// ViewController with data
public class ProfileScreen extends ViewController<UserData> {
    private UserData data;

    @Override
    public void setArguments(UserData args) {
        super.setArguments(args);
        this.data = args;
    }
}

// Navigate with data
UserData user = new UserData();
ProfileScreen screen = new ProfileScreen();
screen.setArguments(user);
navigationController.push(screen);
```

## 🎯 Header Customization

```java
@Override
protected void onCreateHeaderButtons(HeaderView header) {
    HeaderButton btn = new HeaderButton(context());
    btn.setIcon(R.drawable.ic_menu);
    btn.setOnClickListener(v -> showMenu());
    header.addButton(btn);
}
```

## 📦 Gradle Setup

```gradle
// settings.gradle
include ':thunderkit'
include ':thunderkit-vkryl'

// app/build.gradle
dependencies {
    implementation project(':thunderkit')
}
```

## 🔧 Common Utilities

```java
// UI thread
UI.post(() -> { /* code */ });

// DP to PX
int px = Screen.dp(48);

// Find ancestor view
MyView parent = Views.findAncestor(child, MyView.class);
```

## ⚡ Performance Tips

```java
// 1. Use hardware acceleration
setLayerType(LAYER_TYPE_HARDWARE, null);

// 2. Minimize onDraw allocations
// Bad: new Paint() in onDraw
// Good: Reuse paint object

// 3. Clean up in onDetach
@Override
protected void onDetach() {
    super.onDetach();
    removeListeners();
    cancelAnimations();
}

// 4. Use FactorAnimator for smooth animations
// Not ValueAnimator with manual updates
```

## 🐛 Debugging

```java
// Check if attached
if (isAttached()) {
    // Safe to update UI
}

// Check navigation controller
if (navigationController != null) {
    navigationController.push(...);
}

// Log lifecycle
@Override
protected void onAttach() {
    super.onAttach();
    Log.d("MyScreen", "onAttach");
}
```

## 📚 More Info

- **Detailed Guide:** `USAGE_GUIDE.md`
- **Full Documentation:** `README.md`
- **Examples:** `/sample/` directory
- **Summary:** `PROJECT_SUMMARY.md`

---

**ThunderKit** - Professional Android UI Framework

Location: `/Users/zoop/dev/abeya/ThunderKit/`
