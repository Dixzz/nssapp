package com.test.nss;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class
MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int SPLASH_SCREEN_TIME_OUT = 2000;

        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences = getSharedPreferences("KEY", MODE_PRIVATE);

        new Handler().postDelayed(() -> {
            if (sharedPreferences.getInt("logged", 0) == 1) {
                Intent intent = new Intent(MainActivity.this, ediary.class);
                startActivity(intent);
            } else {
                Intent i = new Intent(MainActivity.this,
                        startActivity.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_SCREEN_TIME_OUT);
    }
}