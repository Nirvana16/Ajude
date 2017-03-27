package br.edu.iff.pooa20162.ajude.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.iff.pooa20162.ajude.R;
import br.edu.iff.pooa20162.ajude.model.Medicamento;
import br.edu.iff.pooa20162.ajude.model.Paciente;

public class PacienteActivity extends AppCompatActivity {

    Button bGravar;
    EditText pacienteNome, pacienteData, pacienteTelefone;
    private Paciente paciente;
    int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paciente);

        bGravar = (Button) findViewById(R.id.bGravar);
        pacienteNome = (EditText) findViewById(R.id.etNome);
        pacienteData = (EditText) findViewById(R.id.etDataNascimento);
        pacienteTelefone = (EditText) findViewById(R.id.etTelefone);


        paciente = paciente.findById(Paciente.class,1);
        if (paciente != null){
            pacienteNome.setText(paciente.getNome());
            pacienteData.setText(paciente.getDataNascimento());
            pacienteTelefone.setText(paciente.getTelefone());
        }
        bGravar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                salvar();
            }
        });



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

    public void salvar(){
        if (paciente == null) {
             paciente = new Paciente(pacienteNome.getText().toString(), pacienteData.getText().toString(),
                    pacienteTelefone.getText().toString());
        }
        else{
            paciente.setNome(pacienteNome.getText().toString());
            paciente.setDataNascimento(pacienteData.getText().toString());
            paciente.setTelefone(pacienteTelefone.getText().toString());
        }
        paciente.save();
        Toast.makeText(this,"Paciente Cadastrado",Toast.LENGTH_LONG).show();
        this.finish();
    }
}
