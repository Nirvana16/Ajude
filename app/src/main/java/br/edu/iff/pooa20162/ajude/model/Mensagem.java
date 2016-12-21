package br.edu.iff.pooa20162.ajude.model;

import android.content.Intent;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;

import com.orm.SugarRecord;

import br.edu.iff.pooa20162.ajude.MainActivity;
import br.edu.iff.pooa20162.ajude.MensagemActivity;

/**
 * Created by Nirvana16 on 19/12/16.
 */

public class Mensagem extends SugarRecord {

    // Atributo para o Banco de dados
    private Long id;

    // Provisório até implementar a classe Local.
    //private String conteudo = "\nPRECISO DE AJUDA \n Estou em: LOCALIZACAO";
    private String conteudo;


    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }


    public Mensagem(){}

    public Mensagem(String conteudo){
        this.conteudo = conteudo;
    }

    public void enviarSMS(int Qtdrepeticoes, String localizacao) {

        Mensagem msg = Mensagem.findById(Mensagem.class,1);

        Contato objContato = new Contato();
        /*
           SmsManager, API que faz toda a magica acontecer.
           lembrar de ler a documentação mais a fundo
           https://developer.android.com/reference/android/telephony/SmsManager.html
         */
        SmsManager smsManager = SmsManager.getDefault();

        if (msg == null || msg.conteudo.equalsIgnoreCase("")){
            Log.v("MSG EH","NULO");
            String sms = "Preciso de ajuda Urgente!!!";
            msg = new Mensagem(sms);
            msg.save();
        }
        else{
            String sms = msg.conteudo;
        }
        for (int i = 0; i < Qtdrepeticoes; i++) {
            smsManager.sendTextMessage(objContato.getTelefone(), null, "ATENCAO!! !"+objContato.getNome()+
                    "\n"+msg.conteudo+"\nEstou em:"+localizacao, null, null);

        }
    }
}
