package com.example.ej5_framelayout;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ImageView img1,img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
    }

    public void cambiarImagen(View view){

        if(img1.getVisibility() == View.INVISIBLE){
            img1.setVisibility(View.VISIBLE);
            img2.setVisibility(View.INVISIBLE);
        }else{
            img1.setVisibility(View.INVISIBLE);
            img2.setVisibility(View.VISIBLE);
        }


    }

}