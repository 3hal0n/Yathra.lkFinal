package com.example.yathralkfinal;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public abstract class BaseActivity extends AppCompatActivity {
    protected void setupBottomNavigation() {
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
        bottomNav.setOnItemSelectedListener(item -> {
            Class<?> activityClass = getActivityClassForItem(item.getItemId());

            if (activityClass != null && !this.getClass().equals(activityClass)) {
                startActivity(new Intent(this, activityClass));
                overridePendingTransition(0, 0); // Remove default slide animation
                finish(); // Close current activity
                return true;
            }
            return false;
        });
    }

    private Class<?> getActivityClassForItem(int itemId) {
        if (itemId == R.id.navigation_home) return HomeActivity.class;
        if (itemId == R.id.navigation_profile) return ProfileActivity.class;
        if (itemId == R.id.navigation_explore) return ExploreActivity.class;
        return null;
    }

    protected void setSelectedItem(int itemId) {
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
        bottomNav.setSelectedItemId(itemId);
    }
}