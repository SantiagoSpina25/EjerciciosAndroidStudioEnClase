package com.example.ejerciciobd2;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnInsertar, btnMostrar;
    EditText et1, et2, et3,et4,et5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsertar = findViewById(R.id.btnInsertar);
        btnMostrar = findViewById(R.id.btnMostrar);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        et4 = findViewById(R.id.et4);
        et5 = findViewById(R.id.et5);

        DbHelper dbHelper = new DbHelper(MainActivity.this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();


        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = et1.getText().toString();
                String apellidos = et1.getText().toString();
                String telefono = et1.getText().toString();
                String email = et1.getText().toString();
                String direccion = et1.getText().toString();

                dbHelper.insertar(nombre,apellidos,telefono,email,direccion,db);
                Toast.makeText(MainActivity.this,"Insertado correctamente", Toast.LENGTH_SHORT).show();
            }
        });

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}