package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        Intent intent = getIntent();

        // Obtener los valores individuales de los datos extras

        String mensaje = intent.getStringExtra("mensa");
        int Edad = intent.getIntExtra("edad",0);
        String Fecha = intent.getStringExtra("fecha");

        // Concatenar los valores para formar el mensaje completo
        String mensajeCompleto = "Hola, " + " " + mensaje + " " + "tu edad es:" + " " + Edad + " "
                + "Su fecha de nacimiento es: "+ Fecha ;

        TextView textView = findViewById(R.id.textViewA2);
        textView.setTextSize(24);
        textView.setText(mensajeCompleto);
    }


}