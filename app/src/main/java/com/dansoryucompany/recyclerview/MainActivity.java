package com.dansoryucompany.recyclerview;

import android.graphics.Color;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dansoryucompany.recyclerview.adapters.TortugaAdapter;
import com.dansoryucompany.recyclerview.models.Tortuga;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclertortuga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclertortuga=findViewById(R.id.recyclertortuga);

        List<Tortuga> tortugas = new ArrayList<>();

        tortugas.add(new Tortuga("Leonardo", "es azul el papu", "katana", "blue"));
        tortugas.add(new Tortuga("Leonardo", "es azul el papu", "katana", "blue"));
        tortugas.add(new Tortuga("Leonardo", "es azul el papu", "katana", "blue"));
        tortugas.add(new Tortuga("Leonardo", "es azul el papu", "katana", "blue"));

        TortugaAdapter adapter = new TortugaAdapter(tortugas);
        recyclertortuga.setAdapter(adapter);
        recyclertortuga.setHasFixedSize(true);
        recyclertortuga.setLayoutManager(new LinearLayoutManager(getApplicationContext()));s
    }
}