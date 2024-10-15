package com.example.ej6_tableframe;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tv1,tv2,tv3,tv4,tv5,tv6,tvr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);
        tv6 = findViewById(R.id.tv6);
        tvr = findViewById(R.id.tvr);

        int tv1txt = Integer.parseInt(tv1.getText().toString());
        int tv2txt = Integer.parseInt(tv2.getText().toString());
        int tv3txt = Integer.parseInt(tv3.getText().toString());
        int tv4txt = Integer.parseInt(tv4.getText().toString());
        int tv5txt = Integer.parseInt(tv5.getText().toString());
        int tv6txt = Integer.parseInt(tv6.getText().toString());

        int promedio = (tv1txt + tv2txt + tv3txt + tv4txt + tv5txt + tv6txt) / 6;


        tvr.setText(String.valueOf(promedio));
    }
}