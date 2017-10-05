package com.example.alejandro.miscontactos;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Alejandro on 08/09/2017.
 */

public class Formulario extends AppCompatActivity {
    EditText usuario, email, twitter;
    Button aceptar;
    Contacto c;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario);
        this.setTitle(R.string.titulo);
        usuario = (EditText)findViewById(R.id.txtUsuario);
        email = (EditText)findViewById(R.id.txtEmail);
        twitter = (EditText)findViewById(R.id.txtTwitter);
        aceptar = (Button)findViewById(R.id.btnAceptar);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    c = new Contacto(usuario.getText().toString(), email.getText().toString(), twitter.getText().toString());
                }catch (Exception e){}
                Intent data = new Intent();
                data.putExtra("Contacto", c);
                setResult(RESULT_OK,data);
                finish();

            }
        });
    }
}
