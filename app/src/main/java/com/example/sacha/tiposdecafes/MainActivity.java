package com.example.sacha.tiposdecafes;

import android.content.Intent;
import android.net.Uri;
import android.os.StrictMode;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.sacha.tiposdecafes.MESSAGE";

    private CheckBox checkCrema;
    private CheckBox checkAzucar;

    private RadioButton cafeDescafeinado;
    private RadioButton cafeExpresso;
    private RadioButton cafeSolidario;

    private Button buttonBuscar;

    String textToCafe(){
        String cadena = "Pedido: cafe";

        if(cafeDescafeinado.isChecked()){
            cadena += "Descafeinado";
        } else if(cafeExpresso.isChecked()){
            cadena += "Expresso";
        }else if(cafeSolidario.isChecked()){
            cadena += "Solidario";
        }

        if(checkAzucar.isChecked()){
            cadena +=" con azucar";
        }

        if(checkCrema.isChecked()){
            cadena +=" y crema de leche";
        }else{
            cadena += " con crema de leche";
        }
        return cadena;
    }//textToCafe

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkCrema = (CheckBox) findViewById(R.id.checkCrema);
        checkAzucar = (CheckBox) findViewById(R.id.checkAzucar);
        cafeDescafeinado = (RadioButton) findViewById(R.id.cafeDescafeinado);
        cafeExpresso = (RadioButton) findViewById(R.id.cafeExpresso);
        cafeSolidario = (RadioButton) findViewById(R.id.cafeSolidario);

        buttonBuscar = (Button) findViewById(R.id.buttonBuscar);

        buttonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myUriString ="http://www.google.com/#q=" + "cafe";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(myUriString));
                startActivity(intent);
            }
        });

    }//onCreate

    public void pagar(View view){
        Intent intent = new Intent(this,NewActivity.class);
        intent.putExtra(EXTRA_MESSAGE,textToCafe());
        startActivity(intent);

    }
}
