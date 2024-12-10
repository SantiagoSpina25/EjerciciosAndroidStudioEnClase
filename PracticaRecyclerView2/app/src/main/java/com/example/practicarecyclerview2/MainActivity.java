package com.example.practicarecyclerview2;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obtengo los datos de tipo Campeon de la clase ListaCampeones
        ListaCampeones listaCampeones = new ListaCampeones();
        ArrayList<Campeon> datos = listaCampeones.getCampeones();

        recyclerView = findViewById(R.id.recyclerView);

        //Indico como se mostraran los items, en este caso de forma lineal (vertical)
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Le doy el adaptador ItemAdapter al recycler view
        recyclerView.setAdapter(new ItemAdapter(datos));

        int resId = R.anim.layout_animation_fall_down;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(recyclerView.getContext(), resId);
        recyclerView.setLayoutAnimation(animation);
    }
}