package com.example.sprarta.evaluation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener{


    private final String msg_defaut ="Vous devezcliquer sur le bouton `Calculer IMC ` pour obtenir une resultats";
    EditText taille;
    EditText poids;
    Button calcul,raz;
    TextView res;
    RadioGroup unite;
    RadioButton cm,m;

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
                    Bundle sac = new Bundle();
                    sac.putFloat("imc", imc);
                    Intent intent = new Intent(this, MyService.class);
                    intent.putExtras(sac);
                    startService(intent);
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
