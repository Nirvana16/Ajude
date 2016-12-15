package br.edu.iff.pooa20162.ajude;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    // BOTÕES ===================================================================================
        // Botao Principal
        ImageButton ibAjuda = (ImageButton) findViewById(R.id.ibAjuda);
        ibAjuda.setOnClickListener(new View.OnClickListener(){


            MensagemActivity msg = new MensagemActivity();
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Alerta Enviado", Toast.LENGTH_SHORT).show();
                msg.EnviarSMS();

            }
        });

        // Image Button da Mensagem
        ImageButton ibMsg = (ImageButton) findViewById(R.id.ibMensagem);

        ibMsg.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, MensagemActivity.class);
                startActivity(it);
            }
        });

        // Image Button do Contato
        ImageButton ibContato = (ImageButton) findViewById(R.id.ibContato);
        ibContato.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, ContatoActivity.class);
                startActivity(it);
            }
        });
        // Image Button Exames
        ImageButton ibExame = (ImageButton) findViewById(R.id.ibExame);
        ibExame.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, ExameActivity.class);
                startActivity(it);
            }
        });
        // Image Button do Medicamentos
        ImageButton ibMedicamento = (ImageButton) findViewById(R.id.ibMedicamento);
        ibMedicamento.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, MedicamentoActivity.class);
                startActivity(it);
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

// Métodos da Action Bar ========================================================================
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    // Lista de opções da action bar personalizada
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.action_opcoes:
                Intent intent = new Intent(this,OpcoesActivity.class);
                this.startActivity(intent);
                break;
            case R.id.action_paciente:
                Intent intent2 = new Intent(this,PacienteActivity.class);
                this.startActivity(intent2);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }


//    // Menu original, comentado por ora.... Excluir no futuro
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
