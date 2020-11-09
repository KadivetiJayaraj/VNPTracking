package com.dev.vnptracking.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.dev.vnptracking.R;
import com.dev.vnptracking.authentication.WelcomeActivity;

public class SplashActivity extends AppCompatActivity {

    private static final long SPALSH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                    Intent intent=new Intent(SplashActivity.this, WelcomeActivity.class);
                    startActivity(intent);
            }
        },SPALSH_TIME_OUT);
    }
}
