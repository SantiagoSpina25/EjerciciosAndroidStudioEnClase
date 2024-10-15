package com.example.riesgoperiodontal_santiagospina;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText etEdad, etSangrado, etAusDientes, etPerdInsercion, etDiabetes, etTabaco, etProfBolsa;
    TextView tvSangrado, tvAusDientes, tvPerdInsercion, tvDiabetes, tvTabaco, tvProfBolsa, tvResultadoFinal;
    int numValorFinal=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEdad = findViewById(R.id.etEdad);
        etSangrado = findViewById(R.id.etSangrado);
        tvSangrado = findViewById(R.id.tvSangrado);
        etAusDientes = findViewById(R.id.etAusDientes);
        tvAusDientes = findViewById(R.id.tvAusDientes);
        etPerdInsercion = findViewById(R.id.etPerdInsercion);
        tvPerdInsercion = findViewById(R.id.tvPerdInsercion);
        etDiabetes = findViewById(R.id.etDiabetes);
        tvDiabetes = findViewById(R.id.tvDiabetes);
        etTabaco = findViewById(R.id.etTabaco);
        tvTabaco = findViewById(R.id.tvTabaco);
        etProfBolsa = findViewById(R.id.etProfBolsa);
        tvProfBolsa = findViewById(R.id.tvProfBolsa);

        tvResultadoFinal = findViewById(R.id.tvResultadoFinal);
    }

    public void btnSangrado(View view){
        String txtoDientesSangrados = etSangrado.getText().toString();
        int dientesSangrados = Integer.parseInt(txtoDientesSangrados);
        String riesgo="";

        if(dientesSangrados == 0){
            riesgo="No hay riesgo";
        }else if(dientesSangrados > 0 && dientesSangrados < 10){
            riesgo="Riesgo bajo";
            numValorFinal+=1;
        }
        else if(dientesSangrados > 10 && dientesSangrados < 26){
            riesgo="Riesgo Moderado";
            numValorFinal+=2;
        }else{
            riesgo="Riesgo Alto";
            numValorFinal+=3;
        }
        tvSangrado.setVisibility(View.VISIBLE);
        tvSangrado.setText(riesgo);
    }

    public void btnAusDientes(View view){
        String txtDientesAus = etAusDientes.getText().toString();
        int numAusDientes = Integer.parseInt(txtDientesAus);
        String riesgo="";

        if(numAusDientes == 0){
            riesgo="No hay riesgo";
        }else if(numAusDientes <= 4 ){
            riesgo="Riesgo bajo";
            numValorFinal+=1;
        }
        else if(numAusDientes <= 8){
            riesgo="Riesgo Moderado";
            numValorFinal+=2;
        }else{
            riesgo="Riesgo Alto";
            numValorFinal+=3;
        }
        tvAusDientes.setVisibility(View.VISIBLE);
        tvAusDientes.setText(riesgo);
    }

    public void btnPerdInsercion(View view){
        String edad = etEdad.getText().toString();
        int numEdad = Integer.parseInt(edad);

        String txtPerdInsercion = etPerdInsercion.getText().toString();
        int numPerdInsercion = Integer.parseInt(txtPerdInsercion);

        double calculo = (double) numPerdInsercion / numEdad;

        String riesgo="";

        if(calculo == 0){
            riesgo="No hay riesgo";
        }else if(calculo > 0 && calculo < 0.5 ){
            riesgo="Riesgo bajo";
            numValorFinal+=1;
        }
        else if(calculo > 0.5 && calculo < 1 ){
            riesgo="Riesgo Moderado";
            numValorFinal+=2;
        }else{
            riesgo="Riesgo Alto";
            numValorFinal+=3;
        }
        tvPerdInsercion.setVisibility(View.VISIBLE);
        tvPerdInsercion.setText(riesgo);
    }

    public void btnDiabetes(View view){
        String txtDiabetes = etDiabetes.getText().toString();

        String riesgo="";

        if(txtDiabetes.equalsIgnoreCase("no")){
            riesgo="No hay riesgo";
            numValorFinal+=0;
        }else if(txtDiabetes.equalsIgnoreCase("si")){
            riesgo="Riesgo Alto";
            numValorFinal+=3;
        }
        else{
            riesgo="Valor mal introducido";
        }
        tvDiabetes.setVisibility(View.VISIBLE);
        tvDiabetes.setText(riesgo);
    }

    public void btnTabaco(View view){
        String txtTabaco = etTabaco.getText().toString();
        int numTabaco = Integer.parseInt(txtTabaco);
        String riesgo="";

        if(numTabaco == 1){
            riesgo="No hay riesgo";
            numValorFinal+=0;
        }else if(numTabaco == 2){
            riesgo="Riesgo Alto";
            numValorFinal+=3;
        }
        else{
            riesgo="Riesgo moderado";
        }
        tvTabaco.setVisibility(View.VISIBLE);
        tvTabaco.setText(riesgo);
    }

    public void btnProfBolsa(View view){
        String txtProfBolsa = etProfBolsa.getText().toString();
        int numProfBolsa = Integer.parseInt(txtProfBolsa);
        String riesgo="";

        if(numProfBolsa == 0){
            riesgo="No hay riesgo";
        }else if(numProfBolsa < 5){
            riesgo="Riesgo bajo";
            numValorFinal+=1;
        }
        else if(numProfBolsa > 4 && numProfBolsa < 9 ){
            riesgo="Riesgo moderado";
            numValorFinal+=2;
        }
        else{
            riesgo="Riesgo alto";
            numValorFinal+=3;
        }
        tvProfBolsa.setVisibility(View.VISIBLE);
        tvProfBolsa.setText(riesgo);
    }

    public void btnCalcular(View view){
        String txtFinal = "";
        double calculo = numValorFinal / 6;

        if(calculo == 0){
            txtFinal="No hay riesgo. El riesgo total fue de: " + calculo;
        }else if(calculo <= 1){
            txtFinal="Riesgo bajo. El riesgo total fue de: " + calculo;
        }
        else if(calculo <= 2){
            txtFinal="Riesgo moderado. El riesgo total fue de: " + calculo;
        }
        else if(calculo <= 3){
            txtFinal="Riesgo alto. El riesgo total fue de: " + calculo;
        }
        tvResultadoFinal.setVisibility(View.VISIBLE);
        tvResultadoFinal.setText(txtFinal);
    }

}