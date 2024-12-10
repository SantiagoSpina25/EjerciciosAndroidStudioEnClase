package com.example.primerproyectobd;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.tv1);
        btn1 = findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = " ";
                DbHelper dbHelper = new DbHelper(MainActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                dbHelper.insertar("Antonio", "9555", "antonio@gmail.com", db);
                dbHelper.insertar("Pepe", "5555", "pepe@gmail.com", db);

                if(dbHelper != null){
                    Toast.makeText(MainActivity.this,"Base de datos creada", Toast.LENGTH_SHORT).show();
                    Cursor cursor = db.rawQuery("SELECT * FROM t_contactos",null);

                    while(cursor.moveToNext()){
                        int id = cursor.getInt(0);
                        String name = cursor.getString(1);
                        String telefono = cursor.getString(2);
                        String email = cursor.getString(3);

                        texto = texto+"id: " + id + ", Name: " + name + "telefono:"+ telefono + ", Email: " + email;
                    }
                    tv1.setText(texto);
                    cursor.close();

                }else{
                    Toast.makeText(MainActivity.this,"Error al crear la base de datos", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
