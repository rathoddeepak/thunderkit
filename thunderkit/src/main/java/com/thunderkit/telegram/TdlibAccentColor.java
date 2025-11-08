package com.thunderkit.telegram;

/**
 * Stub for TdlibAccentColor - represents user accent colors.
 * Provides safe default colors for UI rendering.
 */
public class TdlibAccentColor {

    public int id;
    public int[] colors;

    public TdlibAccentColor() {
        this.id = 0;
        this.colors = new int[] { 0xFF2196F3 }; // Default blue
    }

    public TdlibAccentColor(int id, int[] colors) {
        this.id = id;
        this.colors = colors != null && colors.length > 0 ? colors : new int[] { 0xFF2196F3 };
    }

    public int getId() {
        return id;
    }

    public int[] getColors() {
        return colors;
    }

    public int getPrimaryColor() {
        return colors != null && colors.length > 0 ? colors[0] : 0xFF2196F3;
    }

    public int getSecondaryColor() {
        return colors != null && colors.length > 1 ? colors[1] : getPrimaryColor();
    }

    public int getTertiaryColor() {
        return colors != null && colors.length > 2 ? colors[2] : getPrimaryColor();
    }

    // Common accent colors as static instances
    public static final TdlibAccentColor RED = new TdlibAccentColor(0, new int[] { 0xFFE53935 });
    public static final TdlibAccentColor ORANGE = new TdlibAccentColor(1, new int[] { 0xFFFF9800 });
    public static final TdlibAccentColor YELLOW = new TdlibAccentColor(2, new int[] { 0xFFFDD835 });
    public static final TdlibAccentColor GREEN = new TdlibAccentColor(3, new int[] { 0xFF43A047 });
    public static final TdlibAccentColor CYAN = new TdlibAccentColor(4, new int[] { 0xFF00BCD4 });
    public static final TdlibAccentColor BLUE = new TdlibAccentColor(5, new int[] { 0xFF2196F3 });
    public static final TdlibAccentColor PURPLE = new TdlibAccentColor(6, new int[] { 0xFF9C27B0 });
    public static final TdlibAccentColor PINK = new TdlibAccentColor(7, new int[] { 0xFFE91E63 });

    public static TdlibAccentColor getDefault() {
        return BLUE;
    }

    public static TdlibAccentColor fromId(int id) {
        switch (id) {
            case 0: return RED;
            case 1: return ORANGE;
            case 2: return YELLOW;
            case 3: return GREEN;
            case 4: return CYAN;
            case 5: return BLUE;
            case 6: return PURPLE;
            case 7: return PINK;
            default: return BLUE;
        }
    }
}
