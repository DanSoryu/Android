package com.dansoryucompany.countdowntimer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SPLASH extends AppCompatActivity {

    private int countdownTime = 5;
    private Button countdownButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        countdownButton = findViewById(R.id.btn);

        startCountdown();
    }

    private void startCountdown() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (countdownTime > 0) {
                    countdownButton.setText("Contador: " + countdownTime);
                    countdownTime--;
                    handler.postDelayed(this, 1000);
                } else {
                    // Cambia a MainActivity cuando termine la cuenta regresiva
                    Intent intent = new Intent(SPLASH.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
