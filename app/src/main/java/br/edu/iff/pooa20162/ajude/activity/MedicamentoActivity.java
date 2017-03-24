package br.edu.iff.pooa20162.ajude.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import br.edu.iff.pooa20162.ajude.R;
import br.edu.iff.pooa20162.ajude.adapter.MedicamentoAdapter;
import br.edu.iff.pooa20162.ajude.model.Medicamento;

//import static br.edu.iff.pooa20162.ajude.R.id.bMedicamentoNovo;


public class MedicamentoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicamento);

//        ListView lista = (ListView) findViewById(R.id.lvMedicamentos);
//
//        final ArrayList<String> medicamentos = preencherDados();
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, medicamentos);
//        lista.setAdapter(arrayAdapter);
//
//        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                //Debug para ver se seleciona certo
//                Toast.makeText(getApplicationContext(), "Medicamento: " + medicamentos.get(position).toString(), Toast.LENGTH_SHORT).show();
//
//            }
//        });

//        Button bNovo = (Button) findViewById(bMedicamentoNovo);
//        bNovo.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                Intent it = new Intent(MedicamentoActivity.this, MedicamentoCadastroActivity.class);
//                it.putExtra("id",0);
//                it.putExtra("nome","");
//                it.putExtra("descricao","");
//                it.putExtra("horaDeUso","");
//                it.putExtra("dataInicio","");
//                it.putExtra("dataTermino","");
//                it.putExtra("dosagem",0);
//                startActivity(it);
//            }
//        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("MedicamentoAct", "OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("MedicamentoAct", "onResume");
        final ArrayList<Medicamento> medicamentos  = (ArrayList) Medicamento.listAll(Medicamento.class);

        ListView lista = (ListView) findViewById(R.id.lvMedicamentos);
        ArrayAdapter adapter = new MedicamentoAdapter(this,medicamentos);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MedicamentoActivity.this,MedicamentoCadastroActivity.class);

                intent.putExtra("id",medicamentos.get(i).getId().intValue());
                intent.putExtra("nome",medicamentos.get(i).getNome());
                intent.putExtra("descricao",medicamentos.get(i).getDescricao());
                intent.putExtra("horaDeUso",medicamentos.get(i).getHoraDeUso());
                intent.putExtra("dataInicio",medicamentos.get(i).getDataInicio());
                intent.putExtra("dataTermino",medicamentos.get(i).getDataTermino());
                intent.putExtra("dosagem",medicamentos.get(i).getDosagem());

                startActivity(intent);

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("MedicamentoAct!", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("MedicamentoAct", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("MedicamentoAct", "onDestroy");
    }

    // Métodos da Action Bar ========================================================================
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_medicamento, menu);
        return true;
    }


    // Lista de opções da action bar personalizada
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
//                Intent intent = new Intent(this, MedicamentoCadastroActivity.class);
//                this.startActivity(intent);
//
                Intent it = new Intent(MedicamentoActivity.this, MedicamentoCadastroActivity.class);
                it.putExtra("id",0);
                it.putExtra("nome","");
                it.putExtra("descricao","");
                it.putExtra("horaDeUso","");
                it.putExtra("dataInicio","");
                it.putExtra("dataTermino","");
                it.putExtra("dosagem",0);
                startActivity(it);
                break;
//            case R.id.action_paciente:
//                Intent intent2 = new Intent(this,PacienteActivity.class);
//                this.startActivity(intent2);
//                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}