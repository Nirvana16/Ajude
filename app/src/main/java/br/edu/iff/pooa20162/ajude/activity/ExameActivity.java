package br.edu.iff.pooa20162.ajude.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import br.edu.iff.pooa20162.ajude.R;

public class ExameActivity extends AppCompatActivity {


//Variaveis ====================================================
    /* Array de String para o Spinner. Ainda não decidi se irei pouplar o componente dessa forma ou se coloco um
       Resource com as listas
    */
    private String[] dia = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
                                        "16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    private String[] mes = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"};

    private String[] ano = new String[]{"2016","2017","2018","2019","2020"};

    private Spinner spDia, spMes, spAno;

// Metodos ===========================================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exame);

        // Adapter para o Spinner do dia ==================================================
        ArrayAdapter<String> adapterDia = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, dia);
        adapterDia.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDia = (Spinner) findViewById(R.id.spExameDia);
        spDia.setAdapter(adapterDia);
        spDia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Apenas para fins de Debug
                /*
                Toast.makeText(getApplicationContext(),"Nome:"+spDia.getSelectedItem()+
                        " -> ID: "+spDia.getSelectedItemId()+" -> Posicao: "+spDia.getSelectedItemPosition(), Toast.LENGTH_SHORT).show();
                */
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Adapter para o Spinner do Mes ==================================================
        ArrayAdapter<String> adapterMes = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, mes);
        adapterMes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spMes = (Spinner) findViewById(R.id.spExameMes);
        spMes.setAdapter(adapterMes);
        spMes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        // Adapter para o Spinner do ano ==================================================
        ArrayAdapter<String> adapterAno = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, ano);
        adapterAno.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spAno = (Spinner) findViewById(R.id.spExameAno);
        spAno.setAdapter(adapterAno);
        spAno.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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




    /*
    public void ShowElemento(View view){
        String nome = (String) sp.getSelectedItem();
        long id = sp.getSelectedItemId();
        int posicao = sp.getSelectedItemPosition();

        Toast.makeText(this,"Nome:"+nome+" -> ID: "+id+" -> Posicao: "+posicao, Toast.LENGTH_SHORT).show();
    }
    */
}
