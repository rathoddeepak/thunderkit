package com.myproject;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.thunderkit.navigation.ViewController;

/**
 * Home screen demonstrating basic ThunderKit ViewController usage
 */
public class HomeViewController extends ViewController<Void> {

    @Override
    protected View onCreateView(Context context) {
        // Create root container
        LinearLayout root = new LinearLayout(context);
        root.setLayoutParams(new ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        ));
        root.setOrientation(LinearLayout.VERTICAL);
        root.setGravity(Gravity.CENTER);
        root.setPadding(48, 48, 48, 48);
        root.setBackgroundColor(Color.WHITE);

        // Welcome title
        TextView title = new TextView(context);
        title.setText("Welcome to ThunderKit!");
        title.setTextSize(24);
        title.setTextColor(Color.BLACK);
        title.setGravity(Gravity.CENTER);
        root.addView(title);

        // Description
        TextView description = new TextView(context);
        description.setText("\nA powerful UI framework extracted from Telegram-X\n\n" +
            "Features:\n" +
            "• Advanced Navigation\n" +
            "• Smooth Animations\n" +
            "• Dynamic Theming\n" +
            "• 100+ UI Components");
        description.setTextSize(16);
        description.setTextColor(Color.DKGRAY);
        description.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams descParams = new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        );
        descParams.topMargin = 32;
        description.setLayoutParams(descParams);
        root.addView(description);

        // Navigate to second screen button
        Button navigateButton = new Button(context);
        navigateButton.setText("Open Second Screen");
        navigateButton.setOnClickListener(v -> {
            // Navigate to another screen
            navigationController.push(new SecondViewController());
        });
        LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        );
        buttonParams.topMargin = 48;
        navigateButton.setLayoutParams(buttonParams);
        root.addView(navigateButton);

        return root;
    }

    @Override
    public CharSequence getTitle() {
        return "ThunderKit Demo";
    }

    @Override
    protected void onAttach() {
        super.onAttach();
        // Called when the view controller is attached to the navigation stack
        // Initialize data, start animations, etc.
    }

    @Override
    protected void onDetach() {
        super.onDetach();
        // Called when the view controller is detached from the navigation stack
        // Clean up resources, stop animations, etc.
    }
}
