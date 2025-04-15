package com.example.yathralkfinal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class IntroActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro1);

        ImageView logoImage = findViewById(R.id.logoImage);
        Animation popIn = AnimationUtils.loadAnimation(this, R.anim.pop_in);

        // Delay the animation slightly for better effect
        new Handler().postDelayed(() -> {
            logoImage.setVisibility(ImageView.VISIBLE);
            logoImage.startAnimation(popIn);
        }, 300);

        findViewById(R.id.nextButton).setOnClickListener(v -> {
            // Start intro2 activity with a slide animation
            startActivity(new Intent(IntroActivity1.this, IntroActivity2.class));
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            finish();
        });
    }
}