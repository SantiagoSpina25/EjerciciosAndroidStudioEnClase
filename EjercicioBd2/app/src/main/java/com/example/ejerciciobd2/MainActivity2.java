package com.example.ejerciciobd2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    TextView tvDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvDatos = findViewById(R.id.tvDatos);
        DbHelper dbHelper = new DbHelper(MainActivity2.this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String texto = "";
        if(dbHelper != null){
            Cursor cursor = db.rawQuery("SELECT * FROM t_contactos",null);

            while(cursor.moveToNext()){
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String apellido = cursor.getString(2);
                String telefono = cursor.getString(3);
                String email = cursor.getString(4);
                String direccion = cursor.getString(5);

                texto = texto + "\n Id: " + id + "\n Nombre: " + name + "\n Apellido: " + apellido +"\n Telefono:"+ telefono + "\n Email: " + email + "\n Direccion: " + direccion + "\n \n";
            }
            tvDatos.setText(texto);
            cursor.close();

        }else{
            Toast.makeText(MainActivity2.this,"Error al mostrar la base de datos", Toast.LENGTH_SHORT).show();
        }



    }
}