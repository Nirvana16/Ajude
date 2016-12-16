package br.edu.iff.pooa20162.ajude;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class PacienteActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paciente);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.v("Paciente","OnStart");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.v("Paciente","onResume");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.v("Paciente!","onPause");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.v("Paciente","onStop");
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.v("Paciente","onDestroy");
    }
}
