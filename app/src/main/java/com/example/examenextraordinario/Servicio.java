package com.example.examenextraordinario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Servicio {
    @GET("/jorgeduenaslerin/desarrollo-web/book")
    Call<List<Libro>> listLibros();
}
