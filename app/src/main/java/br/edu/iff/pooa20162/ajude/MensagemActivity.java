package br.edu.iff.pooa20162.ajude;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;

public class MensagemActivity extends AppCompatActivity {

// Variaveis locais ====================================================================

    private String nome, telefone, conteudo;
// Atributos de referencia para o relacionamento entre classes =========================

// Getters and Setters ================================================================

//    public ContatoActivity getContato() {
//        return contato;
//    }
//
//    public void setContato(ContatoActivity contato) {
//        this.contato = contato;
//    }

// Metodos construtores =================================================================



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensagem);

    }


    // Metodo para efetuar o envio de sms
    // Futuraemente irei implementar esse método para que ele busque o texto inserido pelo
    // usuario.
    // Vou precisar capturar o numero do contato, passar para String assim e fazer o mesmo
    // Com o Texto da mensagem.
    public void EnviarSMS(){

        ContatoActivity objContato = new ContatoActivity();

        nome = objContato.getNome();
        telefone = objContato.getTelefone();
        conteudo = "\nPRECISO DE AJUDA \n Estou em: LOCALIZACAO";

        // SmsManager, API que faz toda a magica acontecer.
        // lembrar de ler a documentação mais a fundo
        // https://developer.android.com/reference/android/telephony/SmsManager.html
        SmsManager smsManager = SmsManager.getDefault();
        // O for serve para enviar multiplas mensagens, haverá um parametro na tela de configurações
        // Onde o usuário poderá definir quantas mensagens ele quer enviar. Por ora coloquei 4.

        for (int i = 0; i < 4; i++) {
            smsManager.sendTextMessage(telefone, null, "ATENCAO "+nome+conteudo, null, null);
        }


//        for (int i = 0; i < 4; i++) {
//            smsManager.sendTextMessage("+5522997254145", null, "ATENCAO PRECISO DE AJUDA \n Estou em: LOCALIZACAO", null, null);
//        }
    }
}
