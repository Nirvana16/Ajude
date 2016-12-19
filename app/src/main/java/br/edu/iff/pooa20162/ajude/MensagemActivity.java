package br.edu.iff.pooa20162.ajude;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MensagemActivity extends AppCompatActivity {

// Variaveis locais ====================================================================

    private String conteudo = "\nPRECISO DE AJUDA \n Estou em: LOCALIZACAO";

    Button bSalvar;
    EditText etConteudo;

// Atributos de referencia para o relacionamento entre classes =========================

// Getters and Setters ================================================================

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

// Metodos construtores / Ciclo de vida =================================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensagem);

        //Salvar conteudo da mensagem dinamicamente
        //Futuramente isso será salvo no banco de dados
        bSalvar = (Button) findViewById(R.id.btSalvar);
        etConteudo = (EditText) findViewById(R.id.etConteudo);

        // Criando ouvinte para o botao salvar.
        bSalvar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                //Fazendo a chamada da tela que ira receber o conteudo do editText
                Intent itMain = new Intent(MensagemActivity.this, MainActivity.class);

                //Metodo putExtra quem envia o contudo para a outra Activity
                //as informações sao enviadas na forma de "chave e valor" neste caso a minha
                // chave é a string Msgconteudo e o Valor é o texto contido no etConteudo
                itMain.putExtra("Msgconteudo",etConteudo.getText().toString());
                startActivity(itMain);

                conteudo = etConteudo.getText().toString();
                //Apenas para debug;
                Log.v("EditText", etConteudo.getText().toString());
                Log.v("VALOR DE CONTEUDO",conteudo);

                Toast.makeText(getApplicationContext(),"Mensagem Salva", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.v("MensagemActivity","OnStart");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.v("MensagemActivity","onResume");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.v("MensagemActivity!","onPause");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.v("MensagemActivity","onStop");
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.v("MensagemActivity","onDestroy");
    }

// metodos =================================================================================

    // Metodo para efetuar o envio de sms
    // Futuraemente irei implementar esse método para que ele busque o texto inserido pelo
    // usuario.
    // Vou precisar capturar o numero do contato, passar para String assim e fazer o mesmo
    // Com o Texto da mensagem.
    public void EnviarSMS(){

        ContatoActivity objContato = new ContatoActivity();
        /*
           SmsManager, API que faz toda a magica acontecer.
           lembrar de ler a documentação mais a fundo
           https://developer.android.com/reference/android/telephony/SmsManager.html
         */
        SmsManager smsManager = SmsManager.getDefault();
        // O for serve para enviar multiplas mensagens, haverá um parametro na tela de configurações
        // Onde o usuário poderá definir quantas mensagens ele quer enviar. Por ora coloquei 4.

        for (int i = 0; i < 4; i++) {
            smsManager.sendTextMessage(objContato.getTelefone(), null, "ATENCAO! "+objContato.getNome()+"\n"+conteudo, null, null);
        }
    }
}
