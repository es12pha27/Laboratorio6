package com.lab02.trabajaperu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private SharePreferenceHandler sharePreferenceHandler;
    EditText usuario_login;
    EditText pwd_login;
    boolean sesion=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharePreferenceHandler=new SharePreferenceHandler(this);
        sesion=getSesion();
        if(sesion){
            startActivity(new Intent(this,Inicio.class));
        }
        usuario_login=(EditText)findViewById(R.id.user);
        pwd_login=(EditText)findViewById(R.id.password);
    }
    public void iniciarSesion(View view){
        sesion=true;
        sharePreferenceHandler.saveValue("sesion",sesion);
        startActivity(new Intent(this,Inicio.class));
    }
    public boolean getSesion(){
        return sharePreferenceHandler.getValueBoolean("sesion");
    }
    public void registrarse(View view){
        startActivity(new Intent(this,Registro.class));
    }
    public void onPause(){
        super.onPause();
        deleteOrSave("usuario_login",usuario_login.getText().toString());
    }
    public void onResume(){
        super.onResume();
        usuario_login.setText(sharePreferenceHandler.getValue("usuario_login"));
    }
    public void deleteOrSave(String pwd,String value){
        if(!value.equalsIgnoreCase("")){
            sharePreferenceHandler.saveValue(pwd,value);
        }else{
            sharePreferenceHandler.deleteValue(pwd);
        }
    }
}