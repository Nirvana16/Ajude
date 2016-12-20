package br.edu.iff.pooa20162.ajude.model;

import android.telephony.SmsManager;

import com.orm.SugarRecord;

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



//    public void enviarSMS() {
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
//            smsManager.sendTextMessage(objContato.getTelefone(), null, "ATENCAO!! !" + objContato.getNome() + "\n" + conteudo, null, null);
//        }
//    }

    public void enviarSMS(String conteudo, int Qtdrepeticoes, String localizacao) {

        Contato objContato = new Contato();
        /*
           SmsManager, API que faz toda a magica acontecer.
           lembrar de ler a documentação mais a fundo
           https://developer.android.com/reference/android/telephony/SmsManager.html
         */
        SmsManager smsManager = SmsManager.getDefault();

        if (conteudo.equalsIgnoreCase(null)){
            conteudo = "\nPRECISO DE AJUDA";
        }
        // O for serve para enviar multiplas mensagens, haverá um parametro na tela de configurações
        // Onde o usuário poderá definir quantas mensagens ele quer enviar. Por ora coloquei 4.

        for (int i = 0; i < Qtdrepeticoes; i++) {
            smsManager.sendTextMessage(objContato.getTelefone(), null, "ATENCAO!! !"+objContato.getNome()+
                    "\n"+conteudo+"\nEstou em:"+localizacao, null, null);
        }
    }
}
