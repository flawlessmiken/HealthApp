package com.flawlessconcepts.healthapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ImageView image = (ImageView) findViewById(R.id.imageView);

        AlphaAnimation animation1 = new AlphaAnimation(0.0f, 1.0f);
        animation1.setDuration(1000);
        animation1.setStartOffset(500);
        animation1.setRepeatCount(1);
        animation1.setFillAfter(true);
        image.startAnimation(animation1);

        final Intent startAppProper = new Intent(SplashScreenActivity.this, MainActivity.class);

        new Timer().schedule(
                new TimerTask() {
                    @Override
                    public void run() {

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(startAppProper);
                                finish();
                            }
                        });
                    }
                },
                2600
        );
    }
}