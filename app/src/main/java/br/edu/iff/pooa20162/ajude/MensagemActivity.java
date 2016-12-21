package br.edu.iff.pooa20162.ajude;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.edu.iff.pooa20162.ajude.model.Contato;
import br.edu.iff.pooa20162.ajude.model.Mensagem;

import static com.orm.SugarRecord.findById;

public class MensagemActivity extends AppCompatActivity {

// Atributos de referencia ====================================================================
    Mensagem msg;

    //private String conteudo = "\nPRECISO DE AJUDA \n Estou em: LOCALIZACAO";
    Button bSalvar, bExibir;
    EditText etConteudo;


// Metodos construtores / Ciclo de vida =================================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensagem);

        bSalvar = (Button) findViewById(R.id.btSalvar);
        etConteudo = (EditText) findViewById(R.id.etConteudo);

        msg = msg.findById(Mensagem.class,1);
        if (msg != null){
            etConteudo.setText(msg.getConteudo());
        }

        // Criando ouvinte para o botao salvar.
        bSalvar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                if (msg == null){
                    String sms = etConteudo.getText().toString();
                    msg = new Mensagem(sms);
                    msg.save();
                }
                else{
                    Mensagem sms = Mensagem.findById(Mensagem.class,1);
                    sms.setConteudo(etConteudo.getText().toString());
                    sms.save();
                }

                Toast.makeText(getApplicationContext(),"Mensagem Salva", Toast.LENGTH_SHORT).show();
                //msg.enviarSMS(1,"vai");
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

}
