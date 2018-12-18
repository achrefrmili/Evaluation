package com.example.sprarta.evaluation;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;
import android.os.Bundle;

public class MyService extends Service {
    private float res ;
    private String affiche;
    public int onStartCommand(Intent intent, int flags, int startId){
        Bundle infoIMC = intent.getExtras();
        if(infoIMC!=null){
            res = infoIMC.getFloat("imc");
            if (res <16.5){
                affiche="dénutration";
            }else
            if(res<18.5){
                affiche="maigreur";
            }else
            if(res<25){
                affiche="corpulence normal";
            }else
            if(res<30){
                affiche="surpoids";
            }else
            if(res<35){
                affiche="modérée";
            }else {
                affiche="obésité morbide ou  massive";
            }
        }
        Toast.makeText(getBaseContext(),affiche,Toast.LENGTH_LONG).show();

        return START_STICKY;
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
