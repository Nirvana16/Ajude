package br.edu.iff.pooa20162.ajude;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import br.edu.iff.pooa20162.ajude.model.Contato;

public class ContatoActivity extends AppCompatActivity {

 // Atributo de referencia ====================================================================

    private Contato contato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.v("Contato","OnStart");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.v("Contato","onResume");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.v("Contato!","onPause");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.v("Contato","onStop");
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.v("Contato","onDestroy");
    }
}

