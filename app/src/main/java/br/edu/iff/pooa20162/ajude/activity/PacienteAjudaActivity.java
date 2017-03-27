package br.edu.iff.pooa20162.ajude.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import br.edu.iff.pooa20162.ajude.R;
import br.edu.iff.pooa20162.ajude.model.Paciente;

public class PacienteAjudaActivity extends AppCompatActivity {

    TextView ajudeNome;
    private Paciente paciente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paciente_ajuda);

        ajudeNome = (TextView) findViewById(R.id.tvAjudaNome);
        paciente = paciente.findById(Paciente.class,1);
        if (paciente != null){
            ajudeNome.setText(paciente.getNome());
        }
        else{

        }

    }
}
