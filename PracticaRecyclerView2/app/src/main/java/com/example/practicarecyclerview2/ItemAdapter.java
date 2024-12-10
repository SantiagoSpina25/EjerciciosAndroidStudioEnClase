package com.example.practicarecyclerview2;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>{
    private List<Campeon> listaCampeones;

    public ItemAdapter(List<Campeon> listaCampeones){
        this.listaCampeones = listaCampeones;
    }

    //Este metodo infla la vista
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(v);
    }

    //Este metodo le da los valores apropiados al item del viewholder que esta en pantalla segun su posicion
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String nombre = listaCampeones.get(position).getNombreCampeon();
        holder.txtArticulo.setText(nombre);

        int imagen = listaCampeones.get(position).getImagenCampeon();
        holder.imgvCampeon.setImageResource(imagen);

        String fecha = listaCampeones.get(position).getFechaMundial();
        holder.txtFecha.setText(fecha);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Para iniciar otra actividad voy a usar Intent
                Intent siguienteActivity = new Intent(view.getContext(), descripcionItem.class);

                siguienteActivity.putExtra("imagenCampeon", imagen);
                siguienteActivity.putExtra("nombreCampeon", nombre);
                siguienteActivity.putExtra("fechaMundial", fecha);
                view.getContext().startActivity(siguienteActivity);
            }
        });

    }

    //Este metodo recibe el numero de items
    @Override
    public int getItemCount() {
        return listaCampeones.size();
    }

    //Esta clase interna sirve para crear los elementos de cada item que luego seran modificados
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtArticulo;
        private ImageView imgvCampeon;
        private TextView txtFecha;

        public ViewHolder(@NonNull View v) {
            super(v);
            txtArticulo = v.findViewById(R.id.txtArticulo);
            imgvCampeon = v.findViewById(R.id.imgvCampeon);
            txtFecha = v.findViewById(R.id.txtFecha);
        }
    }
}
