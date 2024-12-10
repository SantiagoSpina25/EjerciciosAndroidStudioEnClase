package com.example.practicaintents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnGoogle, btnMaps, btnTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGoogle = findViewById(R.id.btnGoogle);
        btnMaps = findViewById(R.id.btnMaps);
        btnTelefono = findViewById(R.id.btnTelefono);

        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"));
                startActivity(intentWeb);
            }
        });

        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMaps = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:36.693201, -4.458223"));
                startActivity(intentMaps);
            }
        });

        btnTelefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentTelefono = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:656357895"));
                startActivity(intentTelefono);
            }
        });

    }


}