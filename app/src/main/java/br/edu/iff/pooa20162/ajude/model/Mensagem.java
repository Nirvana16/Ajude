package br.edu.iff.pooa20162.ajude.model;

import android.telephony.SmsManager;
import android.util.Log;

import com.orm.SugarRecord;

/**
 * Created by Nirvana16 on 19/12/16.
 */

public class Mensagem extends SugarRecord {

    // Atributo para o Banco de dados
    private Long id;

    private String conteudo;

//    public List<Contato> getContatos(){
//        return Contato.find(Contato.class, "mensagem = ?", String.valueOf(this.getId()));
//    }

//    private Contato contato;
//
//    public Contato getContato() {
//        return contato;
//    }
//
//    public void setContato(Contato contato) {
//        this.contato = contato;
//    }

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

        String CodigoPais = "+55";
        Mensagem msg = Mensagem.findById(Mensagem.class,1);
        Contato contato = new Contato();
        contato = contato.findById(Contato.class,1);


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
