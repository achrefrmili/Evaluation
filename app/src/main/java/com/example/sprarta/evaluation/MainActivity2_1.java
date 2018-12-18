package com.example.sprarta.evaluation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2_1 extends AppCompatActivity implements View.OnClickListener {
    private Button ok ;
    private TextView tv;
    private String affiche;
    private float res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_1);
        tv =(TextView)findViewById(R.id.textView3);

        Bundle info = this.getIntent().getExtras();
        if(info != null){
            res = info.getFloat("imc");
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
        tv.setText(affiche);
        ok = (Button) findViewById(R.id.button);
        ok.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
    }
}
