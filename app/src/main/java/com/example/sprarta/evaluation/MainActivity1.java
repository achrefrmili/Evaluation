package com.example.sprarta.evaluation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity1  extends AppCompatActivity implements View.OnClickListener {
    EditText taille;
    EditText poids;
    Button calcul,raz;
    TextView res;
    RadioGroup unite;
    String affiche;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcul=(Button)findViewById(R.id.calcul);
        calcul.setOnClickListener(this);
        raz=(Button)findViewById(R.id.raz);
        raz.setOnClickListener(this);
        poids=(EditText) findViewById(R.id.poids);
        taille=(EditText) findViewById(R.id.taille);
        unite=(RadioGroup)findViewById(R.id.unite);
        res =(TextView)findViewById(R.id.res);

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
                    if (imc <16.5){
                        affiche="dénutration";
                    }else
                    if(imc<18.5){
                        affiche="maigreur";
                    }else
                    if(imc<25){
                        affiche="corpulence normal";
                    }else
                    if(imc<30){
                        affiche="surpoids";
                    }else
                    if(imc<35){
                        affiche="modérée";
                    }else {
                        affiche="obésité morbide ou  massive";
                    }
                   // Toast.makeText(this, affiche, Toast.LENGTH_LONG).show();

                   res.setText(affiche);
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
