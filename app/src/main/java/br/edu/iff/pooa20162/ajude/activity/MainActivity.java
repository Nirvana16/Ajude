package br.edu.iff.pooa20162.ajude.activity;

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

import br.edu.iff.pooa20162.ajude.R;
import br.edu.iff.pooa20162.ajude.model.Mensagem;


public class MainActivity extends AppCompatActivity {

    Mensagem msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //msg = new Mensagem();
        msg = Mensagem.findById(Mensagem.class,1);

    // BOTÕES ===================================================================================
        // Botao Principal
        ImageButton ibAjuda = (ImageButton) findViewById(R.id.ibAjuda);
        ibAjuda.setOnClickListener(new View.OnClickListener(){

            // Criacao do objeto Msg para receber o valor do texto digitado pelo usuário


            // Variavel de apoio valor recebendo o conteudo do editText da Activity anterior
            //String valor = getIntent().getStringExtra("Msgconteudo");
            //String valor = "preciso de ajuda";
            @Override
            public void onClick(View view) {

                if (msg == null){
                    msg = new Mensagem("Preciso de Ajuda");
                }
                msg.enviarSMS(4,".");
                Toast.makeText(getApplicationContext(),"Alerta Enviado", Toast.LENGTH_SHORT).show();
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
        Log.v("Main","OnStart");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.v("Main","onResume");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.v("Main!","onPause");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.v("Main","onStop");
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.v("Main","onDestroy");
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
}
