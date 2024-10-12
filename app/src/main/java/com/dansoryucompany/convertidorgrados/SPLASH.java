package com.dansoryucompany.convertidorgrados;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SPLASH extends AppCompatActivity {

    private int countdownTime = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        startCountdown();
    }

    private void startCountdown() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (countdownTime > 0) {
                    countdownTime--;
                    handler.postDelayed(this, 1000);
                } else {
                    Intent intent = new Intent(SPLASH.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
