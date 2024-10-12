package com.dansoryucompany.intent;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class
MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnYoutube = findViewById(R.id.btn_implicit_youtube);
        Button btnSMS = findViewById(R.id.btn_implicit_sms);
        Button btnSiia = findViewById(R.id.btn_implicit_siia);

        Button btnActivity1 = findViewById(R.id.btn_explicit_activity1);
        Button btnActivity2 = findViewById(R.id.btn_explicit_activity2);
        Button btnActivity3 = findViewById(R.id.btn_explicit_activity3);

        btnYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.youtube.com/@danlangley6465"));
                startActivity(intent);
            }
        });

        btnSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:1234567890")); // Número de teléfono falso
                intent.putExtra("sms_body", "Hola"); // Mensaje predefinido

                // Verificar si hay una aplicación que pueda manejar el intent
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    // Mensaje si no hay apps disponibles para enviar SMS
                    Toast.makeText(getApplicationContext(), "No hay aplicaciones de SMS instaladas", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSiia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://uttorreon.mx/"));
                startActivity(intent);
            }
        });

        btnActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity1.class);
                startActivity(intent);
            }
        });

        btnActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        btnActivity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(intent);
            }
        });
    }
}