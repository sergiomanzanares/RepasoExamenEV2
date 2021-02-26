package com.example.repasoexamenev2;

import android.util.Log;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UsuarioViewModel extends ViewModel {
    private MutableLiveData<List<User>> usuarios;

    public LiveData<List<User>> getUsuarios() {
        if(usuarios == null) {
            usuarios = new MutableLiveData<List<User>>();
            loadUsuarios();
        }

        return usuarios;
    }

    public void loadUsuarios() {
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl("http://127.0.0.1:8080/").
                addConverterFactory(GsonConverterFactory.create()).
                build();

        ApiService service = retrofit.create(ApiService.class);

        //Call<List<User>> repo = service.listaUsuarios(MainActivity.token);
        Call<List<User>> repo = service.listaUsuarios("bgy6ujhydrj7dr6");

        repo.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                usuarios.postValue(response.body());
                Log.d("datos", "obtenidos");
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.d("datos", t.getMessage());
            }
        });


    }


}
