package com.myproject;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.thunderkit.navigation.NavigationController;
import com.thunderkit.widget.RootFrameLayout;

/**
 * Main Activity demonstrating ThunderKit framework usage
 */
public class MainActivity extends AppCompatActivity {
    private NavigationController navigationController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create root layout - this is the container for all UI
        RootFrameLayout rootLayout = new RootFrameLayout(this);
        setContentView(rootLayout);

        // Initialize navigation controller
        navigationController = new NavigationController(this);

        // Set up the navigation with root layout
        // Note: You may need to call additional initialization methods
        // depending on ThunderKit's requirements

        // Push the home screen
        navigationController.push(new HomeViewController());
    }

    @Override
    public void onBackPressed() {
        // Let navigation controller handle back press
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
