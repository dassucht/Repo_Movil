package com.example.alejandro.miscontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnAgregar;
    ListView lv;
    List<Contacto> lis = new ArrayList<Contacto>();
    Contacto c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView)findViewById(R.id.listContactos);
        btnAgregar=(Button)findViewById(R.id.btnAgregar);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Formulario.class);
                startActivityForResult(i,1000);
            }
        });
    }
    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000 && resultCode == RESULT_OK) {
            Toast.makeText(this,"Usuario agregado",Toast.LENGTH_SHORT).show();
            Bundle b = data.getExtras();
            c = b.getParcelable("Contacto");
            //Toast.makeText(this,c.getUsuario().toString(),Toast.LENGTH_SHORT).show();
            lis.add(c);
            ContactoAdapter adp = new ContactoAdapter(getApplicationContext(),(ArrayList)lis);
            lv.setAdapter(adp);
        }
    }
}
