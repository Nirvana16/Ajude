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

import br.edu.iff.pooa20162.ajude.model.Contato;
import br.edu.iff.pooa20162.ajude.model.Mensagem;

public class MensagemActivity extends AppCompatActivity {

// Atributos de referencia ====================================================================
    Mensagem msg;

    //private String conteudo = "\nPRECISO DE AJUDA \n Estou em: LOCALIZACAO";
    Button bSalvar;
    EditText etConteudo;


// Metodos construtores / Ciclo de vida =================================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensagem);

        bSalvar = (Button) findViewById(R.id.btSalvar);
        etConteudo = (EditText) findViewById(R.id.etConteudo);

        // Criando ouvinte para o botao salvar.
        bSalvar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                msg = new Mensagem(etConteudo.getText().toString());
                msg.save();
//                msg = msg.findById(Mensagem.class,1);
//                msg = msg.Parse
//                Log.v("Msg BD",msg);



                //Fazendo a chamada da tela que ira receber o conteudo do editText
                    //Intent itMain = new Intent(MensagemActivity.this, MainActivity.class);

                //Metodo putExtra quem envia o contudo para a outra Activity
                //as informações sao enviadas na forma de "chave e valor" neste caso a minha
                // chave é a string Msgconteudo e o Valor é o texto contido no etConteudo
                  // String conteudo = etConteudo.getText().toString();

//                itMain.putExtra("Msgconteudo",conteudo);
//                startActivity(itMain);
//                Mensagem mensagem = new Mensagem();
//                mensagem.setConteudo(conteudo);
//                //Apenas para debug;
               // Log.v("EditText", etConteudo.getText().toString());
                //Log.v("VALOR DE CONTEUDO",conteudo);
                //Log.v("ConteudoClasse",mensagem.getConteudo());



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
//    public void EnviarSMS(){
//
//        Contato objContato = new Contato();
//        /*
//           SmsManager, API que faz toda a magica acontecer.
//           lembrar de ler a documentação mais a fundo
//           https://developer.android.com/reference/android/telephony/SmsManager.html
//         */
//        SmsManager smsManager = SmsManager.getDefault();
//        // O for serve para enviar multiplas mensagens, haverá um parametro na tela de configurações
//        // Onde o usuário poderá definir quantas mensagens ele quer enviar. Por ora coloquei 4.
//
//        for (int i = 0; i < 4; i++) {
//            smsManager.sendTextMessage(objContato.getTelefone(), null, "ATENCAO! "+objContato.getNome()+"\n"+conteudo, null, null);
//        }
//    }
}
