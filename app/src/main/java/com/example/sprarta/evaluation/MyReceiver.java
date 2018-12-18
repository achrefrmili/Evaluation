package com.example.sprarta.evaluation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
float res;
String simc,affiche;
    public void onReceive(Context context, Intent intent) {
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
            Toast.makeText(context, affiche, Toast.LENGTH_LONG).show();


    }
}
