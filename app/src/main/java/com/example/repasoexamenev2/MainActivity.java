package com.example.repasoexamenev2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText pass, nombre;
    Button btn;
    UsuarioViewModel uvm;
    List<User> listaUsuarios;
    User usuario;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uvm = new ViewModelProvider(this).get(UsuarioViewModel.class);

        listaUsuarios = new ArrayList<User>();

        uvm.getUsuarios().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                listaUsuarios = new ArrayList<User>(users);

                for (User u: listaUsuarios) {
                    System.out.println(u.toString());
                }
            }
        });

        nombre = findViewById(R.id.ETNombre);
        pass = findViewById(R.id.ETPassword);
        btn = findViewById(R.id.btnComprobar);
        tv = findViewById(R.id.TVMostrarUsuario);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario = new User(nombre.getText().toString(), pass.getText().toString());

                if (listaUsuarios.contains(usuario)) {
                    tv.setText(usuario.toString());
                }

            }
        });

    }
}