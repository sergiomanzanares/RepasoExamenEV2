package com.example.repasoexamenev2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HTTP;
import retrofit2.http.POST;

public interface ApiService {
    @POST(Constantes.LOGIN_URL)
    Call<List<User>> listaUsuarios();
}
