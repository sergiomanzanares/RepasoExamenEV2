package com.example.repasoexamenev2;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class User {

    @SerializedName("nombre")
    String nombre;

    @SerializedName("password")
    String password;

    public User(String nombre, String password) {
        setNombre(nombre);
        setPassword(password);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(nombre, user.nombre) &&
                Objects.equals(password, user.password);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(nombre, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "nombre='" + nombre + '\'' +
                ", password='" + password + '\'' +
                '}';
    }



}
