package br.edu.iff.pooa20162.ajude;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;

public class MessengerActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);
    }

    public void EnviarSMS(){
        // Classe SmsManager, API que faz toda a magica acontecer.
        // lembrar de ler a documentação mais a fundo
        // https://developer.android.com/reference/android/telephony/SmsManager.html
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage("+5522997254145", null, "ATENCAO PRECISO DE AJUDA \n Estou em: LOCALIZACAO", null, null);
    }
}
