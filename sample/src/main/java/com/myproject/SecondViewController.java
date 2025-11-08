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
 * Second screen demonstrating navigation
 */
public class SecondViewController extends ViewController<Void> {

    @Override
    protected View onCreateView(Context context) {
        LinearLayout root = new LinearLayout(context);
        root.setLayoutParams(new ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        ));
        root.setOrientation(LinearLayout.VERTICAL);
        root.setGravity(Gravity.CENTER);
        root.setPadding(48, 48, 48, 48);
        root.setBackgroundColor(Color.parseColor("#F5F5F5"));

        // Title
        TextView title = new TextView(context);
        title.setText("Second Screen");
        title.setTextSize(28);
        title.setTextColor(Color.BLACK);
        title.setGravity(Gravity.CENTER);
        root.addView(title);

        // Description
        TextView description = new TextView(context);
        description.setText("\n\nYou've successfully navigated!\n\n" +
            "ThunderKit handles:\n" +
            "• Screen transitions\n" +
            "• Back navigation\n" +
            "• Lifecycle management\n" +
            "• Gesture support");
        description.setTextSize(16);
        description.setTextColor(Color.DKGRAY);
        description.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams descParams = new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        );
        descParams.topMargin = 24;
        description.setLayoutParams(descParams);
        root.addView(description);

        // Go back button
        Button backButton = new Button(context);
        backButton.setText("Go Back");
        backButton.setOnClickListener(v -> {
            // Pop this screen off the navigation stack
            navigationController.pop();
        });
        LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        );
        buttonParams.topMargin = 48;
        backButton.setLayoutParams(buttonParams);
        root.addView(backButton);

        return root;
    }

    @Override
    public CharSequence getTitle() {
        return "Second Screen";
    }

    @Override
    protected void onAttach() {
        super.onAttach();
        // Initialize this screen
    }

    @Override
    protected void onDetach() {
        super.onDetach();
        // Clean up this screen
    }
}
