package br.edu.iff.pooa20162.ajude.model;

import android.telephony.SmsManager;

/**
 * Created by Nirvana161 on 19/12/16.
 */

public class Mensagem {

    private String conteudo = "\nPRECISO DE AJUDA \n Estou em: LOCALIZACAO";


    public void EnviarSMS() {

        Contato objContato = new Contato();
        /*
           SmsManager, API que faz toda a magica acontecer.
           lembrar de ler a documentação mais a fundo
           https://developer.android.com/reference/android/telephony/SmsManager.html
         */
        SmsManager smsManager = SmsManager.getDefault();
        // O for serve para enviar multiplas mensagens, haverá um parametro na tela de configurações
        // Onde o usuário poderá definir quantas mensagens ele quer enviar. Por ora coloquei 4.

        for (int i = 0; i < 4; i++) {
            smsManager.sendTextMessage(objContato.getTelefone(), null, "ATENCAO! " + objContato.getNome() + "\n" + conteudo, null, null);
        }
    }
}
