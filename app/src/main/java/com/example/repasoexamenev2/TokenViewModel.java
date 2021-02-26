package com.example.repasoexamenev2;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TokenViewModel extends ViewModel {
    private MutableLiveData<String> token;

    public LiveData<String> getToken() {
        if(token == null) {
            token = new MutableLiveData<String>();
            loadToken();
        }

        return token;
    }

    public void loadToken() {
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl("http://127.0.0.1:8080/").
                addConverterFactory(GsonConverterFactory.create()).
                build();

        ApiService service = retrofit.create(ApiService.class);

        Call<String> repo = service.token();

        repo.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                token.postValue(response.body());
                Log.d("acceso", "concedido");
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("acceso", t.getMessage());
            }
        });


    }


}
