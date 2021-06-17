package com.example.examenextraordinario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Actividad1 extends AppCompatActivity {

    private TextView txtEsPrimo;
    private Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);

        txtEsPrimo = findViewById(R.id.txtEsPrimo);

        Bundle datos = getIntent().getExtras();
        txtEsPrimo.setText(datos.getString("Numero"));

        Intent i = new Intent(this, MainActivity.class);
        btnVolver = findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(Activity.RESULT_OK,i);
                finish();
            }
        });

    }
}