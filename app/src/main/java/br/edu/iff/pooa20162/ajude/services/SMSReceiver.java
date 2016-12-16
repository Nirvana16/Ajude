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
import br.edu.iff.pooa20162.ajude.R;


public class SMSReceiver extends BroadcastReceiver {

    private MediaPlayer mp;
    private Context context;


    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Telephony.Sms.Intents.SMS_RECEIVED_ACTION)) {
            SmsMessage[] smsMessages = Telephony.Sms.Intents.getMessagesFromIntent(intent);
            for (SmsMessage message : smsMessages) {
                // Do whatever you want to do with SMS.
                String telefone = message.getDisplayOriginatingAddress();

                String quemEnviou = telefone;
                String messagem = message.getDisplayMessageBody();

                Log.v("TELEFONE = ", quemEnviou);
                Log.v("MENSAGEM = ", messagem);

                //Toast toast = Toast.makeText(context, "Quem enviou : " + quemEnviou + ", Msg : " + messagem, Toast.LENGTH_LONG);
                //toast.show();
                if (messagem.equalsIgnoreCase("cebola!")) {
                    mp = MediaPlayer.create(context, R.raw.alarme);
                    mp.start();
                }
            }
        }
    }
}