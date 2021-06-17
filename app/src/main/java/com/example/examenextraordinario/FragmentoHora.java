package com.example.examenextraordinario;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class FragmentoHora extends Fragment {

    TextView parrafo;

    public FragmentoHora(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmento_hora_fragment, container, false);

        parrafo = view.findViewById(R.id.txtHora);
        parrafo.setText(parrafo.getText() + "\n" +
                Calendar.getInstance().getTime().toString());

        return view;
    }





}