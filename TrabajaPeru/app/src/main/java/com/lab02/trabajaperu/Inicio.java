package com.lab02.trabajaperu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Inicio extends AppCompatActivity {
    private SharePreferenceHandler sharePreferenceHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        sharePreferenceHandler=new SharePreferenceHandler(this);


    }
    public void cerrarSesionApp(View view){
        sharePreferenceHandler.deleteValue("sesion");
        startActivity(new Intent(this,MainActivity.class));
    }

}