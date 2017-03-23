package br.edu.iff.pooa20162.ajude.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.iff.pooa20162.ajude.MascaraEditTextListener;
import br.edu.iff.pooa20162.ajude.R;
import br.edu.iff.pooa20162.ajude.model.Contato;

public class ContatoActivity extends AppCompatActivity {

 // Atributo de referencia ====================================================================

    private Contato contato;

// Atributos da View ==========================================
    Button bSalvar,bLimpar;
    EditText etTelefone, etNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);

        bSalvar = (Button) findViewById(R.id.btSalvarC);
        bLimpar = (Button) findViewById(R.id.btLimparC);

        etNome = (EditText) findViewById(R.id.etNomeC);
        etTelefone = (EditText) findViewById(R.id.etTelefoneC);

        MascaraEditTextListener maskTel = new MascaraEditTextListener("(##)#####-####", etTelefone);
        etTelefone.addTextChangedListener(maskTel);

        contato = contato.findById(Contato.class,1);
        if (contato != null){
            etTelefone.setText(contato.getTelefone());
            etNome.setText(contato.getNome());
        }

        bSalvar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                String nome = etNome.getText().toString();
                String telefone = etTelefone.getText().toString();


                if (contato == null) {
                    contato = new Contato(nome, telefone);
                }
                else{
                    contato.setNome(nome);
                    contato.setTelefone(telefone);
                }
                contato.save();
                Toast.makeText(getApplicationContext(),"Contato Salvo", Toast.LENGTH_SHORT).show();
            }
        });

        // Para debug:
        bLimpar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                etTelefone.setText(contato.getTelefone());
                etNome.setText(contato.getNome());
            }
        });
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

