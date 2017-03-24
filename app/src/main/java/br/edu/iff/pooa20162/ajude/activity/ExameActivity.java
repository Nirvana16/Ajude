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
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import br.edu.iff.pooa20162.ajude.R;
import br.edu.iff.pooa20162.ajude.adapter.ExameAdapter;
import br.edu.iff.pooa20162.ajude.adapter.MedicamentoAdapter;
import br.edu.iff.pooa20162.ajude.model.Exame;
import br.edu.iff.pooa20162.ajude.model.Medicamento;

public class ExameActivity extends AppCompatActivity {

//Variaveis ====================================================
    /* Array de String para o Spinner. Ainda não decidi se irei pouplar o componente dessa forma ou se coloco um
       Resource com as listas
    */
//    private String[] dia = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
//                                        "16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
//    private String[] mes = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"};
//
//    private String[] ano = new String[]{"2016","2017","2018","2019","2020"};
//
//    private Spinner spDia, spMes, spAno;

// Metodos ===========================================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exame);

//
//        // Adapter para o Spinner do dia ==================================================
//        ArrayAdapter<String> adapterDia = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, dia);
//        adapterDia.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//        spDia = (Spinner) findViewById(R.id.spExameDia);
//        spDia.setAdapter(adapterDia);
//        spDia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//                // Apenas para fins de Debug
//                /*
//                Toast.makeText(getApplicationContext(),"Nome:"+spDia.getSelectedItem()+
//                        " -> ID: "+spDia.getSelectedItemId()+" -> Posicao: "+spDia.getSelectedItemPosition(), Toast.LENGTH_SHORT).show();
//                */
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//        // Adapter para o Spinner do Mes ==================================================
//        ArrayAdapter<String> adapterMes = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, mes);
//        adapterMes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spMes = (Spinner) findViewById(R.id.spExameMes);
//        spMes.setAdapter(adapterMes);
//        spMes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//        // Adapter para o Spinner do ano ==================================================
//        ArrayAdapter<String> adapterAno = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, ano);
//        adapterAno.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spAno = (Spinner) findViewById(R.id.spExameAno);
//        spAno.setAdapter(adapterAno);
//        spAno.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

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
        final ArrayList<Exame> exames  = (ArrayList) Exame.listAll(Exame.class);

        ListView lista = (ListView) findViewById(R.id.lvExames);
        ArrayAdapter adapter = new ExameAdapter(this,exames);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ExameActivity.this,ExameCadastroActivity.class);

                intent.putExtra("id",exames.get(i).getId().intValue());
                intent.putExtra("descricao",exames.get(i).getDescricao());
                intent.putExtra("hora",exames.get(i).getData());
                intent.putExtra("data",exames.get(i).getHora());
                startActivity(intent);
            }
        });
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
    // Métodos da Action Bar ========================================================================
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_exame, menu);
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
                Intent it = new Intent(ExameActivity.this, ExameCadastroActivity.class);
                it.putExtra("id",0);
                it.putExtra("descricao","");
                it.putExtra("hora","");
                it.putExtra("data","");
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