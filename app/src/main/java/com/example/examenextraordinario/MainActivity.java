package com.example.examenextraordinario;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final int PERMISO_SMS = 1000;
    private final int LAUNCH_GETNUMBER_TOP = 1;

    private EditText txtNumero;
    private Button btnEsPrimo, btnListado, btnSos;

    private final FragmentManager fragmentManager = getSupportFragmentManager();
    private final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    private final FragmentoHora fragmento = new FragmentoHora();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNumero = findViewById(R.id.txtNumero);


        Intent i = new Intent(this, Actividad1.class);
        btnEsPrimo = findViewById(R.id.btnEsPrimo);
        btnEsPrimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtNumero.getText().toString().startsWith("-") ||
                        txtNumero.getText().toString().contains(",") ||
                        txtNumero.getText().toString().contains("'")){
                    Toast.makeText(getApplicationContext(), "Por favor introduce un numero entero positivo", Toast.LENGTH_LONG).show();
                }else if(Integer.parseInt(txtNumero.getText().toString()) > 0) {
                    if(calcularPrimo(Integer.parseInt(txtNumero.getText().toString()))){
                        i.putExtra("Numero" , "El numero: " + txtNumero.getText().toString() + " es primo");
                        startActivityForResult(i, LAUNCH_GETNUMBER_TOP);
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "No es un numero primo...", Toast.LENGTH_LONG).show();
                }
            }
        });



        Intent iListado = new Intent(this, Actividad2.class);
        btnListado = findViewById(R.id.btnListado);
        btnListado.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(iListado);
            }
        });


        fragmentTransaction.add(R.id.idFragmentoContainer, fragmento).commit();



        btnSos = findViewById(R.id.btnSOS);
        btnSos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.SEND_SMS},PERMISO_SMS);
                }else{
                    enviarMensaje();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == LAUNCH_GETNUMBER_TOP) {
            if (resultCode == Activity.RESULT_OK) {
                String result = data.getStringExtra("numero");
                txtNumero.setText(result);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                txtNumero.setText("Error");
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISO_SMS: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    enviarMensaje();
                } else {
                    Toast.makeText(getApplicationContext(), "No tiene permisos de SMS", Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
    }

    public void enviarMensaje(){
        Intent iMensaje = new Intent(Intent.ACTION_SENDTO);
        iMensaje.setData(Uri.parse("smsto:123456789"));
        iMensaje.putExtra("sms_body", "Save Our Ship");
        startActivity(iMensaje);
    }

    public boolean calcularPrimo(int numero){

        return true;
    }
}