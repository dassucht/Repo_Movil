package com.example.alejandro.permisos;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLocation, btnAudio;
    private final int LOCATION_REQUEST_CODE=2;
    private final int AUDIO_REQUEST_CODE=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLocation = (Button)findViewById(R.id.btnLocation);
        btnAudio = (Button)findViewById(R.id.btnAudio);

        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                askPermission(Manifest.permission.ACCESS_FINE_LOCATION,LOCATION_REQUEST_CODE);
            }
        });
        btnAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                askPermission(Manifest.permission.RECORD_AUDIO,AUDIO_REQUEST_CODE);
            }
        });
    }

    private void askPermission(String permission, int requestCode){
        if(ContextCompat.checkSelfPermission(this, permission)!= PackageManager.PERMISSION_GRANTED){
            //Hay permiso
            ActivityCompat.requestPermissions(this, new String[]{permission},requestCode);
        }else{
            //No hay permiso
            Toast.makeText(this, "Permiso concedido",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case LOCATION_REQUEST_CODE:
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Permiso LOCATION concedido", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Permiso LOCATION denegado", Toast.LENGTH_SHORT).show();
                }
                break;
            case AUDIO_REQUEST_CODE:
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Permiso AUDIO concedido", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Permiso AUDIO denegado", Toast.LENGTH_SHORT).show();
                }
                break;
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
