package br.edu.iff.pooa20162.ajude.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class service extends Service{
    private static final String TAG = "AjudeService";
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    public void onDestroy() {
        Toast.makeText(this, "O servico Ajude parou", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public void onStart(Intent intent, int startid)
    {
        Intent intents = new Intent(getBaseContext(),SMSReceiver.class);
        intents.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intents);
        Toast.makeText(this, "O Servico Ajude foi iniciado", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onStart");
    }
}