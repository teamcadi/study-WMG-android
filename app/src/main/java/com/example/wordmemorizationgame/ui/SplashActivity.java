package com.example.wordmemorizationgame.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.wordmemorizationgame.R;
import com.example.wordmemorizationgame.ui.auth.AuthActivity;
import com.example.wordmemorizationgame.ui.main.MainActivity;
import com.example.wordmemorizationgame.ui.user.UserActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        startSplash();
    }

    void startSplash() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //
                Intent intent = new Intent(getApplicationContext(),UserActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1500);
    }

    void isLogin() {
        // 로직
    }
}