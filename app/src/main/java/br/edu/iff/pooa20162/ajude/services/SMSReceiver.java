package br.edu.iff.pooa20162.ajude.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import br.edu.iff.pooa20162.ajude.MainActivity;
import br.edu.iff.pooa20162.ajude.MensagemActivity;
import br.edu.iff.pooa20162.ajude.PacienteActivity;
import br.edu.iff.pooa20162.ajude.PacienteAjudaActivity;
import br.edu.iff.pooa20162.ajude.R;


public class SMSReceiver extends BroadcastReceiver {

    private MediaPlayer mp;
    private Context context;


    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Telephony.Sms.Intents.SMS_RECEIVED_ACTION)) {
            SmsMessage[] smsMessages = Telephony.Sms.Intents.getMessagesFromIntent(intent);
            for (SmsMessage message : smsMessages) {
                // Acoes devem ser postas a seguir......
                String telefone = message.getDisplayOriginatingAddress();
                String quemEnviou = telefone;
                String messagem = message.getDisplayMessageBody();

                // Apenas para debug
                Log.v("TELEFONE = ", quemEnviou);
                Log.v("MENSAGEM = ", messagem);

                //Toast toast = Toast.makeText(context, "Quem enviou : " + quemEnviou + ", Msg : " + messagem, Toast.LENGTH_LONG);
                //toast.show();
                //Futuramente vou trocar essa palavra chave
                //Farei uma condicional para verificar se o numero de quem enviou é o numero do Paciente
                //Havendo a combinação Numero Paciente + Codigo Chave o alarme será ativado no aparelho alvo.
                if (messagem.equalsIgnoreCase("123")) {
                    mp = MediaPlayer.create(context, R.raw.alarme);
                    mp.start();

                    Intent open = new Intent(context, PacienteAjudaActivity.class);
                    open.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(open);
                }
            }
        }
    }
}