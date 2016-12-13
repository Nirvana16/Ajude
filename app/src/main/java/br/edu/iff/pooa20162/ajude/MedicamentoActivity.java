package br.edu.iff.pooa20162.ajude;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MedicamentoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicamento);

        ListView lista = (ListView) findViewById(R.id.lvMedicamentos);

        final ArrayList<String> medicamentos = preencherDados();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, medicamentos);
        lista.setAdapter(arrayAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Debug para ver se seleciona certo
                Toast.makeText(getApplicationContext(), "Medicamento: "+medicamentos.get(position).toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    // Futuramente vou implementar para que ocorra o preenchimento dinamico em tempo de execução.
    private ArrayList<String> preencherDados() {
        ArrayList<String> dados = new ArrayList<String>();
        dados.add("Aldactone");
        dados.add("Benazepril");
        dados.add("Furosemida");
        dados.add("Digoxina");
        dados.add("Bisoprolol");
        dados.add("Puran T4");
        dados.add("Seretide");
        dados.add("Hidroclorotiazida");
        dados.add("Acebrofilina");
        dados.add("Loratadina");
        return dados;
    }
}
