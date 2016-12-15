package br.edu.iff.pooa20162.ajude;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class OpcoesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcoes);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.v("Hora do Show","OnStart");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.v("Boora","onResume");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.v("Segura!","onPause");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.v("Birll","onStop");
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.v("Ta saindo da jaula","onDestroy");
    }
}
