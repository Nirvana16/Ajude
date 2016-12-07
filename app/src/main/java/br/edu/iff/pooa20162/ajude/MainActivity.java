package br.edu.iff.pooa20162.ajude;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MessengerActivity msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // BOTÕES ==============================================================
        // BOTAO AJUDA (IMPLEMENTAR)
        ImageButton ibAjuda = (ImageButton) findViewById(R.id.ibAjuda);
        ibAjuda.setOnClickListener(new View.OnClickListener(){


            // Metodo para efetuar o envio de SMS
            // Futaremente irei implementar esse método para que ele busque o texto inserido pelo
            // usuario. e move-lo para classe MessengerActivity
            // Vou precisar capturar o numero do contato, passar para String assim e fazero mesmo
            // Com o Texto da mensagem.
            public void EnviarSMS(){
                // Classe SmsManager, API que faz toda a magica acontecer.
                // lembrar de ler a documentação mais a fundo
                // https://developer.android.com/reference/android/telephony/SmsManager.html
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage("+5522997254145", null, "ATENCAO PRECISO DE AJUDA \n Estou em: LOCALIZACAO", null, null);
            }

            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Alerta Enviado", Toast.LENGTH_SHORT).show();
                EnviarSMS();


            }

        });



        // Image Button da MSG IREI MUDAR A ACTIVITE
        ImageButton ibMsg = (ImageButton) findViewById(R.id.ibMensagem);
        ibMsg.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, MainActivity.class);
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
