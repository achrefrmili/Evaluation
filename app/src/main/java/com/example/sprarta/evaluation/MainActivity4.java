package com.example.sprarta.evaluation;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity implements View.OnClickListener{
    MyReceiver receiver;
    IntentFilter intentFilter;
    EditText taille;
    EditText poids;
    Button calcul,raz;
    TextView res;
    RadioGroup unite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        receiver = new MyReceiver();
        intentFilter = new IntentFilter("com.exemple.sprarta.SOME_ACTION");
        registerReceiver(receiver,intentFilter);

        setContentView(R.layout.activity_main);
        res = (TextView) findViewById(R.id.res);
        calcul=(Button)findViewById(R.id.calcul);
        calcul.setOnClickListener(this);
        raz=(Button)findViewById(R.id.raz);
        raz.setOnClickListener(this);
        poids=(EditText) findViewById(R.id.poids);
        taille=(EditText) findViewById(R.id.taille);
        unite=(RadioGroup)findViewById(R.id.unite);


    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.calcul:
                String tai = taille.getText().toString();
                String poi = poids.getText().toString();
                float t = Float.valueOf(tai);
                if (t == 0) {
                    Toast.makeText(this, "Taille non coherente", Toast.LENGTH_LONG).show();
                } else {
                    float p = Float.valueOf(poi);
                    if (unite.getCheckedRadioButtonId() == R.id.centimetre)
                        t = t / 100;
                    t = (float) Math.pow(t, 2);
                    float imc = p / t;

                    Intent intent = new Intent("com.exemple.sprarta.SOME_ACTION");
                    //intent.setAction("");
                    intent.putExtra("imc", imc);
                    sendBroadcast(intent);
                }
                break;
            case R.id.raz:
                taille.setText("");
                poids.setText("");
                break;
            default:
                break;

        }
    }

}
