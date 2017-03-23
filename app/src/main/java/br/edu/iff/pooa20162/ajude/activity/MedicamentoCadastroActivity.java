package br.edu.iff.pooa20162.ajude.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.iff.pooa20162.ajude.R;
import br.edu.iff.pooa20162.ajude.model.Medicamento;

public class MedicamentoCadastroActivity extends AppCompatActivity {

    EditText nome, descricao, dosagem, horaDeUso, dataInicio, dataTermino;
    Button btSalvar, btApagar;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicamento_cadastro);
        Intent intent = getIntent();
        id = (int) intent.getSerializableExtra("id");
        String nomep     = (String) intent.getSerializableExtra("nome");
        String descricaop    = (String) intent.getSerializableExtra("descricaop");
        String horaDeUsop = (String) intent.getSerializableExtra("horaDeUso");
        String dataIniciop     = (String) intent.getSerializableExtra("dataInicio");
        String dataTerminop     = (String) intent.getSerializableExtra("dataTermino");
        int dosagemp  = (int)  intent.getSerializableExtra("dosagem");

        EditText nome = (EditText) findViewById(R.id.etMedicamentoNome);
        nome.setText(nomep);

        EditText descricao = (EditText) findViewById(R.id.etMedicamentoDescricao);
        descricao.setText(descricaop);

        EditText dosagem = (EditText) findViewById(R.id.etMedicamentoDose);
        dosagem.setText(Integer.toString(dosagemp));

        EditText horaDeUso = (EditText) findViewById(R.id.etMedicamentoHora);
        horaDeUso.setText(horaDeUsop);

        EditText dataInicio = (EditText) findViewById(R.id.etMedicamentoDataInicio);
        dataInicio.setText(dataIniciop);

        EditText dataTermino = (EditText) findViewById(R.id.etMedicamentoDataTermino);
        dataTermino.setText(dataTerminop);

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
        nome = (EditText) findViewById(R.id.etMedicamentoNome);
        descricao = (EditText) findViewById(R.id.etMedicamentoDescricao);
        dosagem = (EditText) findViewById(R.id.etMedicamentoDose);
        horaDeUso = (EditText) findViewById(R.id.etMedicamentoHora);
        dataInicio = (EditText) findViewById(R.id.etMedicamentoDataInicio);
        dataTermino = (EditText) findViewById(R.id.etMedicamentoDataTermino);

        Medicamento medicamento = new Medicamento (nome.getText().toString(), descricao.getText().toString(),
                horaDeUso.getText().toString(), dataInicio.getText().toString(),
                dataTermino.getText().toString(), Integer.parseInt(dosagem.getText().toString()));

        medicamento.save();
        Toast.makeText(this,"Medicamento Cadastrado",Toast.LENGTH_LONG).show();
        this.finish();
    }


    public void deletar(){
        new AlertDialog.Builder(this)
                .setTitle("ATENCAO")
                .setMessage("DESEJA REALMENTE EXCLUIR ESSE MEDICAMENTO?")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int whichButton) {
                        nome = (EditText) findViewById(R.id.etMedicamentoNome);
                        descricao = (EditText) findViewById(R.id.etMedicamentoDescricao);
                        dosagem = (EditText) findViewById(R.id.etMedicamentoDose);
                        horaDeUso = (EditText) findViewById(R.id.etMedicamentoHora);
                        dataInicio = (EditText) findViewById(R.id.etMedicamentoDataInicio);
                        dataTermino = (EditText) findViewById(R.id.etMedicamentoDataTermino);

                        Medicamento medicamento = Medicamento.findById(Medicamento.class, id);
                        medicamento.delete();
                        finish();
                    }})
                .setNegativeButton(android.R.string.no, null).show();

    }
}
