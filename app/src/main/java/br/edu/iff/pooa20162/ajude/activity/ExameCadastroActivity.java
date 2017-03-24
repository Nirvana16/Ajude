package br.edu.iff.pooa20162.ajude.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.iff.pooa20162.ajude.R;
import br.edu.iff.pooa20162.ajude.model.Exame;
import br.edu.iff.pooa20162.ajude.model.Medicamento;

/**
 * Created by nirvana161 on 24/03/17.
 */

public  class ExameCadastroActivity extends AppCompatActivity {

    EditText ExameDescricao, ExameHora, ExameData;
    Button btSalvar, btApagar;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exame_cadastro);
        Intent intent = getIntent();
        id = (int) intent.getSerializableExtra("id");
        String ExameDescricaop    = (String) intent.getSerializableExtra("ExameDescricao");
        String ExameHorap = (String) intent.getSerializableExtra("ExameHora");
        String ExameDatap     = (String) intent.getSerializableExtra("ExameData");

        EditText ExameDescricao = (EditText) findViewById(R.id.etExameDescricao);
        ExameDescricao.setText(ExameDescricaop);

        EditText ExameHora = (EditText) findViewById(R.id.etExameHora);
        ExameHora.setText(ExameHorap);

        EditText ExameData = (EditText) findViewById(R.id.etexameData);
        ExameData.setText(ExameDatap);

        btSalvar = (Button) findViewById(R.id.bgravar);
        btSalvar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                salvar();
            }
        });

        btApagar = (Button) findViewById(R.id.bApagar);
        btApagar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                deletar();
            }
        });

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
    public void salvar(){

        ExameDescricao = (EditText) findViewById(R.id.etExameDescricao);
        ExameHora = (EditText) findViewById(R.id.etexameData);
        ExameData = (EditText) findViewById(R.id.etExameHora);

        Exame exame = new Exame(ExameDescricao.getText().toString(), ExameHora.getText().toString(),
                                ExameData.getText().toString());
        exame.save();
        Toast.makeText(this,"Exame Cadastrado",Toast.LENGTH_LONG).show();
        this.finish();
    }

    public void deletar(){
        new AlertDialog.Builder(this)
                .setTitle("ATENCAO")
                .setMessage("DESEJA REALMENTE EXCLUIR ESSE EXAME?")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int whichButton) {

                        ExameDescricao = (EditText) findViewById(R.id.etExameDescricao);
                        ExameHora = (EditText) findViewById(R.id.etexameData);
                        ExameData = (EditText) findViewById(R.id.etExameHora);

                        Exame exame = Exame.findById(Exame.class, id);
                        exame.delete();
                        finish();
                    }})
                .setNegativeButton(android.R.string.no, null).show();

    }
}