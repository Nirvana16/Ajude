package br.edu.iff.pooa20162.ajude.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.edu.iff.pooa20162.ajude.R;

import static android.Manifest.permission.RECEIVE_SMS;

public class AberturaActivity extends AppCompatActivity implements Runnable {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abertura);

        ActivityCompat.requestPermissions(AberturaActivity.this,new String[]{Manifest.permission.RECEIVE_BOOT_COMPLETED},0);

        // Se não possui permissão
        if (ContextCompat.checkSelfPermission(AberturaActivity.this,RECEIVE_SMS) != PackageManager.PERMISSION_GRANTED) {

           Handler handler = new Handler();
           handler.postDelayed(this, 5000);

            // Solicita a permissão 1
            ActivityCompat.requestPermissions(AberturaActivity.this,new String[]{RECEIVE_SMS},0);

            // Verifica se já mostramos o alerta e o usuário negou na 1ª vez.
            if (ActivityCompat.shouldShowRequestPermissionRationale(AberturaActivity.this,Manifest.permission.RECEIVE_SMS)) {
                // Caso o usuário tenha negado a permissão anteriormente, e não tenha marcado o check "nunca mais mostre este alerta"
                // Podemos mostrar um alerta explicando para o usuário porque a permissão é importante.
            } else {
                // Solicita a permissão
                ActivityCompat.requestPermissions(AberturaActivity.this,new String[]{Manifest.permission.RECEIVE_SMS},0);
            }
        } else {
            Handler handler = new Handler();
            handler.postDelayed(this, 1000);
        }
    }

    public void run(){
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}



