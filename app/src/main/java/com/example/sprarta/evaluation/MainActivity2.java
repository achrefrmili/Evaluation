package com.example.sprarta.evaluation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{


        EditText taille;
        EditText poids;
        Button calcul, raz;
        RadioGroup unite;

        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcul = (Button) findViewById(R.id.calcul);
        calcul.setOnClickListener(this);
        raz = (Button) findViewById(R.id.raz);
        raz.setOnClickListener(this);
        poids = (EditText) findViewById(R.id.poids);
        taille = (EditText) findViewById(R.id.taille);
        unite = (RadioGroup) findViewById(R.id.unite);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.calcul:
                String tai = taille.getText().toString();
                String poi = poids.getText().toString();
                float  t=0;
                t = Float.valueOf(tai);
                float p=0;
                p = Float.valueOf(poi);
                if (t==0|| p==0) {
                    Toast.makeText(this, "Taille non coherente", Toast.LENGTH_LONG).show();
                } else {

                    if (unite.getCheckedRadioButtonId() == R.id.centimetre)
                        t = t / 100;
                    t = (float) Math.pow(t, 2);
                    float imc = p / t;

                    Intent intent = new Intent(MainActivity2.this, MainActivity2_1.class);
                    intent.putExtra("imc", imc);
                    startActivity(intent);
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



