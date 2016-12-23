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

    private Contato contato;
    private String conteudo;

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

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
        contato = contato.findById(Contato.class,1);
        String CodigoPais = "+55";

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
        for (int i = 0; i < Qtdrepeticoes; i++) {
            smsManager.sendTextMessage(CodigoPais+contato.getTelefone().toString(), null, "ATENCAO!! ! "+contato.getNome().toString()+
                    "\n"+msg.conteudo+"\nEstou em:"+localizacao, null, null);

        }
    }
}
