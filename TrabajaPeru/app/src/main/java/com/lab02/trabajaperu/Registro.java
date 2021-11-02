package com.lab02.trabajaperu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Registro extends AppCompatActivity {
    private SharePreferenceHandler sharePreferenceHandler;
    private EditText n_emp;
    private EditText encargado;
    private EditText ubicacion;
    private EditText correo;
    private EditText telefono;
    private EditText RUC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        sharePreferenceHandler=new SharePreferenceHandler(this);
        n_emp = (EditText) findViewById(R.id.n_emp);
        encargado = (EditText) findViewById(R.id.encargado);
        ubicacion = (EditText) findViewById(R.id.ubicacion);
        correo = (EditText) findViewById(R.id.email);
        telefono = (EditText) findViewById(R.id.telefono);
        RUC = (EditText) findViewById(R.id.ruc);

    }
    public void guardar(View view){
        startActivity(new Intent(this,MainActivity.class));
    }
    public void onPause(){
        super.onPause();
        deleteOrSave("n_emp",n_emp.getText().toString());
        deleteOrSave("encargado",encargado.getText().toString());
        deleteOrSave("ubicacion",ubicacion.getText().toString());
        deleteOrSave("correo",correo.getText().toString());
        deleteOrSave("telefono",telefono.getText().toString());
        deleteOrSave("ruc",RUC.getText().toString());
    }
    public void onResume(){
        super.onResume();
        n_emp.setText(sharePreferenceHandler.getValue("n_emp"));
        encargado.setText(sharePreferenceHandler.getValue("encargado"));
        ubicacion.setText(sharePreferenceHandler.getValue("ubicacion"));
        correo.setText(sharePreferenceHandler.getValue("correo"));
        telefono.setText(sharePreferenceHandler.getValue("telefono"));
        RUC.setText(sharePreferenceHandler.getValue("ruc"));
    }
    public void deleteOrSave(String pwd,String value){
        if(!value.equalsIgnoreCase("")){
            sharePreferenceHandler.saveValue(pwd,value);
        }else{
            sharePreferenceHandler.deleteValue(pwd);
        }
    }

}