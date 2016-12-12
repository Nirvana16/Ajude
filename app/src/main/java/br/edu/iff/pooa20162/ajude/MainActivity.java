package br.edu.iff.pooa20162.ajude;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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
        ibMsg.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, MensagemActivity.class);
                startActivity(it);
            }
        });
        // Image Button Exames
        ImageButton ibExame = (ImageButton) findViewById(R.id.ibExame);
        ibMsg.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, MensagemActivity.class);
                startActivity(it);
            }
        });
        // Image Button do Medicamentos
        ImageButton ibMedicamento = (ImageButton) findViewById(R.id.ibMedicamento);
        ibMsg.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, MensagemActivity.class);
                startActivity(it);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
